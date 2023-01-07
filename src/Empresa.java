import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Empresa {
    
    private String nome;
    private ArrayList<Camiao> Camioes;
    private Map<String,Hub> Mapa;
    private ArrayList<Servico> servicos;

    public Empresa(String nome){
        this.nome = nome;
        this.Camioes = new ArrayList<Camiao>();
        this.Mapa = new HashMap<String,Hub>();
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
        Hub Barcelona = new Hub("Barcelona",true);
        Barcelona.addLigacao("Paris",1035);
        
        Hub Paris = new Hub("Paris",true);
        Paris.addLigacao("Porto",1574);

        this.Mapa.put("Madrid", Madrid);
        this.Mapa.put("Lisboa", Lisboa);
        this.Mapa.put("Porto", Porto);
        this.Mapa.put("Barcelona", Barcelona);
        this.Mapa.put("Paris", Paris);

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

    public void addHub(String h_nome,Hub h){
        this.Mapa.put(h_nome, h);
    }

    public void removeHub(String h_nome){
        this.Mapa.remove(h_nome);
    }

    public Map<String,Object> get_min_route(String from_hub_nome, String to_hub_nome) {

        Map<String, Integer> routeDistance = new HashMap<>();
        Map<String, String> routeMap = new HashMap<>();

        Integer inf = 99999999;

        for(String key: this.Mapa.keySet()) {
            routeDistance.put(key, inf);
            routeMap.put(key, "null");
        }

        routeDistance.put(from_hub_nome, 0);

        for(int i=0; i < this.Mapa.size()-1; i++) {
            for(String from_city_name: this.Mapa.keySet()) {
                for(String to_city_name: this.Mapa.get(from_city_name).ligacoes.keySet()){
                    Integer i1 = routeDistance.get(to_city_name);
                    Integer i2 = this.Mapa.get(from_city_name).ligacoes.get(to_city_name);
                    Integer i3 = routeDistance.get(from_city_name);
                    if (i1 > (i2 + i3)) {
                        routeDistance.put(to_city_name,
                            this.Mapa.get(from_city_name).ligacoes.get(to_city_name) + routeDistance.get(from_city_name)
                        );
                        routeMap.put(to_city_name, from_city_name);
                    }
                }
            }
        }

        for(String from_city_name: this.Mapa.keySet()) {
            for(String to_city_name: this.Mapa.get(from_city_name).ligacoes.keySet()) {
                if (routeDistance.get(to_city_name) > 
                (routeDistance.get(from_city_name) + this.Mapa.get(from_city_name).ligacoes.get(to_city_name))) {
                    return null;
                }
            }
        }

        Integer minDistance = routeDistance.get(to_hub_nome);

        List<String> route = new ArrayList<String>();
        route.add(to_hub_nome);
        String n;
        do {
            n = routeMap.get(to_hub_nome);
            route.add(n);
            to_hub_nome = n;
        } while(routeMap.get(to_hub_nome) != "null");

        Collections.reverse(route);

        Map<String,Object> r = new HashMap<String,Object>();
        r.put("minDistance", minDistance);
        r.put("route", route);

        return r;
    }


    public void camioes_to_hubs(){
        for(Camiao c: this.Camioes){
            for(Hub h: this.Mapa.values()){
                if(c.getLocalizacao().equals(h.getNome())){
                    h.addCamiao(c.clone());
                }
            }
        }
    }
    
    public void String() {
        System.out.println("Empresa: " + this.nome + "\n");
        System.out.println("Mapa:");

        for(String h_nome: this.Mapa.keySet()) {
            System.out.print( h_nome+"\t");
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
