#version 330 core

in vec2 v_TexCoord;
in vec2 v_OneTexel;
uniform sampler2D u_Texture;

layout (std140) uniform FractureData {
    vec4 u_CellColor;
    vec4 u_SeamColor;
    vec4 u_Parameters; // cell size, seam width, halo intensity, shimmer phase
};
out vec4 color;

vec2 cellPoint(vec2 cell) {
    vec2 h = vec2(dot(cell, vec2(127.1, 311.7)), dot(cell, vec2(269.5, 183.3)));
    vec2 seed = fract(sin(h) * 43758.5453);
    float phase = u_Parameters.w * 6.2831853;
    return 0.20 + 0.60 * seed + 0.10 * sin(vec2(phase, phase + 1.5707963) + seed * 6.2831853);
}

void main() {
    float mask = texture(u_Texture, v_TexCoord).a;
    if (mask <= 0.0) {
        if (u_Parameters.z <= 0.0) discard;
        // Fixed-size neighborhood keeps halo work bounded independently of resolution.
        float nearby = 0.0;
        for (int i = 0; i < 8; i++) {
            float a = float(i) * 0.78539816339;
            vec2 direction = vec2(cos(a), sin(a)) * v_OneTexel;
            nearby = max(nearby, texture(u_Texture, v_TexCoord + direction * 3.0).a);
        }
        float halo = nearby * 0.35 * u_Parameters.z * u_SeamColor.a * u_CellColor.a;
        if (halo <= 0.0) discard;
        color = vec4(u_SeamColor.rgb, halo);
        return;
    }

    // A screen-space Voronoi pattern fills the entity mask; it is not model UV mapped.
    vec2 p = gl_FragCoord.xy / max(u_Parameters.x, 1.0);
    vec2 grid = floor(p);
    vec2 local = fract(p);
    float first = 10.0;
    float second = 10.0;
    vec2 nearest = vec2(0.0);
    for (int y = -1; y <= 1; y++) {
        for (int x = -1; x <= 1; x++) {
            vec2 offset = vec2(x, y);
            vec2 delta = offset + cellPoint(grid + offset) - local;
            float distanceSquared = dot(delta, delta);
            if (distanceSquared < first) {
                second = first;
                first = distanceSquared;
                nearest = grid + offset;
            } else if (distanceSquared < second) second = distanceSquared;
        }
    }
    float boundary = sqrt(second) - sqrt(first);
    float pixelWidth = u_Parameters.y / max(u_Parameters.x, 1.0);
    float antialias = 1.0 / max(u_Parameters.x, 1.0);
    float seam = 1.0 - smoothstep(pixelWidth, pixelWidth + antialias, boundary);
    float variation = fract(sin(dot(nearest, vec2(41.0, 289.0))) * 951.1357);
    float pulse = 0.92 + 0.08 * sin(u_Parameters.w * 6.2831853 + variation * 6.2831853);
    vec3 cell = u_CellColor.rgb * mix(0.55, 1.05, variation);
    vec3 surface = mix(cell, u_SeamColor.rgb * pulse, seam * u_SeamColor.a);
    color = vec4(surface, mask * u_CellColor.a);
}
