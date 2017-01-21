package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Ввести n чисел с консоли.
        System.out.println("Input 5 digits: ");
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        String[] words = digits.split(" ");
        lengths(words);
        System.out.println("Max digital: " + findLogest(words) + " " + "length " + findLogest(words).length());
        System.out.println("Min digital: " + findShorter(words) + " " + "length " + findShorter(words).length());
        decreaseOrder(words);
        increaseOrder(words);
        valueWithLenLessOrMoreThenAver(words);
        countNumWithEvenDigits(words);
        numWithDigitsInIncreaseOrder(words);
        numWithDifferentDigits(words);

    }

    // 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

    private static void numWithDifferentDigits(String[] words) {

        for (int i = 0; i < words.length; i++) {
            int tmp = 1;
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length - 1; j++) {

                if (Character.getNumericValue(word[j]) != Character.getNumericValue(word[j + 1])) {
                    tmp++;
                }
            }
            if (tmp == word.length && word.length > 1) {

                System.out.println("Number with different digits: " + words[i]);
                break;
            }
        }

    }

//6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

    private static void numWithDigitsInIncreaseOrder(String[] words) {

        for (int i = 0; i < words.length; i++) {
            int tmp = 1;
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length - 1; j++) {

                if (Character.getNumericValue(word[j]) < Character.getNumericValue(word[j + 1])) {
                    tmp++;
                }
            }
            //System.out.println("Tmp = " + tmp + " Length = "+ word.length);
            if (tmp == word.length && word.length > 1) {

                System.out.println("Number with digits in increase order: " + words[i]);
                break;
            }
        }
    }

//5. Найти количество чисел, содержащих только четные цифры,
// а среди них количество чисел с равным числом четных и нечетных цифр.

    private static void countNumWithEvenDigits(String[] words) {

        int count = 0;
        int count2 = 0;
        for (int i = 0; i < words.length; i++) {
            int even = 0, odd = 0;
            // System.out.println("Word to be parsed: " + words[i]);
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                //  System.out.println("Value " + Character.getNumericValue(word[j]));
                if (Character.getNumericValue(word[j]) % 2 == 0)
                    even++;
                else odd++;
            }
            if (even == word.length) //if amount of even digits equals length of the number add it to counter
                count++;
            if (even == odd)
                count2++;
        }
        System.out.println("Amount of numbers with ONLY even digits: " + count);
        System.out.println("Amount of numbers with EQUAL amount of even and odd digits: " + count2);
    }

//Длинны каждого слова в введённой строке

    private static void lengths(String[] words) {
        int[] sourceNumbers = new int[5];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            sourceNumbers[j] = words[i].length();
            j++;
        }
        {
            System.out.println("Lengths of each words: " + Arrays.toString(sourceNumbers));
        }
    }

    // 3. Вывести на консоль те числа, длина которых меньше или больше средней, а также длину.
    private static void valueWithLenLessOrMoreThenAver(String[] words) {

        double avr = 0;
        double sum = 0;

        for (int i = 0; i < words.length; i++) {
            sum += words[i].length();
        }
        {
            avr = sum / words.length;
            System.out.println("Average length: " + " " + avr);
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() < avr) {
                    System.out.println("Value with lenght less than avarage lenght: " + words[i] + ' ' + "lenght " + words[i].length());
                } else if (words[i].length() > avr) {
                    System.out.println("Value with lenght more than avarage lenght: " + words[i] + ' ' + "lenght " + words[i].length());
                }
            }
        }
    }

    //2. Упорядочить и вывести числа в порядке возрастания значений их длины.
    private static void increaseOrder(String[] words) {
        for (int i = words.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String tmp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tmp;
                }
            }
        }
        System.out.println("Increase order: " + Arrays.toString(words));
    }

    //2. Упорядочить и вывести числа в порядке убывания значений их длины.
    private static void decreaseOrder(String[] words) {

        for (int i = words.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (words[j].length() < words[j + 1].length()) {
                    String tmp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tmp;
                }
            }
        }
        System.out.println("Decrease order: " + Arrays.toString(words));
    }

    //1. Найти самое короткое число. Вывести найденные числа и их длину.
    static String findShorter(String[] words) {
        String pretendent = words[0].trim();
        for (int i = 0; i < words.length; i++) {
            if (pretendent.length() > words[i].trim().length())
                pretendent = words[i].trim();
        }

        return pretendent;
    }

    //1. Найти самое длинное число. Вывести найденные числа и их длину.
    static String findLogest(String[] words) {
        String pretendent = words[0].trim();
        for (int i = 0; i < words.length; i++) {
            if (pretendent.length() < words[i].trim().length())
                pretendent = words[i].trim();
        }
        return pretendent;
    }


}
