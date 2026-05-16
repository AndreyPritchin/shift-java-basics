package homework202;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiplicationTableFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        //Чтение первого числа
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число:");
        //Чтение второго числа
        int number2 = scanner.nextInt();
        System.out.println("Введите шаг:");
        //Чтение шага
        int step = scanner.nextInt();
        //Проверка корректности параметра шаг
        if (step <= 1) {
            System.out.println("Шаг должен быть >= 1. Автоматически установлен шаг = 1");
            step = 1;
        }

        int l;
        int numberMinimum;
        int numberMaximum;
        int widthMaximum = 0;

        //Расчет длины массива множителей
        if (number1 > number2) {
            l = (number1 - number2)/step + 1;
            numberMinimum = number2;
            numberMaximum = number1;
        } else {
            l = (number2 - number1)/step + 1;
            numberMinimum = number1;
            numberMaximum = number2;
        }

        //Проверка граничного значения
        if ((numberMaximum - numberMinimum)%step != 0) {
            l++;
        }

        //Объявление двумерного массива
        int table[][] = new int[l+1][l+1];

        //Наполнение массива множителями (вертикали и горизонтали)
        for (int i = 0; i < l; i++) {
            table[0][i+1] = numberMinimum + i*step;
            table[i+1][0] = numberMinimum + i*step;
            //Учет верхней границы диапазона
            if (i == l - 1) {
                table[0][i+1] = numberMaximum;
                table[i+1][0] = numberMaximum;
            }
        }

        //Наполнение результатами произведений
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < l + 1; j++) {
                table[i][j] = table[0][j]*table[i][0];
            }
        }

        //Определение ширины столбца
        for (int i = 0; i < l + 1; i++) {
            for (int j = 0; j < l + 1; j++) {
                if (widthMaximum < getCellWidth(table[i][j])) {
                    widthMaximum = getCellWidth(table[i][j]);
                }
            }
        }

        //Форматирование
        String format = "%" + widthMaximum + "d ";

        //Вызов функции печати таблицы
        //printTable(table, l, format);

        //Вызов функции печати таблицы в файл
        printTableInFile(table, l, format);
    }

    //Функция печати таблицы в консоль
    public static void printTable(int table[][], int l, String format) {
        for (int i = 0; i < l + 1; i++) {
            for (int j = 0; j < l + 1; j++) {
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

    //Функция печати таблицы в файл
    public static void printTableInFile(int table[][], int l, String format) {
        String fileName = "multiplication_table.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < l + 1; i++) {
                for (int j = 0; j < l + 1; j++) {
                    //Формирование строки ячейки
                    String cell = String.format(format, table[i][j]);
                    //Запись в файл
                    fileOutputStream.write(cell.getBytes());
                }
                fileOutputStream.write("\n".getBytes());
            }
            System.out.println("Таблица записана в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}