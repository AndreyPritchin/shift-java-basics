package homework19;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        //Чтение первого числа
        int ch1 = scanner.nextInt();
        System.out.println("Введите второе число:");
        //Чтение второго числа
        int ch2 = scanner.nextInt();
        System.out.println("Введите шаг:");
        //Чтение шага
        int step = scanner.nextInt();
        //Проверка корректности параметра шаг
        if (step <= 1) {
            System.out.println("Шаг должен быть >= 1. Автоматически установлен шаг = 1");
            step = 1;
        }

        int l;
        int chMin;
        int chMax;
        int wMax = 0;

        //Расчет длины массива множителей
        if (ch1 > ch2) {
            l = (ch1 - ch2)/step + 1;
            chMin = ch2;
            chMax = ch1;
        } else {
            l = (ch2 - ch1)/step + 1;
            chMin = ch1;
            chMax = ch2;
        }

        //Проверка граничного значения
        if ((chMax - chMin)%step != 0) {
            l++;
        }

        //Объявление двумерного массива
        int T[][] = new int[l+1][l+1];

        //Наполнение массива множителями (вертикали и горизонтали)
        for (int i = 0; i < l; i++) {
            T[0][i+1] = chMin + i*step;
            T[i+1][0] = chMin + i*step;
            //Учет верхней границы диапазона
            if (i == l - 1) {
                T[0][i+1] = chMax;
                T[i+1][0] = chMax;
            }
            //System.out.print(T[0][i+1] +"\t"+ T[i+1][0] +"\t");
        }

        //Наполнение результатами произведений
        for (int i = 1; i < l + 1; i++) {
            for (int j = 1; j < l + 1; j++) {
                    T[i][j] = T[0][j]*T[i][0];
                    //System.out.print(T[0][j] +"\t"+ T[i][0] +"\t");
                    //System.out.print(T[i][j] +"\t");
            }
            //System.out.print("\n");
        }

        //Определение ширины столбца
        for (int i = 0; i < l + 1; i++) {
            for (int j = 0; j < l + 1; j++) {
                if (wMax < getCellWidth(T[i][j])) {
                    wMax = getCellWidth(T[i][j]);
                }
            }
        }

        //Форматирование
        String format = "%" + wMax + "d ";

        //Вызов функции печати таблицы
        PrintTable(T, l, format);
    }

    //Функция печати таблицы
    public static void PrintTable(int T[][], int l, String format) {
        for (int i = 0; i < l + 1; i++) {
            for (int j = 0; j < l + 1; j++) {
                System.out.printf(format, T[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static int getCellWidth(int number) {
        String data = String.valueOf(number);
        return data.length();
    }
}