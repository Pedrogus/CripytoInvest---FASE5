package models;

public class Carteira {

        private Long id;
        private Long usuarioId;
        private double saldo;

        public Carteira() {}

        public Carteira(Long id, Long usuarioId, double saldo) {
            this.id = id;
            this.usuarioId = usuarioId;
            this.saldo = saldo;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Long getUsuarioId() { return usuarioId; }
        public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

        public double getSaldo() { return saldo; }
        public void setSaldo(double saldo) { this.saldo = saldo; }
    }

