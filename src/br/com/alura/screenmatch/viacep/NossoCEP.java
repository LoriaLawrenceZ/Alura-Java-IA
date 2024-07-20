package br.com.alura.screenmatch.viacep;

public class NossoCEP {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;

    public NossoCEP(CEP cep) {
        this.cep = cep.cep();
        this.logradouro = cep.logradouro();
        this.complemento = cep.complemento();
        this.unidade = cep.unidade();
        this.bairro = cep.bairro();
        this.localidade = cep.localidade();
        this.uf = cep.uf();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }
}
