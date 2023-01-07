public class Servico {
    private int codigo;
    private int NIF_cliente;
    private int data;
    private String origem;
    private String destino;
    private double velocidade_media;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getNIF_cliente() {
        return NIF_cliente;
    }
    public void setNIF_cliente(int NIF_cliente) {
        this.NIF_cliente = NIF_cliente;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public double getVelocidade_media() {
        return velocidade_media;
    }
    public void setVelocidade_media(double velocidade_media) {
        this.velocidade_media = velocidade_media;
    }
    //public double duracao(Camiao c);

    public Servico clone(){
        Servico novo = new Servico();
        novo.setCodigo(this.codigo);
        novo.setNIF_cliente(this.NIF_cliente);
        novo.setData(this.data);
        novo.setOrigem(this.origem);
        novo.setDestino(this.destino);
        novo.setVelocidade_media(this.velocidade_media);
        return novo;
    }
}
