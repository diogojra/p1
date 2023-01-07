import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Empresa {
    private String nome;
    private ArrayList<Camiao> Camioes;
    private HashSet<Hub> Mapa;
    private ArrayList<Servico> servicos;

    public Empresa(String nome){
        this.nome = nome;
        this.Camioes = new ArrayList<Camiao>();
        this.Mapa = new HashSet<Hub>();
        this.servicos = new ArrayList<Servico>();
    }


    public void criar_hubs_default(){
        Hub Madrid = new Hub("Madrid",true);
        Madrid.addLigacao("Barcelona",630);
        Madrid.addLigacao("Porto",560);
        Madrid.addLigacao("Lisboa",625);

        Hub Lisboa = new Hub("Lisboa",true);
        Lisboa.addLigacao("Madrid",625);
        Lisboa.addLigacao("Porto",300);
        Hub Porto = new Hub("Porto",false);
        Porto.addLigacao("Madrid",560);
        Hub barcelona = new Hub("Barcelona",true);
        barcelona.addLigacao("Paris",1035);
        Hub Paris = new Hub("Paris",true);
        Paris.addLigacao("Porto",1574);

        this.Mapa.add(Madrid);
        this.Mapa.add(Lisboa);
        this.Mapa.add(Porto);
        this.Mapa.add(barcelona);
        this.Mapa.add(Paris);

    }
    public void criar_camioes_default(){
        Camiao c1= new Camiao("00-AA-00","Madrid",7, true);
        Camiao c2 = new Camiao("00-AA-01","Madrid",15, false);
        Camiao c3 = new Camiao("00-AA-02","Madrid",3, true);
        Camiao c4 = new Camiao("00-AA-03","Lisboa",7, false);
        Camiao c5 = new Camiao("00-AA-04","Lisboa",15, true);
        Camiao c6 = new Camiao("00-AA-05","Lisboa",3, false);
        Camiao c7 = new Camiao("00-AA-06","Porto",7, true);
        Camiao c8 = new Camiao("00-AA-07","Porto",15, false);
        Camiao c9 = new Camiao("00-AA-08","Porto",3, true);
        Camiao c10 = new Camiao("00-AA-09","Barcelona",7, false);
        Camiao c11 = new Camiao("00-AA-10","Barcelona",15, true);
        Camiao c12 = new Camiao("00-AA-11","Barcelona",3, false);
        Camiao c13 = new Camiao("00-AA-12","Paris",7, true);
        Camiao c14 = new Camiao("00-AA-13","Paris",15, false);
        Camiao c15 = new Camiao("00-AA-14","Paris",3, true);

        this.Camioes.add(c1);
        this.Camioes.add(c2);
        this.Camioes.add(c3);
        this.Camioes.add(c4);
        this.Camioes.add(c5);
        this.Camioes.add(c6);
        this.Camioes.add(c7);
        this.Camioes.add(c8);
    }
    public void addCamiao(Camiao c){
        this.Camioes.add(c);
    }

    public void addHub(Hub h){
        this.Mapa.add(h);
    }

    public void camioes_to_hubs(){
        for(Camiao c: this.Camioes){
            for(Hub h: this.Mapa){
                if(c.getLocalizacao().equals(h.getNome())){
                    h.addCamiao(c.clone());
                }
            }
        }
    }
    public void String() {
        System.out.println("Empresa: " + this.nome + "\n");
        System.out.println("Mapa:");

        Iterator<Hub> iterador = this.Mapa.iterator();
        while (iterador.hasNext()) {
            Hub hub = iterador.next();
            System.out.print( hub.getNome()+"\t");
        }

        System.out.println("Camioes: ");
        Iterator<Camiao> i = this.Camioes.iterator();
        while (i.hasNext()) {
            Camiao camiao = i.next();
            System.out.print( camiao.getLocalizacao()+"\t");
        }
        System.out.println("Servicos: " + this.servicos + "\n");
    }
}
