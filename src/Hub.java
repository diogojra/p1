import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Hub {
    private String nome;
    private boolean refrigeracao;
    private HashMap<String,Integer> ligacoes;

    private ArrayList<Camiao> camioes;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean getRefrigeracao() {
        return refrigeracao;
    }
    public void sgetRefrigeracao(boolean refrigeracao) {
        this.refrigeracao = refrigeracao;
    }

    public Hub(){
        camioes = new ArrayList<>();
        this.nome = "Porto";
        this.refrigeracao = false;
        this.ligacoes.put("Madrid",560); //Q: O que faz?
    }
    public Hub(String nome, boolean refrigeracao){
        camioes = new ArrayList<>();
        this.nome = nome;
        this.refrigeracao = refrigeracao;
        this.ligacoes = new HashMap<String, Integer>();
    }
    public void addLigacao(String nome, int distancia){
        this.ligacoes.put(nome,distancia);
    }

    public void addCamiao(Camiao c){
        this.camioes.add(c);
    }


    public Hub clone(){
        Hub novo = new Hub(this.nome, this.refrigeracao); //Q: o que faz esta linha?
            for(String i : this.ligacoes.keySet()){
            novo.addLigacao(i,this.ligacoes.get(i));
        }
        return novo;
    }
    public boolean equals(){
        boolean igual = true;
        for(String i : this.ligacoes.keySet()) {
            if (this.ligacoes.get(i) != this.ligacoes.get(i)) {
                igual = false;
            }
        }
        if(this.nome.equals(this.getNome()) && this.refrigeracao==this.getRefrigeracao() && igual){
            return true;
        }else return false;
    }

    public void String(){
        System.out.println(this.getNome() + " " + this.getRefrigeracao() );
        for(String i : this.ligacoes.keySet()) {
            System.out.println(i + " " + this.ligacoes.get(i));
        }
    }
}
