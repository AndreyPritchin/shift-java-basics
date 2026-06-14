package homework201;
import java.util.Scanner;

public class StringSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        //Считывание исходной строки из консоли
        String stringInput = scanner.nextLine();

        //Циклическая проверка корректности исходной строки (не пустая и не единичной длины) и правильности символов
        while (stringInput.isEmpty() || stringInput.length() == 1 || stringInput.matches("^[a-zA-Zа-яА-ЯёЁ.,?!;:\\s]+$") == false) {
            System.out.println("Строка не должна быть пустой или единичной длины. Строка должна содержать буквы (или латиница, или кириллица), знаки препинания (точка, вопросительный и восклицательный знаки, запятая, двоеточие, точка с запятой) и пробелы");
            stringInput = scanner.nextLine();
        }

        System.out.println("Введите символ для замены (не пробел):");
        //Считывание символа - для замены из консоли
        String charInput = scanner.nextLine();

        //Циклическая проверка корректности символа (единичный и не пробел)
        while (charInput.length() != 1 || charInput == " ") {
            System.out.println("Можно ввести не больше одного символа. Символ не должен являться пробелом");
            charInput = scanner.nextLine();
        }

        //Нормализация строки: удаление всех пробелов в начале и в конце исходной строки
        String normalString = stringInput.trim();

        //Замена символа для замены на пробел
        normalString = normalString.replace(charInput, " ");

        //Нормализация строки: сокращение повторяющихся пробелов до единичных пробелов
        normalString = normalString.replaceAll("\\s+", " ");

        //Вывод результата
        System.out.println("Исходная строка: " + stringInput +"\n"+ "Результат: " + normalString);
        if (normalString.equals(stringInput)) {
            System.out.println("Строка не изменилась после преобразований.");
        }
    }
}