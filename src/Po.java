
import java.util.*;

class Data {
    Map<String, Double> input = new HashMap<>();

    public Map<String, Double> getData() {
        input.put("A6", 1.2);
        input.put("A7", 10.0);
        input.put("A8", 10.0);
        input.put("A9", 10.0);
        input.put("A10", 10.0);
        input.put("A11", 9.0);
        return sortByValue(input);
    }

    private Map<String, Double> sortByValue(Map<String, Double> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Double>> list =
                new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o2,
                               Map.Entry<String, Double> o1) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }
}

public class Po {
    public static void main(String[] args) {
        Map<String, Double> cal = new HashMap<>();
        int ct = 1;
        Double add = 0.0;
        Data d = new Data();
        Map<String, Double> m;
        m = d.getData();

        for (Map.Entry<String, Double> entry : m.entrySet()) {
            cal.put(entry.getKey(), entry.getValue());
            add += entry.getValue();
            if (add.equals(39.0)) {
                System.out.println("Set " + ct++ + " :: Count " + add);
                for (Map.Entry<String, Double> ent : cal.entrySet()) {
                    System.out.println("Column  = " + ent.getKey() + ", Measure  = " + ent.getValue());
//                    m.remove(ent.getKey());
                }
                cal.clear();
                continue;
            }
        }
//        System.out.println("Size  = " + m.size());
//        for (Map.Entry<String, Double> ent : m.entrySet()) {
//            System.out.println("Column  = " + ent.getKey() + ", Measure  = " + ent.getValue());
//        }
    }
}

