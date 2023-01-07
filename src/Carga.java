public abstract class Carga {
    private int codigo;
    private int cubicagem;
    private double peso;


    public abstract double consumo();
    public abstract double preco();

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCubicagem() {
        return cubicagem;
    }
    public void setCubicagem(int cubicagem) {
        this.cubicagem = cubicagem;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
