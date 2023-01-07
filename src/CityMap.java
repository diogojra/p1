import java.util.HashMap;
import java.util.Map;

public class CityMap {
    
    public Map<String,City> graph;

    public Integer inf = 999999;

    public CityMap(Map<String,City> graph) {
        this.graph = graph;
    }

    public void add_city(String city_name, City city) {
        this.graph.put(city_name, city);
    }

    public void remove_city(String city_name) {
        this.graph.remove(city_name);
    }

    public Map<Map<String, String>, Integer> get_max_distance() {
        Integer max_distance = 0 ;
        Map<String, String> target = new HashMap<>();
        for(String from_city_name: this.graph.keySet()) {
            for(String to_city_name: this.graph.keySet()) {
                Integer result_distance = this.get_min_distance(from_city_name, to_city_name);
                if (result_distance > max_distance) {
                    max_distance = result_distance;
                    target.put(from_city_name, to_city_name);
                }
            }
        }

        Map<Map<String, String>, Integer>return_map = new HashMap<>();
        return_map.put(target, max_distance);
        
        System.out.println(return_map.keySet().toArray()[0]);
        return return_map;
    }

    public Integer get_min_distance(String city_name,String target_city_name) {
        Map<String, Integer> distance = new HashMap<>();

        for(String key: this.graph.keySet()) {
            distance.put(key, inf);
        }

        distance.put(city_name, 0);

        for(int i=0; i < this.graph.size()-1; i++) {
            for(String from_city_name: this.graph.keySet()) {
                for(String to_city_name: this.graph.get(from_city_name).connect_map.keySet()){
                    Integer i1 = distance.get(to_city_name);
                    Integer i2 = this.graph.get(from_city_name).connect_map.get(to_city_name);
                    Integer i3 = distance.get(from_city_name);
                    if (i1 > (i2 + i3)) {
                        distance.put(
                            to_city_name,
                            this.graph.get(from_city_name).connect_map.get(to_city_name) + distance.get(from_city_name)
                        );
                    }
                }
            }
        }

        for(String from_city_name: this.graph.keySet()) {
            for(String to_city_name: this.graph.get(from_city_name).connect_map.keySet()) {
                if (distance.get(to_city_name) > 
                (distance.get(from_city_name) + this.graph.get(from_city_name).connect_map.get(to_city_name))) {
                    return null;
                }
            }
        }
        
        return distance.get(target_city_name);
    }
}
