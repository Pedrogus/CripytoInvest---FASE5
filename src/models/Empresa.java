package models;

public class Empresa {

        private Long id;
        private String nome;
        private String setor;

        public Empresa() {}

        public Empresa(Long id, String nome, String setor) {
            this.id = id;
            this.nome = nome;
            this.setor = setor;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getSetor() { return setor; }
        public void setSetor(String setor) { this.setor = setor; }
    }

