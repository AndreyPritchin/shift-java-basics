package homework18;

public class Parrots38 {
    public static void main(String[] args) {
        //Длина удава в см
        float SnakeL_m = 380;
        //Рост Попугая, Мартышки и Слоненка в см соответственно
        float ParrotL_m, MonkeyL_m, Elephant_m;
        ParrotL_m = SnakeL_m / 38;
        MonkeyL_m = SnakeL_m / 5;
        Elephant_m = SnakeL_m / 2;
        //Суммарный рост всех персонажей в м
        float sumL_m = SnakeL_m + ParrotL_m + MonkeyL_m + Elephant_m; //Суммарный рост всех персонажей в м
        System.out.println("Длина удава = " + SnakeL_m / 100 + " м");
        System.out.println("Рост Попугая = " + ParrotL_m / 100+ " м");
        System.out.println("Рост Мартышки = " + MonkeyL_m / 100+ " м");
        System.out.println("Рост Слоненка = " + Elephant_m / 100+ " м");
        System.out.println("Суммарный рост всех персонажей = " + sumL_m / 100 + " м");
    }
}
