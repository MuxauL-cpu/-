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

    public static void Task1 (int a, int b, int c) {
        double D = (b * b) - (4 * a * c);

        if (D > 0) {
            System.out.println("Уравнение имеет 2 решения");
            double x1 = ((-b + Math.sqrt(D))/(2 * a));
            double x2 = ((-b - Math.sqrt(D))/(2 * a));
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }

        if (D == 0) {
            System.out.println("Уравнение имеет 1 решение");
            double x = ((-b)/(2 * a));
            System.out.println("x = " + x);
        }

        if (D < 0) {
            System.out.println("Уравнение не имеет решений");
        }
    }

    public static int Task2(String array) {
        int c = 0;
        int indx = 0;
        for(int i = 0; i<array.length()-2;i++){
            if (array.charAt(i) == 'z' && array.charAt(i+1) == 'i' && array.charAt(i+2) == 'p'){
                c++;
            }
            if (c == 2){
                indx = i;
                break;
            }
        }
        if (indx == 0){
            return -1;
        }
        else{
            return indx;
        }
    }

    public static void Task3(int a) {
        int sum = 0;

        for (int i = 1; i < a; i++) {
            if (a % i == 0) sum += i;
            }

        if (sum == a) {System.out.println("true");}

        else {System.out.println("false");}
    }

    public static void Task4(String str) {
        char[] str1 = str.toCharArray();
        int n = str.length();
        char tmp = 0;

        if ((str1[0] != str1[n - 1]) && (n > 2)){
            tmp = str1[0];
            str1[0] = str1[n - 1];
            str1[n - 1] = tmp;

            System.out.println(str1);
        }

        else if (str1[0] == str1[n - 1]) {
            System.out.println("Два - это пара");
        }

        else if (n < 2) {
            System.out.println("Несовместимо");
        }
    }

    public static void Task5(String str) {
        char[] str1 = str.toCharArray();
        int n = str.length() - 1;

        for (int i = 0; i < n; i++) {
            if (str1[0] == '#') {
                if ((str.matches("[a-fA-F0-9]+"))) {
                    System.out.println("true");
                }
            }
            else System.out.println("false");
        }
    }

    public static boolean Task6(int [] number_1, int [] number_2) {
        int count_1 = 0, count_2 = 0;
        int max = 0, max_1, max_2;
        Arrays.sort(number_1);
        Arrays.sort(number_2);
        max_1 = number_1[number_1.length-1];
        max_2 = number_1[number_1.length-1];
        if (max_1 >= max_2){
            max = max_1;
        }
        else{
            max = max_2;
        }
        for (int j = 0; j <= max; j++) {
            for (int i = 0; i < number_1.length; i++) {
                if (number_1[i] == j) {
                    count_1++;
                    break;
                }
            }
            for (int i = 0; i < number_2.length; i++) {
                if (number_2[i] == j) {
                    count_2++;
                    break;
                }
            }
        }
        return count_1 == count_2;
    }

    public static boolean Task7(int n) {
        int digit = n * n;
        int del = 0;
        String array = "";
        array += digit;

        if (array.length() % 2 == 0){
            del = array.length() / 2;
        }

        else {
            del = (array.length() + 1) / 2;
        }

        int part1 = 0, part2 = 0;
        part1 = (int)(digit / Math.pow(10,del));
        part2 = (int)(digit % Math.pow(10,del));

        return n == part1 + part2;
    }

    public static void Task8(String arr) {
        String [] array = arr.split("1" );
        Arrays.sort(array);
        System.out.println(array[array.length-1]);
    }

    public static int Task9(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                count++;
            }
        }

        if (count == 2){
            return n;
        }
        else{
            int digit = n;
            boolean check = false;

            while (check == false) {
                digit++;
                count = 0;
                for (int i = 1; i <= digit; i++) {
                    if (digit % i == 0) {
                        count++;
                    }
                }
                if (count == 2) {
                    check = true;
                }
            }
            return digit;
        }
    }

    public static boolean Task10(int a, int b, int c) {
        if (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)) {
            return true;
        }

        if (Math.pow(b,2) + Math.pow(c,2) == Math.pow(a,2)) {
            return true;
        }

        if (Math.pow(a,2) + Math.pow(c,2) == Math.pow(b,2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int key = 20;

        do {
            do {
                System.out.println("|1. Задание 1 | |2. Задание 2 | " +
                        "|3. Задание 3 | |4. Задание 4 | |5. Задание 5 |  |6. Задание 6 |" +
                        " |7. Задание 7 |  |8. Задание 8 |  |9. Задание 9 |  |10. Задание 10 | |11. Выход |");
                key = inputInt();
            } while ((key != 1) && (key != 2) && (key != 3) && (key != 4) && (key != 5) && (key != 6) && (key != 7)
                    && (key != 8) && (key != 9) && (key != 10) && (key != 11));

            switch (key) {
                case (1):
                    System.out.println("Введите значения квадратного уравнения: a");
                    int a = inputInt();

                    System.out.println("Введите значения квадратного уравнения: b");
                    int b = inputInt();

                    System.out.println("Введите значения квадратного уравнения: c");
                    int c = inputInt();

                    Task1(a, b, c);
                    break;

                case (2):
                    System.out.println("Введите строку: ");
                    String array = inputStr();
                    System.out.println(Task2(array));
                    break;

                case (3):
                    System.out.println("Введите число: ");
                    int n = inputInt();
                    Task3(n);
                    break;

                case (4):
                    System.out.println("Введите строку: ");
                    String Str = inputStr();
                    Task4(Str);
                    break;

                case (5):
                    String str1 = inputStr();
                    Task5(str1);
                    break;

                case (6):
                    int [] number_1 = {1,3,4,4,45};
                    int [] number_2 = {2,5,7};
                    System.out.println(Task6(number_1, number_2) + "\r\n");
                    break;

                case (7):
                    System.out.println("Введите число: ");
                    int e = inputInt();
                    System.out.println(Task7(e) + "\r\n");
                    break;

                case (8):
                    System.out.println("Введите последовательность 0 и 1: ");
                    String str = inputStr();
                    Task8(str);
                    break;

                case (9):
                    System.out.println("Введите число: ");
                    int k = inputInt();
                    System.out.println(Task9(k));
                    break;

                case (10):
                    System.out.println("Введите число: ");
                    int a1 = inputInt();
                    System.out.println("Введите число: ");
                    int b1 = inputInt();
                    System.out.println("Введите число: ");
                    int c1 = inputInt();
                    System.out.println(Task10(a1, b1, c1));
                    break;
            }

        } while (key != 11);
    }
}
