public class Product {
    private final String name;
    private final double cost;

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
