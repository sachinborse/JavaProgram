import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class OrderItem {
//
//    private String item;
//
//    OrderItem(String item) {
//        this.item = item;
//    }
//
//    public String getOrderItem() {
//        return item;
//    }
//}

class Order {
    private ArrayList<String> orderItem = new ArrayList<String>();

    public Order(ArrayList<String> orderItem) {
        this.orderItem = orderItem;
    }

    public ArrayList<String> getOrderItem() {
        return orderItem;
    }
}

public class Clov {
    public static void main(String[] args) {
        ArrayList<String> items1 = new ArrayList<String>();
        ArrayList<String> items2 = new ArrayList<String>();
        items1.add("Laptop");
        items1.add("Pen");
        items2.add("Laptop");
        items2.add("Pen");
        items2.add("Cup");
        Order order1 = new Order(items1);
        Order order2 = new Order(items2);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);

        Map<String, Integer> result = new HashMap<String, Integer>();
        result = getItemOrderCount(orders);

        if (!result.isEmpty()) {
            result.forEach((key, value) -> System.out.print(key + " : " + value + ", "));
        } else {
            System.out.println("Empty result");
        }
    }

    private static Map<String, Integer> getItemOrderCount(List<Order> orders) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (Order ord : orders) {
            for (String c : ord.getOrderItem()) {
                if (result.containsKey(c)) {
                    result.put(c, result.get(c) + 1);
                } else {
                    result.put(c, 1);
                }
            }
        }
        return result;
    }
}
