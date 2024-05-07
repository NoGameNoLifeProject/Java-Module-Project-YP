import java.util.ArrayList;
import java.util.Arrays;

public class MenuCollector {
    private final ArrayList<Product> products = new ArrayList<>();
    private final InputProcessor inputProcessor;

    private final int COMMAND_ADD_ARGUMENT_COUNT = 3;
    private final int COMMAND_ADD_NAME_INDEX = 1;
    private final int COMMAND_ADD_COST_INDEX = 2;
    private final String ADD_COMMAND = "добавить";
    private final String END_COMMAND = "завершить";

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
                case ADD_COMMAND:
                    processAdd(command);
                    continue;
                case END_COMMAND:
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
        if (command.length < COMMAND_ADD_ARGUMENT_COUNT){
            System.out.println("Вы ввели не полную команду!");
            return;
        }
        double cost;
        String name = command[COMMAND_ADD_NAME_INDEX];
        try {
            cost = Double.parseDouble(command[COMMAND_ADD_COST_INDEX]);
            if (cost < 0) {
                System.out.println("Цена товара не может быть отрицательной!");
                return;
            }
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
