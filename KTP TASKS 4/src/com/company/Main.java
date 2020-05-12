package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
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
        String[] str1 = str.split(" ");

        for (int i = 0; i < str1.length; i++) {
            if (str1.length < n) {
                System.out.println("Ошибка");
            }
        }

        System.out.println(Arrays.toString(str1));
        String out = "";
        int l = 0;

        for (int i = 0; i < str1.length; i++) {
            l += str1[i].length();
            if (l <= n) {
                out += str1[i] + " ";
                if (i == str1.length - 1) {
                    System.out.println(out);
                }
            }
            else {
                System.out.println(out);
                out = "";
                i -= 1;
                l = 0;
            }
        }
    }

    public static void Task2(String str) {
        String[] str1 = new String[str.length()];
        int count = 0;
        int n = 0;
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { count++; }
            if (str.charAt(i) == ')') { count--; }
            if (count == 0) {
                str1[n] = "";

                for (int j = sum; j <= i; j++) {
                    str1[n] += (char)str.charAt(j);
                }
                sum = i + 1;
                n++;
            }
        }

        String[] str2 = new String[n];
        for (int i = 0; i < str2.length; i++) {
            str2[i] = str1[i];
        }
        System.out.println(Arrays.toString(str2));
    }

    public static void Task3_ToCamelCase(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                result += Character.toUpperCase(str.charAt(i + 1));
                i++;
            }
            else {
                result += str.charAt(i);
            }
        }
        System.out.println(result);
    }

    public static void Task3_ToSnakeCase(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i) > 64 && (int)str.charAt(i) < 91) {
                result += "_";
                result += Character.toLowerCase(str.charAt(i));
            }
            else {
                result += str.charAt(i);
            }
        }
        System.out.println(result);
    }

    public static void Task4(double start, double finish, double hourFee, double mwork) {
        double sum = 0;

        if (finish >= 17) {
            if (17 - start >= 0)
            sum += hourFee * (17 - start);

            if (finish - 17 >= 0)
            sum += hourFee * (finish - 17) * mwork;
        }
        sum += hourFee * (finish - start);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(sum);
        System.out.println(moneyString);
    }

    public static void Task5(double weight, double height) {
        double result;

        result = weight / (height * height);
        System.out.println(result);

        if (result < 18.5) System.out.println("Недостаточный вес");

        if ((result > 18.5) && (result <24.9)) System.out.println("Нормальный вес");

        if (result > 25) System.out.println("Избыточный вес");
    }

    public static void Task6(int n) {
        String num = "";
        num += n;
        int m = 1;
        int count = 0;

        if (num.length() == 1) {
            System.out.println("Это уже однозначное число");
        }

         do {
            m = 1;
            for (int i = 0; i < num.length(); i++) {
                int d = 57 - (int) num.charAt(i);
                d = 9 - d;
                m = m * d;
            }
            num = "";
            num += m;
            count++;
        } while (m > 9);
        System.out.println(count);
    }

    public static void Task7(String str) {
        int index = 0;
        int count = 0;
        String result = "";

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                index = i;
                count++;
            }
            else {
                if (count != 0) {
                    count++;
                    result += str.charAt(i) + " " + "*" + count;
                    count = 0;
                }
                else {
                    result += str.charAt(i);
                    count = 0;
                }
            }
        }
        if (count != 0) {
            count++;
            result += str.charAt(index) + " " + "*" + count;
        }
        if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) {
            result += str.charAt(str.length() - 1);
        }
        System.out.println(result);
    }

    public static void Task8(String arr1, String arr2) {
        String [] parts_1 = arr1.split(" " );
        String [] parts_2 = arr2.split(" " );

        String part_1 = "";
        part_1 +=  parts_1[parts_1.length-1];
        part_1 = part_1.toUpperCase();
        String part_2 = "";
        part_2 +=  parts_2[parts_2.length-1];
        part_2 = part_2.toUpperCase();

        String output_1 = "";
        for (int i = 0; i < part_1.length();i++){
            if(part_1.charAt(i) == 'A' || part_1.charAt(i) == 'E' || part_1.charAt(i) == 'I' || part_1.charAt(i) == 'O' || part_1.charAt(i) == 'U'){
                output_1 += (char)part_1.charAt(i);
            }

        }

        String output_2 = "";
        for (int i = 0; i < part_2.length();i++){
            if(part_2.charAt(i) == 'A' || part_2.charAt(i) == 'E' || part_2.charAt(i) == 'I' || part_2.charAt(i) == 'O' || part_2.charAt(i) == 'U'){
                output_2 += (char)part_2.charAt(i);
            }

        }
        if (output_1.length() == output_2.length()){
            for (int i = 0; i < output_1.length();i++){
                if (output_1.charAt(i) != output_2.charAt(i)){
                    System.out.println("false");
                }
            }
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

    public static boolean Task9(String a, String b) {
        String str1 = new String();
        str1 += a;
        String str2 = new String();
        str2 += b;
        int count_1 = 1, count_2 = 1;

        for (int j = 48; j < 58; j++) {
            for (int i = 0; i < str1.length() - 1; i++) {
                if (str1.charAt(i) == str1.charAt(i + 1) && str1.charAt(i) == j) {
                    count_1++;
                    if (count_1 == 3) break;
                }
                else {
                    count_1 = 1;
                }
            }
            for (int i = 0; i < str2.length() - 1; i++) {
                if (str2.charAt(i) == str2.charAt(i + 1) && str2.charAt(i) == j) {
                    count_2++;
                    if (count_2 == 2) break;
                }
                else {
                    count_2 = 1;
                }
            }
            if (count_1 == 3 && count_2 == 2) {
                return true;
            }
            else {
                count_1 = 1;
                count_2 = 1;
            }
        }
        return false;
    }

    public static String Task10(String str, char a) {
        if (str.length() <= 2) return "Error";

        String del = "";
        del += a;
        String[] parts = str.split(del);
        String part = "";

        for (int i = 0; i < parts.length; i++){
            if (i % 2 != 0) part += parts[i];
        }

        char[] chars = part.toCharArray();
        Arrays.sort(chars);
        part = "";
        boolean check = true;

        if (chars.length==1){
            return "Уникадьные кники | " + chars.length + " | " + Arrays.toString(chars);
        }
        for (int i = 0; i < chars.length-1; i++){
            if (chars[i]!=chars[i+1]) part +=chars[i];

            else check = false;
        }
        if (check==false) part+=chars[chars.length-1];

        char [] charsNew = part.toCharArray();
        return "Уникальные книги | " + charsNew.length + " | " + Arrays.toString(charsNew);
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
                    System.out.println("Введите текст");
                    String str = inputStr();
                    System.out.println("Введите число");
                    int n = inputInt();

                    Task1(str,n);
                    break;

                case (2):
                    System.out.println("Введите строку скобок");
                    String arr = inputStr();
                    Task2(arr);
                    break;

                case (3):
                    System.out.println("Введите слово");
                    String arr1 = inputStr();
                    Task3_ToCamelCase(arr1);
                    Task3_ToSnakeCase(arr1);
                    break;

                case (4):
                    System.out.println("Введите начало рабочего дня");
                    double start = inputDob();
                    System.out.println("Введите конец рабочего дня");
                    double finish = inputDob();
                    System.out.println("Введите почасовую ставку");
                    double hourFee = inputDob();
                    System.out.println("Введите множитель сверхурочных работ");
                    double mwork = inputDob();
                    Task4(start, finish, hourFee, mwork);
                    break;

                case (5):
                    System.out.println("Введите вес (кг)");
                    double weight = inputDob();
                    System.out.println("Введите рост (м)");
                    double height = inputDob();
                    Task5(weight, height);
                    break;

                case (6):
                    System.out.println("Введите число");
                    int n1 = inputInt();
                    Task6(n1);
                    break;

                case (7):
                    System.out.println("Введите строку");
                    String str2 = inputStr();
                    Task7(str2);
                    break;

                case (8):
                    System.out.println("Введите строку");
                    String str_1 = inputStr();
                    System.out.println("Введите строку");
                    String str_2 = inputStr();
                    Task8(str_1, str_2);
                    break;

                case (9):
                    System.out.println("Введите число");
                    String a = inputStr();
                    System.out.println("Введите число");
                    String b = inputStr();
                    System.out.println(Task9(a, b));
                    break;

                case (10):
                    System.out.println("Введите строку");
                    String arr_1 = inputStr();
                    System.out.println("Введите символ");
                    char a1 = inputChar();
                    System.out.println(Task10(arr_1, a1));
                    break;
            }

        } while (key != 11);
    }
}