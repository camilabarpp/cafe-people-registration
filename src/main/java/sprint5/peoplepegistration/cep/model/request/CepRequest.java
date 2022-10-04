package sprint5.peoplepegistration.cep.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class CepRequest {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public CepRequest(builder builder) {
        this.cep = builder.cep;
        this.logradouro = builder.logradouro;
        this.bairro = builder.bairro;
        this.localidade = builder.localidade;
        this.uf = builder.uf;
    }

    @Getter
    @NoArgsConstructor
    public static class builder {
        private String cep;
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;

        public builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public builder logradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public builder bairro(String bairro) {
            this.bairro = bairro;
            return  this;
        }

        public builder localidade(String localidade) {
            this.localidade = localidade;
            return this;
        }

        public builder uf(String uf) {
            this.uf = uf;
            return this;
        }

        public CepRequest build() {
            return new CepRequest(this);
        }
    }
}
