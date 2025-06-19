package org.br.com.api.model.usuarios;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCms {
    private String nomeCompleto;
    private String nomeUsuario;
    private String email;
    private String senha;
} 