package org.br.com.api.tokens;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
public class GerarTokenResquest {
    private String email;
    private String senha;
}
