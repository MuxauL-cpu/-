package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

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

    public static void Task1(int num) {
        if (num < 2) {
            System.out.println("1");
            return;
        }

        int [][] n = new int[num][num];

        for (int i=0; i < num;i++) {
            for (int j = 0; j < num; j++){
                n[i][j] = 0;
            }
        }

        int sum = 1, buf = 1;
        n[0][0] = buf;

        for (int i=1; i < num;i++) {
            n[i][0] = buf;
            for (int j = 0; j < sum; j++) {
                n[i][j + 1] = n[i][j] + n[i - 1][j];
                buf = n[i][j] + n[i - 1][j];
            }
            sum++;
        }

        for (int i = 0; i < num; i++){
            System.out.println(Arrays.toString(n[i]));
        }
        System.out.println(n[num - 1][num - 1]);
    }

    public static void Task2(String str) {
        String result = "";
        int l = 0;
        boolean check = false;
        String begin = "", end = "";


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E'
                    || str.charAt(i) == 'y' || str.charAt(i) == 'Y'
                    || str.charAt(i) == 'u' || str.charAt(i) == 'U'
                    || str.charAt(i) == 'i' || str.charAt(i) == 'I'
                    || str.charAt(i) == 'a' || str.charAt(i) == 'A') {
                break;
            }
            else {
                end += (char)str.charAt(i);
                l = i;
            }
        }

        if (str.charAt(0) == 'e' || str.charAt(0) == 'E'
        || str.charAt(0) == 'y' || str.charAt(0) == 'Y'
        || str.charAt(0) == 'u' || str.charAt(0) == 'U'
        || str.charAt(0) == 'i' || str.charAt(0) == 'I'
        || str.charAt(0) == 'a' || str.charAt(0) == 'A') {
            result = str + "yay";
        }
        else {
            if (str.charAt(0) >= 65 && str.charAt(0) <= 90) check = true;
        }

        result = str.substring(l + 1) + end;
        result = result.toLowerCase() + "ay";

        if (check == true) {
            begin = "";
            begin += (char)result.charAt(0);
            begin = begin.substring(1);
            end = result.substring(1);
            result = "";
            result = begin + end;
        }
        System.out.println(result);
    }

    public static void Task3(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) == 44)){
                newStr += (char)str.charAt(i);
            }
        }
        System.out.println(str);
        String [] numbers = newStr.split(",");

        int r =0;
        int g = 0;
        int b = 0;
        double a = 0;

        if (numbers.length == 3) {
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i].length()==0) {
                    System.out.println("Error");
                    return;
                }
            }
            r = Integer.parseInt(numbers[0]);
            g = Integer.parseInt(numbers[1]);
            b = Integer.parseInt(numbers[2]);
            if (r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) {
                System.out.println("False");
                return;
            }
            System.out.println("True");
        }
        if (numbers.length == 4) {
            String rgba = "";
            rgba += numbers[3].charAt(0);
            for (int i = 0; i < numbers.length; i++) {
                if(numbers[i].length()==0) {
                    System.out.println("Error");
                    return;
                }
            }
            r = Integer.parseInt(numbers[0]);
            g = Integer.parseInt(numbers[1]);
            b= Integer.parseInt(numbers[2]);
            a = Double.parseDouble(rgba);
            if (r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0 || a > 1 || a < 0) {
                System.out.println("False");
                return;
            }
            System.out.println("True");
        }
    }

    public static String Task4(String str) {
        String result = "";
        int i = 0;
        int l = 0;

        while (str.charAt(i) != '=') {
            i++;
        }
        l = i - 1;
        String str1 = str.substring(i-1);
        String[] strs = str1.split("&");

        for (i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i] != "" && strs[j] != "") {
                    if (strs[i].charAt(0) == strs[j].charAt(0)) {
                        strs[i] = strs[j];
                        strs[j] = "";
                    }
                }
            }
        }

        result += str.substring(0, l);
        for (i = 0; i < strs.length - 1; i++){
            result += strs[i] + "&";
        }
        while (result.charAt(result.length() - 1) == '&'){
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    public static void Task5(String str) {
        String [] array = str.split(" ");
        String temp = "";

        for (int i = 0; i < array.length; i++){
            temp = "";
            for (int j = 0; j < array[i].length(); j++) {
                if ((array[i].charAt(j) >= 65 && array[i].charAt(j) <= 90) || (array[i].charAt(j)>=97 && array[i].charAt(j) <= 122)) {
                    temp += (char)array[i].charAt(j);
                }
            }
            array[i] = "";
            array[i] += temp;
        }

        temp = "";
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++){
                if (array[j].length() > array[j + 1].length()) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        if (array.length>3) {
            Vector<String> result = new Vector<String>();
            int maxLength = array[array.length - 1].length();
            for (int i = array.length; i >= 0; i--) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j].length() == maxLength) {
                        result.add(array[j]);
                    }
                }
                maxLength--;
            }

            String [] print = new String[3];
            String word = "";
            for (int i = 0; i < 3; i++){
                word = "";
                word = result.get(i);
                word = word.toLowerCase();
                print[i] = "#"+ word;
            }
            System.out.println(Arrays.toString(print));
        }
        if (array.length == 3){
            String [] print = new String[3];
            String word = "";
            if (array[0].length() == array[1].length() && array[0].length() == array[2].length()){
                word = array[0].toLowerCase();
                print[0] = "#" + word;
                word = array[1].toLowerCase();
                print[1] = "#" + word;
                word = array[2].toLowerCase();
                print[2] = "#" + word;
            }
            if (array[0].length() == array[1].length() && array[0].length() != array[2].length()){
                word = array[2].toLowerCase();
                print[0] = "#" + word;
                word = array[0].toLowerCase();
                print[1] = "#" + word;
                word = array[1].toLowerCase();
                print[2] = "#" + word;
            }
            if (array[0].length() != array[1].length() && array[1].length() != array[2].length()){
                word = array[2].toLowerCase();
                print[0] = "#" + word;
                word = array[1].toLowerCase();
                print[1] = "#" + word;
                word = array[0].toLowerCase();
                print[1] = "#" + word;

            }
            System.out.println(Arrays.toString(print));
        }
        if (array.length == 2){
            String [] print = new String[2];
            String word = "";
            if (array[0].length() != array[1].length()){
                word = array[1].toLowerCase();
                print[0] = "#" + word;
                word = array[0].toLowerCase();
                print[1] = "#" + word;
            }
            else{
                word = array[10].toLowerCase();
                print[0] = "#" + word;
                word = array[1].toLowerCase();
                print[1] = "#" + word;
            }
            System.out.println(Arrays.toString(print));
        }
        if (array.length == 1){
            String [] print = new String[1];
            String word = array[0].toLowerCase();
            print [0] = "#" + word;
            System.out.println(Arrays.toString(print));
        }
    }

    public static void Task6(int num) {
        int MAX = 2000;
        Vector<Integer> arr = new Vector<Integer>();
        arr.add(1);
        arr.add(2);
        for (int i = 3; i < MAX; i++) {
            int count = 0;
            for (int j = 0; j < arr.size() - 1; j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(j) + arr.get(k) == i) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                arr.add(i);
            }
        }
        System.out.println(arr.get(num - 1));
    }

    public static void Task7(String str) {
        boolean check = false;
        String result = "";
        for (int k = 0; k < str.length()-1; k++) {
            String subArray = "";
            subArray += (char)str.charAt(k);
            for (int i = k + 1; i < str.length(); i++) {
                for (int j = 0; j < subArray.length(); j++) {
                    if (str.charAt(i) == subArray.charAt(j)) {
                        check = true;
                        break;
                    }
                }
                if (check != true) subArray += (char) str.charAt(i);
                else check = false;
            }
            if (subArray.length() > result.length()) {
                result = "";
                result += subArray;
            }
        }
        System.out.println(result);
    }

    public static void Task8(int num) {
        if (num > 3999) return;

        int [] numbers = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,90,100,200,300,400,500,900,1000,2000,3000};
        String [] str = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XX","XXX","XL","L",
                "XC","C","CC","CCC","CD","D","CM","M","MM","MMM"};
        String result = "";
        for (int i = numbers.length-1; i >= 0; i--){
            if (numbers[i] <= num){
                num = num - numbers[i];
                result += str[i];
            }
        }
        System.out.println(result);
    }


    public static void Task9(String str) {
        String [] num = str.split("=");
        int [] result = new int [num.length];

        for (int i = 0; i < num.length; i++) {
            String replace = num[i].trim();
            num[i] = "";
            num[i] = replace;
        }

        for (int i = 0; i < num.length; i++) {
            String [] block = num[i].split(" ");
            int op = 0;

            if (block.length==1) {
                op = Integer.parseInt(block[0]);
            }
            else{
                char oper = block[1].charAt(0);
                if ((int)oper =='+') {
                    op = Integer.parseInt(block[0]) + Integer.parseInt(block[2]);
                }
                if ((int)oper =='-') {
                    op = Integer.parseInt(block[0]) - Integer.parseInt(block[2]);
                }
                if ((int)oper=='*') {
                    op = Integer.parseInt(block[0]) * Integer.parseInt(block[2]);
                }
                if ((int)oper=='/') {
                    op = Integer.parseInt(block[0]) / Integer.parseInt(block[2]);
                }
            }
            result[i] = op;
        }
        int check = result[0];
        for (int i = 0; i < result.length; i++){
            if (result[i] != check){
                System.out.println("false");
            }
        }
        System.out.println("true");
    }

    public static void Task10(int num) {
        String array = "";
        String numbers = "";
        int one = 0, two = 0, sum = 0;

        array += num;
        if (array.length() % 2 != 0){
            System.out.println("false");
        }

        while (array.length() >= 2) {
            for (int i = 0; i < array.length() / 2; i++) {
                one = 9 - (57 - array.charAt(i * 2));
                two = 9 - (57 - array.charAt((i * 2) + 1));
                sum = one + two;
                numbers += sum;
            }
            if (numbers.length() >= 2) {
                array = numbers;
            }
            else{
                break;
            }
            numbers = "";
        }
        System.out.println(array);
        System.out.println(array.length() == 2 && (array.charAt(0) == array.charAt(1)));
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
                    System.out.println("Введите число");
                    int num = inputInt();
                    Task1(num);
                    break;

                case (2):
                    System.out.println("Введите слово");
                    String str = inputStr();
                    Task2(str);
                    break;

                case (3):
                    System.out.println("Введите слово");
                    String str1 = inputStr();
                    Task3(str1);
                    break;

                case (4):
                    System.out.println(Task4("https://edabit.com?a=1&b=2&a=2"));
                    break;

                case (5):
                    System.out.println("Введите строку");
                    String str2 = inputStr();
                    Task5(str2);
                    break;

                case (6):
                    System.out.println("Введите число");
                    int num1 = inputInt();
                    Task6(num1);
                    break;

                case (7):
                    System.out.println("Введите строку");
                    String str3 = inputStr();
                    Task7(str3);
                    break;

                case (8):
                    System.out.println("Введите число");
                    int num2 = inputInt();
                    Task8(num2);
                    break;

                case (9):
                    System.out.println("Введите строку");
                    String str4 = inputStr();
                    Task9(str4);
                    break;

                case (10):
                    System.out.println("Введите палиндром (число)");
                    int num3 = inputInt();
                    Task10(num3);
                    break;
            }

        } while (key != 11);
    }
}