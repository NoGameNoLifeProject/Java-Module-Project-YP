public class Product {
    private String name;
    private double cost;

    Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s", name, cost, Formatter.getRubForm(cost));
    }
}
