import java.util.ArrayList;
import java.util.List;

class Test {
    public Test(Double d) {
        this.d = d;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    Double d;
}

public class Main {
    public static void main(String[] args) {
        Test t = new Test(4.0);
        if (t.getD() > 0.0)
            System.out.println("Value of D : " + t.getD());
        List<String> products = new ArrayList<String>();
        products.add("computer");
        products.add("phone");
        products.add("phone");
        products.add("mouse");
        products.add("keyboard");

        List<String> cart = new ArrayList<String>();
        cart.add("phone");
        cart.add("monitor");

        cart.forEach(item -> System.out.println(item + ": " + products.stream().filter(e -> e.equals(item)).count()));
    }
}