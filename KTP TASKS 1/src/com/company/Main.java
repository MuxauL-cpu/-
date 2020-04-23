package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Метод для ручного ввода данных для задач
    public static int inputInt() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        return num;
    }

    public static double inputDob() {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        return num;
    }

    public static char inputChar() throws IOException {
        Scanner in = new Scanner(System.in);
        char num = (char) System.in.read();
        return num;
    }

    // В Java есть единственный оператор, способный обеспечить остаток от операции деления.
    // Два числа передаются в качестве параметров. Первый параметр, разделенный на второй параметр,
    // будет иметь остаток, возможно, ноль. Верните это значение.
    public static void Task1(int a, int b) {
        System.out.println("Ответ: " + a % b);
    }

    //Напишите функцию, которая принимает основание и высоту треугольника и возвращает его площадь.
    public static void Task2(double a, double b) {
        System.out.println("Ответ: " + (0.5 * (a * b)));
    }

    // В этой задаче фермер просит вас сказать ему, сколько ног можно сосчитать среди всех его животных.
    // Фермер разводит три вида:
    // chickens = 2 legs
    // cows = 4 legs
    // pigs = 4 legs
    // Фермер подсчитал своих животных, и он дает вам промежуточный итог для каждого вида.
    // Вы должны реализовать функцию, которая возвращает общее количество ног всех животных.
    public static void Task3(int cow, int chicken, int pig) {
        int lcow = 4;
        int lchicken = 2;
        int lpig = 4;
        System.out.println("Ответ: " + ((lcow * cow) + (lchicken * chicken) + (lpig * pig)));
    }

    // Создайте функцию, которая принимает три аргумента (prob, prize, pay)
    // и возвращает true, если prob * prize > pay; в противном случае возвращает false.
    public static void Task4(double prob, double prize, double pay) {
        double r;
        r = prob * prize;

        if (r > pay) {
            System.out.println("Ответ: true");
        }
        else {
            System.out.println("Ответ: false");
        }
    }

    // Напишите функцию, которая принимает 3 числа и возвращает, что нужно сделать с a и b:
    // они должны быть сложены, вычитаны, умножены или разделены, чтобы получить N. Если ни одна из операций
    // не может дать N, верните "none".
    public static String Task5(int N, int a, int b) {
        String str;
        if ((a + b) == N) {str = "Должны быть сложены";}
        else if ((a - b) == N) {str = "Должны быть вычтены";}
        else if ((a * b) == N) {str = "Должны быть умножены";}
        else if ((a / b) == N) {str = "Должны быть разделены";}
        else {str = "Ничего";}
        System.out.println(str);
        return str;
    }

    //Создайте функцию, которая возвращает значение ASCII переданного символа.
    public static void Task6(char ctoa) {
        int ascII = (int) ctoa;
        System.out.println("ASCII: " + ascII);
    }

    // Напишите функцию, которая берет последнее число из последовательного списка чисел и возвращает
    // сумму всех чисел до него и включая его
    public static void Task7(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }

        System.out.println("Ответ: " + sum);
    }

    // Создайте функцию, которая находит максимальное значение третьего ребра треугольника,
    // где длины сторон являются целыми числами
    public static void Task8(int AC, int BC) {
        int Res;
        Res = AC + BC - 1;
        System.out.println("Ответ: " + Res);
    }

    // Создайте функцию, которая принимает массив чисел и возвращает сумму его кубов.
    public static void Task9(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + (arr[i] * arr[i] * arr[i]);
        }
        System.out.println("Сумма кубов: " + sum);
    }

    //  Создайте функцию, которая будет для данного a, b, c выполнять следующие действия:
    //  – Добавьте A к себе B раз.
    //  – Проверьте, делится ли результат на C.
    public static void Task10(int a, int b, int c) {
        for (int i = 0; i == b; i++) {
            a = a + a;
        }

        if (a % c == 0) {
            System.out.println("Ответ: true");
        }
        else System.out.println("Ответ: false");
    }

    public static void main(String[] args) throws IOException {
        int key = 20;

        do {
            do {
                System.out.println("|1. Задание 1 | |2. Задание 2 | " +
                        "|3. Задание 3 | |4. Задание 4 | |5. Задание 5 |  |5. Задание 6 |" +
                        " |5. Задание 7 |  |5. Задание 8 |  |5. Задание 9 |  |5. Задание 10 | |11. Выход |");
                key = inputInt();
            } while ((key != 1) && (key != 2) && (key != 3) && (key != 4) && (key != 5) && (key != 6) && (key != 7)
                    && (key != 8) && (key != 9) && (key != 10) && (key != 11));

            switch (key) {
                case (1):
                    int a, b;
                    System.out.println("Введите значения 'a' и 'b': ");
                    a = inputInt();
                    b = inputInt();
                    Task1(a, b);
                    break;

                case (2):
                    double e, h;
                    System.out.println("Основание 'a' и высоту 'h': ");
                    e = inputDob();
                    h = inputDob();
                    System.out.println("Площадь треугольнка: ");
                    Task2(e, h);
                    break;

                case (3):
                    int cow, pig, chicken;
                    System.out.println("Введите количество коров: ");
                    cow = inputInt();

                    System.out.println("Введите количество свиней: ");
                    pig = inputInt();

                    System.out.println("Введите количество куриц: ");
                    chicken = inputInt();

                    System.out.println("Общее количество ног у животных: ");
                    Task3(cow, chicken, pig);
                    break;

                case (4):
                    double prob, prize, pay;
                    System.out.println("Введите переменную prob: ");
                    prob = inputDob();

                    System.out.println("Введите переменную prize: ");
                    prize = inputDob();

                    System.out.println("Введите переменную pay: ");
                    pay = inputDob();

                    Task4(prob, prize, pay);
                    break;

                case (5):
                    int A, B, N;
                    System.out.println("Введите число N: ");
                    N = inputInt();
                    System.out.println("Введите число a: ");
                    A = inputInt();
                    System.out.println("Введите число b: ");
                    B = inputInt();

                    Task5(N, A, B);
                    break;

                case (6):
                    char ctoa = inputChar();
                    Task6(ctoa);
                    break;

                case (7):
                    int n;
                    System.out.println("Введите число: ");
                    n = inputInt();
                    Task7(n);
                    break;

                case (8):
                    int AC, BC;
                    System.out.println("Введите ребро: ");
                    AC = inputInt();

                    System.out.println("Введите ребро: ");
                    BC = inputInt();

                    Task8(AC, BC);
                    break;

                case (9):
                    System.out.println("Введите длину массива: ");
                    int size = inputInt();
                    int arr[] = new int[size];

                    System.out.println("Введите элементы массива: ");
                    for (int i = 0; i < size; i++) {
                        arr[i] = inputInt();
                    }

                    System.out.println("Оригинальный массив: ");
                    for (int i = 0; i < size; i++) {
                        System.out.println(" " + arr[i]);
                    }

                    Task9(arr);
                    break;

                case (10):
                    int k, l, m;
                    System.out.println("Введите число a: ");
                    k = inputInt();

                    System.out.println("Введите число b: ");
                    l = inputInt();

                    System.out.println("Введите число m: ");
                    m = inputInt();

                    Task10(k, l, m);
                    break;
            }

        } while (key != 11);
    }
}
