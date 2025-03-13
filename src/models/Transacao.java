package models;

public class Transacao {
    private Long id;
    private Long carteiraId;
    private String tipo; // Compra ou Venda
    private double valor;
    private String data;

    public Transacao() {}

    public Transacao(Long id, Long carteiraId, String tipo, double valor, String data) {
        this.id = id;
        this.carteiraId = carteiraId;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCarteiraId() { return carteiraId; }
    public void setCarteiraId(Long carteiraId) { this.carteiraId = carteiraId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
