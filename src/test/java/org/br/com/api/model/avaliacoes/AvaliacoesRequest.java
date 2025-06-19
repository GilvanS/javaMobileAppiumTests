package org.br.com.api.model.avaliacoes;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class AvaliacoesRequest {

    private String veiculo;
    private List<String> loteIds;
    private List<String> chavesNfe;
    private List<String> referenciasExternas;
    private String statusDeProcessamento;
    private Paginacao paginacao;

    @Getter
    @Setter
    @Builder
    public static class Paginacao {
        private Integer porPagina;
        private Integer pagina;
    }
} 