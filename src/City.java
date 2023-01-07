import java.util.Map;

public class City {

    public String name;

    public Map<String,Integer> connect_map;

    public City(String city_name, Map<String,Integer> connect_map) {
        this.name = city_name;
        this.connect_map = connect_map;
    }
    
}