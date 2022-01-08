import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("computer");
        products.add("phone");
        products.add("phone");
        products.add("mouse");
        products.add("keyboard");

        List<String> cart = new ArrayList<>();
        cart.add("phone");
        cart.add("monitor");

        cart.forEach(item -> System.out.println(item + ": " + products.stream().filter(e -> e.equals(item)).count()));
    }
}