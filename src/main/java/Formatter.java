public class Formatter {
    public static String getRubForm(double rubles){
        int number = (int) Math.floor(rubles);
        int lastTwo = number % 100;

        if (lastTwo > 10 && lastTwo < 20)
            return "рублей";

        int last = number % 10;
        return switch (last) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }
}
