package homework201;
import java.util.Scanner;

public class StringSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        //Считывание исходной строки из консоли
        String stringInput = scanner.nextLine();

        //Циклическая проверка корректности исходной строки (не пустая и не единичной длины)
        while (stringInput.isEmpty() || stringInput.length() == 1) {
            System.out.println("Строка не должна быть пустой или единичной длины");
            stringInput = scanner.nextLine();
        }

        System.out.println("Введите символ для замены (не пробел):");
        //Считывание символа - для замены из консоли
        String charInput = scanner.nextLine();

        //Циклическая проверка корректности символа (единичный и не пробел)
        while (charInput.length() != 1 || charInput.charAt(0) == ' ') {
            System.out.println("Можно ввести не больше одного символа. Символ не должен являться пробелом");
            charInput = scanner.nextLine();
        }

        //Перевод типа символа - для замены из строки в символ
        char targetChar = charInput.charAt(0);

        //Нормализация строки: удаление всех пробелов в начале и в конце исходной строки
        String normalString = stringInput.trim();
        //Нормализация строки: итерационное сокращение повторяющихся пробелов до единичных пробелов
        while (normalString.contains("  ")) {
            normalString = normalString.replace("  ", " ");
        }

        //Замена символа - для замены на пробел
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < normalString.length(); i++) {
            char c = normalString.charAt(i);
            if (c == targetChar) {
                resultString.append(' ');
            } else {
                resultString.append(c);
            }
        }

        //Повторное удаление всех пробелов в начале и в конце исходной строки
        String finalString = resultString.toString().trim();
        //Повторное итерационное сокращение повторяющихся пробелов до единичных пробелов
        while (finalString.contains("  ")) {
            finalString = finalString.replace("  ", " ");
        }

        //Вывод результата
        System.out.println("Исходная строка: " + normalString);
        if (normalString.equals(finalString)) {
            System.out.println("Строка не изменилась после преобразований.");
        } else {
            System.out.println("Результат: " + finalString);
        }
    }
}