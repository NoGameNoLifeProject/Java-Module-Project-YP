
public class Main {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();
        MenuCollector menuCollector = new MenuCollector(inputProcessor);

        int count = inputProcessor.getPersonsCount();
        menuCollector.collectMenu();

        double sum = 0;
        for (Product product: menuCollector.getProducts()){
            sum += product.getCost();
        }
        System.out.printf("Общая сумма товаров: %.2f%n", sum);
        System.out.printf("Каждый человек заплатит: %.2f%n", sum/count);
    }
}