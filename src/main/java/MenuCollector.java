import java.util.ArrayList;
import java.util.Arrays;

public class MenuCollector {
    private final ArrayList<Product> products = new ArrayList<>();
    private final InputProcessor inputProcessor;

    MenuCollector(InputProcessor inputProcessor){
        this.inputProcessor = inputProcessor;
    }

    public void collectMenu() {
        System.out.println("Составление меню");
        System.out.println("Доступные команды: \n 1.Добавить [название] [цена] (Пример: Добавить Банан 10.00) \n 2.Завершить");

        while (true) {
            String[] command = inputProcessor.getCommand();
            if (command.length == 0){
                System.out.println("Введите корректную команду!");
                continue;
            }

            switch (command[0].toLowerCase()){
                case "добавить":
                    processAdd(command);
                    continue;
                case "завершить":
                    listProducts();
                    break;
                default:
                    System.out.println("Введите корректную команду!");
                    continue;
            }

            System.out.println("Вы завершили составление меню!");
            break;
        }
    }

    private void processAdd(String[] command){
        if (command.length < 3){
            System.out.println("Вы ввели не полную команду!");
            return;
        }
        double cost;
        String name = command[1];
        try {
            cost = Double.parseDouble(command[2]);
            if (cost < 0)
                System.out.println("Цена товара не может быть отрицательной!");
        } catch (NumberFormatException e) {
            System.out.println("Введите корректную стоимость товара!");
            return;
        }
        products.add(new Product(name, cost));
        System.out.printf("Товарь '%s' успешно добавлен!%n", name);
    }

    private void listProducts(){
        System.out.println("Добавленные товары:");
        for (Product product: products){
            System.out.println(product);
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
