package com.criptoinvest.models;

public class Empresa extends Usuario {

    private String setor;
    private String cnpj;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String email,String senha, String setor, String cnpj) {
        super(id, nome, email, senha, "Empresa");
        this.setor = setor;
        this.cnpj = cnpj;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", setor='" + getSetor() + '\'' +
                '}';
    }
}
