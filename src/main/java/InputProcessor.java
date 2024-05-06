import java.util.Scanner;

public class InputProcessor {
    private final Scanner scanner;

    InputProcessor() {
        this.scanner = new Scanner(System.in);
    }

    public int getPersonsCount() {
        int count;
        while (true) {
            System.out.println("Укажите на сколько человек необходимо разделить счет (>1):");
            try {
                count = Integer.parseInt(scanner.nextLine());
                if (count <= 1) {
                    System.out.println("Необходимо указать число больше 1!");
                } else {
                    System.out.printf("Счет будет разделен на указанное количество человек: %d%n", count);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Необходимо указать корректное число!");
            }
        }

        return count;
    }

    public String[] getCommand(){
        String line = scanner.nextLine();
        return line.split(" ");
    }
}
