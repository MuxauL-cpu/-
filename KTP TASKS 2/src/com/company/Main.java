package com.company;

import java.io.IOException;
import java.util.Arrays;
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

    public static String inputStr() {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        return num;
    }

    public static void Task1(String str, int n) {
        String str1 = new String();

        for (int i = 0; i < str.length(); i++) {
            char sim = str.charAt(i);
            for (int j = 0; j < n; j++) {
                str1 += sim;
            }
        }
        System.out.println(str1);
    }

    public static void Task2(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int res;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }

        res = max - min;

        System.out.println("Разность равна: " + res);
    }

    public static void Task3(int[] arr) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        if (sum % n == 0) System.out.println("true");
        else System.out.println("false");
    }

    public static int[] Task4(int[] arr) {
        int[] arr1 = new int[arr.length];
        arr1[0] = arr[0];
        for(int i=1; i < arr.length; i++){
            arr1[i] = arr[i] + arr1[i-1];
        }
        return arr1;
    }

    public static void Task5(double a) {
        System.out.println(String.valueOf(a).split("\\.")[1].length());
    }

    public static void Task6(int a, int n) {
        int[] arr = new int[a];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < a - 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int i = 0; i < a; i++) {
            if (n == i) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void Task7(String str) {
        if ((str.matches("[0-9]+")) && (str.length() <= 5)) {System.out.println("true");}
        else {System.out.println("false");}
    }

    public static void Task8(String st1, String st2) {
        if ((st1 == "") && (st2 == "")) {
        System.out.println("false");

    }

        char[] buk1 = st1.toCharArray();
        char[] buk2 = st2.toCharArray();
        int n = st2.length();

        if (buk1[0] == buk2[n - 1]) {System.out.println("true");}

        else {System.out.println("false");}
    }

    public static boolean isPrefix(String str, String str1) {
        for (int i = 0; i < str1.length(); i++) {
            if (str.charAt(i) == str1.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSuffix(String str, String str1) {
        for (int i = 1; i < str1.length(); i++){
            if (str.charAt(str.length() - 1 - i) == str1.charAt(str1.length() - 1 - i)){
                return true;
            }
        }
        return false;
    }

    public static int Task10(int a){
        int b = 0;
        for (int i = 1; i <= a; i++){
            if(i % 2 == 1){
                b += 3;
            }
            else {b -= 1;}
        }
        return b;
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
                    System.out.println("Введите слово: ");
                    String str = inputStr();

                    System.out.println("Введите количество повторов: ");
                    int n = inputInt();

                    Task1(str, n);
                    break;

                case (2):
                    System.out.println("Введите размер массива: ");
                    int size = inputInt();
                    int arr[] = new int[size];
                    System.out.println("Введите элементы массива: ");
                    for(int i = 0; i < size; i++) {
                        arr[i] = inputInt();
                    }

                    for(int i = 0; i < size; i++) {
                        System.out.println(" " + arr[i]);
                    }

                    Task2(arr);
                    break;

                case (3):
                    System.out.println("Введите размер массива: ");
                    int size1 = inputInt();
                    int arr1[] = new int[size1];

                    System.out.println("Введите элементы массива: ");
                    for(int i = 0; i < size1; i++) {
                        arr1[i] = inputInt();
                    }

                    for(int i = 0; i < size1; i++) {
                        System.out.println(" " + arr1[i]);
                    }

                    Task3(arr1);
                    break;

                case (4):
                    System.out.println("Введите длину массива:");
                    int[] array = new int[inputInt()];
                    System.out.println("Введите элементы массива: ");
                    for (int i = 0;i < array.length; i++){
                        array[i]=inputInt();
                    }
                    System.out.println(Arrays.toString(Task4(array)));
                    break;

                case (5):
                    System.out.println("Введите число: ");
                    double r = inputDob();
                    Task5(r);
                    break;

                case (6):
                    System.out.println("Введите количество чисел Фибоначчи: ");
                    int l = inputInt();
                    System.out.println("Введите число: ");
                    int u = inputInt();
                    Task6(l, u);
                    break;

                case (7):
                    System.out.println("Введите почтовый индекс: ");
                    String str1 = inputStr();
                    Task7(str1);
                    break;

                case (8):
                    System.out.println("Введите слово: ");
                    String st1 = inputStr();
                    System.out.println("Введите слово: ");
                    String st2 = inputStr();
                    Task8(st1, st2);
                    break;

                case (9):
                    System.out.println("isPrefix");
                    String str3=inputStr();
                    String str4=inputStr();

                    System.out.println(isPrefix(str3, str4));

                    System.out.println("isSuffix");
                    String str5=inputStr();
                    String str6=inputStr();

                    System.out.println(isSuffix(str5, str6));
                    break;

                case (10):
                    System.out.println("Введите число (шаг): ");
                    int b =inputInt();
                    System.out.println(Task10(b));
                    break;
            }

        } while (key != 11);
    }
}
