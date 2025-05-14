package com.criptoinvest.models;

public class Empresa extends Usuario {

        private String setor;

        public Empresa() {}

        public Empresa(Long id, String nome, String setor) {
           super(id, nome, null, null, "Empresa");
           this.setor = setor;
        }

        public String getSetor() { return setor; }
        public void setSetor(String setor) { this.setor = setor; }

        public void exbirDados() { System.out.println("Empresa:"+ getNome() +  " setor:"+ setor); }

    }

