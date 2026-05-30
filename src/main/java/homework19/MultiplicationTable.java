package homework19;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        //Чтение чисел и шага из консоли
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число:");
        int number2 = scanner.nextInt();
        System.out.println("Введите шаг:");
        int step = scanner.nextInt();

        //Проверка корректности параметра шаг
        if (step <= 1) {
            System.out.println("Шаг должен быть >= 1. Автоматически установлен шаг = 1");
            step = 1;
        }

        int widthMaximum = 0;

        //Объявление двумерного массива
        int tableMultiplier[][];

        //Вызов функции создания таблицы
        tableMultiplier = CreateTable(number1,number2, step);
        int lengthMultiplierArray = tableMultiplier.length;

        //Наполнение результатами произведений
        for (int i = 1; i < lengthMultiplierArray; i++) {
            for (int j = 1; j < lengthMultiplierArray; j++) {
                    tableMultiplier[i][j] = tableMultiplier[0][j]* tableMultiplier[i][0];
            }
        }

        //Определение ширины столбца
        for (int i = 0; i < lengthMultiplierArray; i++) {
            for (int j = 0; j < lengthMultiplierArray; j++) {
                if (widthMaximum < getCellWidth(tableMultiplier[i][j])) {
                    widthMaximum = getCellWidth(tableMultiplier[i][j]);
                }
            }
        }

        //Форматирование
        String format = "%" + widthMaximum + "d ";

        //Вызов функции печати таблицы
        PrintTable(tableMultiplier, format);
    }

    //Функция создания таблицы с множителями
    public static int[][] CreateTable(int value1, int value2, int step) {
        int lengthMultiplierArray;
        int numberMinimum;
        int numberMaximum;

        //Расчет длины массива множителей
        if (value1 > value2) {
            lengthMultiplierArray = (value1 - value2)/step + 1;
            numberMinimum = value1;
            numberMaximum = value2;
        } else {
            lengthMultiplierArray = (value2 - value1)/step + 1;
            numberMinimum = value1;
            numberMaximum = value2;
        }

        //Проверка граничного значения
        if ((numberMaximum - numberMinimum)%step != 0) {
            lengthMultiplierArray++;
        }
        //Объявление двумерного массива
        int table[][] = new int[lengthMultiplierArray +1][lengthMultiplierArray +1];

        //Наполнение массива множителями (вертикали и горизонтали)
        for (int i = 0; i < lengthMultiplierArray; i++) {
            table[0][i + 1] = table[i + 1][0] = numberMinimum + i * step;
        }
        //Учет верхней границы диапазона
        table[0][lengthMultiplierArray] = numberMaximum;
        table[lengthMultiplierArray][0] = numberMaximum;

        return table;
    }

    //Функция печати таблицы
    public static void PrintTable(int table[][], String format) {
        int lengthTable = table.length;
        for (int i = 0; i < lengthTable; i++) {
            for (int j = 0; j < lengthTable; j++) {
                System.out.printf(format, table[i][j]);
            }
            System.out.print("\n");
        }
    }

    //Функция расчета "длины" числа
    public static int getCellWidth(int number) {
        String data = String.valueOf(number);
        return data.length();
    }
}