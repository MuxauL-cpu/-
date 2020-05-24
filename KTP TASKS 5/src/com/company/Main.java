package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public static void Task1(String str) {
        int [] code = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (i > 0) {
                code[i]=(int)str.charAt(i) - (int)str.charAt(i - 1);
            }
            else{
                code[0]=(int)str.charAt(i);
            }
        }
        System.out.println(Arrays.toString(code));
    }

    public static void Task1_2(int[] n) {
        int[] Decode = new int[n.length];

        for (int i = 0; i < n.length; i++) {
            if (i > 0) {
                Decode[i] = n[i] + n[i - 1];
                n[i] = Decode[i];
            }
            else Decode[0] = n[i];
        }

        char[] part = new char[Decode.length];
        for (int i = 0; i < Decode.length; i++) {
            part[i] = (char)Decode[i];
        }

        System.out.println(part);
    }

    public static boolean Task2(String name, String coord_first, String coord_last) {
        int x_first = 0;
        int y_first = 0;
        int x_last = 0;
        int y_last = 0;
        x_first = 8 - (72 - coord_first.charAt(0));
        y_first = 8 - (72 - coord_first.charAt(1));
        x_last = 8 - (72 - coord_last.charAt(0));
        y_last = 8 - (72 - coord_last.charAt(1));

        if (name =="rook"){
            if (x_first == x_last || y_first == y_last) {
                return true;
            }
            else{
                return false;
            }
        }
        if (name =="knight"){
            if ((Math.abs(x_first-x_last) == 3 && Math.abs(y_first-y_last) == 2) ||
                    (Math.abs(x_first-x_last) == 2 && Math.abs(y_first-y_last) == 3)) {
                return true;
            }
            else{
                return false;
            }
        }
        if (name =="bishop"){
            if (Math.abs(x_first-x_last) == Math.abs(y_first-y_last)) {
                return true;
            }
            else {
                return false;
            }
        }
        if (name =="queen"){
            if (Math.abs(x_first-x_last) == Math.abs(y_first-y_last)) {
                //return true;
            }
            else {
                if (x_first == x_last || y_first == y_last) {
                    //return true;
                } else {
                    return false;
                }
            }
        }
        if (name =="king"){
            if ((Math.abs(x_first-x_last) == Math.abs(y_first-y_last)) &&
                    (Math.abs(x_first-x_last) == 1) && (Math.abs(y_first-y_last) == 1)) {
                return true;
            }
            else {
                if ((x_first == x_last || y_first == y_last) &&
                        (Math.abs(x_first-x_last)==1 || Math.abs(y_first-y_last)==1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        if (name =="panws"){
            if ((Math.abs(x_first-x_last) == Math.abs(y_first-y_last)) &&
                    (Math.abs(x_first-x_last) == 1) && (Math.abs(y_first-y_last) == 1)) {
                return true;
            }
            else {
                if ((x_first == x_last) && (Math.abs(x_first-x_last)==0 || Math.abs(y_first-y_last)==1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
        }

        public static void Task3(String str1, String str2) {
        int ind = 0;

        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(ind))
                ind++;
        }

        System.out.println(ind == str1.length());
        }

        public static void Task4(int [] num) {
        int sum = 0, multiple = 1;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        String str = "";
        str += sum;

        do {
            for (int i = 0; i < str.length(); i++) {
                multiple = multiple * (9 - (57 - (int)str.charAt(i)));
            }
            str = "";
            str += multiple;
            multiple = 1;
        } while (str.length() > 1);

        System.out.println(str);
        }

        public static void Task5(String[] str) {
            String strCont = str[0];
            strCont = strCont.toLowerCase();
            String strContNew = "";
            String result  = "";

            for (int i = 0; i < strCont.length(); i++){
                if (strCont.charAt(i)=='a' || strCont.charAt(i)=='e' || strCont.charAt(i) == 'y'
                        || strCont.charAt(i)=='i' || strCont.charAt(i)=='o' || strCont.charAt(i)=='u') {
                    strContNew += (char)strCont.charAt(i);
                }
            }

            for (int i = 1; i < str.length; i++) {
                strCont = "";
                strCont += str[i];
                strCont = strCont.toLowerCase();

                boolean check = false;
                for (int j = 0; j < strCont.length(); j++) {
                    if (strCont.charAt(j)=='a' || strCont.charAt(j)=='e' || strCont.charAt(i) == 'y'
                            || strCont.charAt(j)=='i' || strCont.charAt(j)=='o' || strCont.charAt(j)=='u') {
                        check = false;

                        for (int k = 0; k < strContNew.length(); k++) {
                            if (strCont.charAt(j) == strContNew.charAt(k)) check = true;
                        }
                        if (check != true) break;
                    }
                }
                if (check == true) result += strCont + " ";
            }
            System.out.println(str[0] + " " + result);
        }

        public static void Task6(String card) {
            if (card.length() >= 14 && card.length() < 19) {

                String num = "";
                num += card;
                int check_digit = (9 - (57 - num.charAt(num.length() - 1)));
                int[] array_digit = new int[num.length() - 1];

                for (int i = 0; i < array_digit.length; i++) {
                    array_digit[i] = (9 - (57 - num.charAt(i)));
                }

                int[] CardReverse = new int[array_digit.length];
                for (int i = 0; i < CardReverse.length; i++) {
                    CardReverse[i] = array_digit[array_digit.length - 1 - i];
                }

                for (int i = 0; i < CardReverse.length; i++) {

                    if (i % 2 == 0) CardReverse[i] = CardReverse[i] * 2;

                    if (CardReverse[i] > 9) CardReverse[i] = 1 + CardReverse[i] % 10;
                }

                int sum = 0;
                for (int i = 0; i < CardReverse.length; i++) {
                    sum = sum + CardReverse[i];
                }

                int check_sum = 10 - sum % 10;

                System.out.println(check_sum == check_digit);
            }
            else {
                System.out.println("false");
            }
        }

        public static void Task7(int number) {
            String [] dig1 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
                    "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                    "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
            String [] dig2 = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
                    "eighty", "ninety"};

            String num = "";
            String result = "";
            num += number;
            if (num.length() == 1) {
                result += dig1[number];
            }
            if (num.length() == 2) {
                if (number < 20) {
                    result += dig1[number];
                }
                else{
                    result += dig2[number / 10] + " " + dig1[number % 10];
                }
            }
            if (num.length() == 3){
                result += dig1[number / 100] + " hundred ";
                if (number % 100 < 20){
                    result += dig1[number];
                }
                else{
                    result += dig2[number % 100 / 10] + " " + dig1[number % 10];
                }
            }
            System.out.println(result);
        }

        public static byte[] Task8(String str) throws NoSuchAlgorithmException {
        MessageDigest msgdig = MessageDigest.getInstance("SHA-256");
        return msgdig.digest(str.getBytes(StandardCharsets.UTF_8));
        }

        public static void Task8_2(byte[] hash) {
            BigInteger num = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(num.toString(16));

            while (hexString.length() < 32) {
                hexString.insert(0,'0');
            }

            System.out.println(hexString.toString());
        }

    public static void Task9(String str) {
        String [] str1 = str.split(" ");
        String result = "";

        for(int  i = 0; i < str1.length; i++){
            String str2 = "";
            str2 += str1[i];
            str2 = str2.toLowerCase();

            boolean check = false;

            if (str2.charAt(0) == 'a' && str2.charAt(1) == 'n' && str2.charAt(2) == 'd' && str2.length() < 5) {
                result += str2 + " ";
                check =true;
            }
            if (str2.charAt(0) == 't' && str2.charAt(1) == 'h' && str2.charAt(2) == 'e' && str2.length() < 5) {
                result += str2 + " ";
                check =true;
            }
            if (str2.charAt(0) == 'o' && str2.charAt(1) == 'f' && str2.length() < 4) {
                result += str2 + " ";
                check =true;
            }
            if (str2.charAt(0) == 'i' && str2.charAt(1) == 'n' && str2.length() < 4) {
                result += str2 + " ";
                check =true;
            }
            if (check == false){
                str2 = str2.substring(0, 1).toUpperCase() + str2.substring(1);
                result += str2 + " ";
            }
        }
        System.out.println(result);
    }

    public static String Task10(int num) {
        int sum = 1, count = 1;
        while (sum < num)
        {
            sum = sum + (6 * count);
            count++;
        }
        if (sum != num) return "Ошибка!";

        else {
            int s = count * 2 - 1;

            int str = (s - 1) / 2;

            int p = s - count + 1;

            for (int i = 0; i < s; i++) {
                for (int j = 0; j < str; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < p; j++){
                    System.out.print("о ");
                }

                System.out.println("");
                if (i < (s - 1) / 2){
                    p++;
                    str--;
                }
                else{
                    p--;
                    str++;
                }
            }
            return "";
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        int key = 20, key1 = 4;

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
                    do {
                        do {
                            System.out.println("|1. Кодировать | |2. Декодировать | |3. Выход |");
                            key1 = inputInt();
                        } while ((key1 != 1) && (key1 != 2) && (key1 != 3));
                        switch (key1) {
                            case (1):
                                System.out.println("Введите строку");
                                String str = inputStr();
                                Task1(str);
                                break;

                            case (2):
                                System.out.println("Введите размер декодируемого сообщения");
                                int l = inputInt();
                                int[] n = new int[l];

                                for (int i = 0; i < l; i++) {
                                    n[i] = inputInt();
                                }
                                Task1_2(n);
                        }
                    } while (key1 != 3);
                    break;

                case (2):
                    System.out.println(Task2("rook", "A8", "H8"));
                    break;

                case (3):
                    System.out.println("Введите слово");
                    String word1 = inputStr();
                    System.out.println("Введите слово");
                    String word2 = inputStr();
                    Task3(word1, word2);
                    break;

                case (4):
                    System.out.println("Введите количество чисел");
                    int size = inputInt();
                    int[] num = new int[size];

                    for (int i = 0; i < num.length; i++) {
                        System.out.println("Введите число");
                        num[i] += inputInt();
                    }

                    Task4(num);
                    break;

                case (5):
                    System.out.println("Введите количество слов");
                    int n = inputInt();
                    String[] strWord = new String[n];

                    BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));

                    for (int i = 0; i < strWord.length; i++) {
                        System.out.println("Введите слово");
                        strWord[i] = enter.readLine();
                    }

                    Task5(strWord);
                    break;

                case (6):
                    System.out.println("Введите номер карты (длина должна быть не меньше 14 и не превышать 19)");
                    String card = inputStr();
                    Task6(card);
                    break;

                case (7):
                    System.out.println("Введите число*");
                    int number = inputInt();
                    Task7(number);
                    break;

                case (8):
                    System.out.println("Введите хешируемое сообщение");
                    String string = inputStr();
                    Task8_2(Task8(string));
                    break;

                case (9):
                    System.out.println("Введите строку");
                    String string1 = inputStr();
                    Task9(string1);
                    break;

                case (10):
                    System.out.println("Введите число");
                    int number1 = inputInt();
                    System.out.println(Task10(number1));
                    break;
            }

        } while (key != 11);
    }
}