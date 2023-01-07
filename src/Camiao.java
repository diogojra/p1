
import java.util.ArrayList;

public class Camiao {
    private String matricula;
    private String localizacao;
    private int cubicagem;

    private boolean refrigeracao;
    private ArrayList<Servico> atuais;
    private ArrayList<Servico> historico;

    public Camiao(){}
    public Camiao(String matricula, String localizacao, int cubicagem,boolean refrigeracao) {
        this.matricula = matricula;
        this.localizacao = localizacao;
        this.cubicagem = cubicagem;
        this.atuais = new ArrayList<Servico>();
        this.historico = new ArrayList<Servico>();
    }

    public String getMatricula() {
        return this.matricula;
    }
    public String getLocalizacao() {
        return this.localizacao;
    }
    public int getCubicagem() {
        return this.cubicagem;
    }
    private boolean getRefrigeracao() {
        return this.refrigeracao;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public void setCubicagem(int cubicagem) {
        this.cubicagem = cubicagem;
    }

    public void getAtuais() {
        System.out.println("Serviços atuais:");
        for(Servico s: atuais){
            System.out.println(s.toString());
        }
    }
    public void getHistorico() {
        System.out.println("Histórico de serviços:");
        for(Servico s: historico){
            System.out.println(s.toString());
        }
    }


    public Camiao clone(){
        Camiao novo = new Camiao();
        for(Servico s: atuais){
            novo.atuais.add(s.clone());
        }
        for(Servico s: historico){
            novo.historico.add(s.clone());
        }
        return novo;
    }



}