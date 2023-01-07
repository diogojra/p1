import java.util.HashMap;
import java.util.Map;

public class App {

    public static Map<String, Integer> Bellman_Ford(
        Map<String, Map<String, Integer>> graph, String target_city) {
        
            Map<String, Integer> distance = new HashMap<>();
            
            Integer inf = 999999;

            for(String key: graph.keySet()) {
                distance.put(key, inf);
            }
            distance.put(target_city, 0);

            for(int i=0; i < graph.size()-1; i++) {
                for(String from_city_name: graph.keySet()) {
                    for(String to_city_name: graph.get(from_city_name).keySet()) {
                        Integer i1 = distance.get(to_city_name);
                        Integer i2 = graph.get(from_city_name).get(to_city_name);
                        Integer i3 = distance.get(from_city_name);
                        if (i1 > (i2 + i3)) {
                            distance.put(
                                to_city_name,
                                graph.get(from_city_name).get(to_city_name) + distance.get(from_city_name)
                            );
                        }
                    }
                }
            }

            for(String from_city_name: graph.keySet()) {
                for(String to_city_name: graph.get(from_city_name).keySet()) {
                    if (distance.get(to_city_name) > distance.get(from_city_name) + graph.get(from_city_name).get(to_city_name)) {
                        return null;
                    }
                }
            }

            return distance;
    }

    public static void main(String[] args) throws Exception {

        // Bellman–Ford algorithm

        // Map<String,Map<String,Integer>> graph = new HashMap<>();

        // Map<String,Integer> Paris = new HashMap<>();
        // Paris.put("Porto", 1574);
        // graph.put("Paris", Paris);

        // Map<String,Integer> Porto = new HashMap<>();
        // Porto.put("Madrid", 560);
        // graph.put("Porto", Porto);

        // Map<String,Integer> Madrid = new HashMap<>();
        // Madrid.put("Lisboa", 625);
        // Madrid.put("Barcelona", 630);
        // graph.put("Madrid", Madrid);

        // Map<String,Integer> Lisboa = new HashMap<>();
        // Lisboa.put("Porto", 320);
        // Lisboa.put("Madrid", 625);
        // graph.put("Lisboa", Lisboa);

        // Map<String,Integer> Barcelona = new HashMap<>();
        // Barcelona.put("Paris", 1035);
        // graph.put("Barcelona", Barcelona);
        
        
        // Map<String, Integer> distance = new HashMap<>();
        // distance = Bellman_Ford(graph, "Lisboa");

        // System.out.println(distance);

        Map<String, Integer> Paris_connect_map = new HashMap<>();
        Paris_connect_map.put("Porto", 1574);
        City Paris = new City("Paris", Paris_connect_map);
        
        Map<String, Integer> Porto_connect_map = new HashMap<>();
        Porto_connect_map.put("Madrid", 560);
        City Porto = new City("Porto", Porto_connect_map);

        Map<String, Integer> Madrid_connect_map = new HashMap<>();
        Madrid_connect_map.put("Lisboa", 625);
        Madrid_connect_map.put("Barcelona", 630);
        City Madrid = new City("Madrid", Madrid_connect_map);

        Map<String, Integer> Lisboa_connect_map = new HashMap<>();
        Lisboa_connect_map.put("Porto", 320);
        Lisboa_connect_map.put("Madrid", 625);
        City Lisboa = new City("Lisboa", Lisboa_connect_map);

        Map<String, Integer> Barcelona_connect_map = new HashMap<>();
        Barcelona_connect_map.put("Paris", 1035);
        City Barcelona = new City("Barcelona", Barcelona_connect_map);

        Map<String,City> graph = new HashMap<>();

        graph.put(Paris.name, Paris);
        graph.put(Porto.name, Porto);
        graph.put(Madrid.name, Madrid);
        graph.put(Lisboa.name, Lisboa);
        graph.put(Barcelona.name, Barcelona);

        CityMap city_map = new CityMap(graph);

        System.out.println(city_map.get_max_distance());

    }
}
