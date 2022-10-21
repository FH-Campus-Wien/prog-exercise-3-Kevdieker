package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    public static void oneMonthCalendar(int dayCount, int firstDay) {

        int count = 1;

        //Keeps track where we are in the week
        int whatday = 0;

        //Prints spaces instead of days from last month
        for (int i = 1; i < firstDay; i++) {
            System.out.printf("   ");
            whatday++;
        }
        //Prints out entire Weeks
        for (int j = 1; j <= dayCount; j++) {

            // looks when the Week ends
            if (whatday % 7 == 0 && whatday != 0) {
                System.out.println();
            }
            System.out.print(String.format("%2d ", count));
            count++;
            whatday++;
        }

        //Required for AppTest
        System.out.println();
    }

    public static long[] lcg(long seed) {

        int a = 1103515245;
        int c = 12345;
        long m = (long) Math.pow(2, 31);

        long[] rdmNumsWithSeed = new long[11];
        long[] rdmNums = new long[10];

        rdmNumsWithSeed[0] = seed;

        //Fills Array with 10 generated Numbers from Seed
        for (int i = 1; i < 11; i++) {
            rdmNumsWithSeed[i] = ((rdmNumsWithSeed[i - 1] * a) + c) % m;
        }

        //Removes seed, so its edible
        for (int i = 0; i < 10; i++) {
            rdmNums[i] = rdmNumsWithSeed[i + 1];
        }

        return rdmNums;
    }

    public static void guessingGame(int numberToGuess) {

        int a = 0;

        Scanner onlyScanner = new Scanner(System.in);

        for (int i = 1; ; i++) {
            System.out.print("Guess number " + i + ": ");
            a = onlyScanner.nextInt();

            if (i == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            if (a > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");

            } else if (a < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (a == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }

        }
    }

    public static int randomNumberBetweenOneAndHundred() {

        /**
         * https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
         */

        Random rdmObj = new Random();
        int rdmNum = 1 + rdmObj.nextInt(100);

        return rdmNum;
    }

    public static boolean swapArrays(int[] x, int[] y) {

        if (x.length == y.length) {

            for (int i = 0; i < x.length; i++) {

                /* *******************************
                 *
                 *  x = a, y = b
                 *  x = x + y = a+b
                 *  y = x - y = (a+b)-b = a
                 *  x = x - y = (a+b)-a = b
                 *
                 **********************************/

                x[i] += y[i];
                y[i] = x[i] - y[i];
                x[i] -= y[i];

            }

            return true;
        }
        return false;
    }

    public static String camelCase(String string) {

        char[] chArray = string.toCharArray();
        boolean firstLetter = true;
        int spaceCount = 0;

        for (int whRV = 0; whRV < string.length(); whRV++) {

            //Overwrites Spaces with afterChar AND puts a \n in the last space AND says the next char is a firstLetter
            if (chArray[whRV] == ' ') {

                //Overwriting process...
                for (int j = whRV; j < string.length() - 1; j++) {
                    chArray[j] = chArray[j + 1];
                }

                //Fills the hole
                chArray[string.length() - 1] = '\0';

                spaceCount++;

                //Goes one Step back, in case of double spaces
                whRV--;

                firstLetter = true;


            } else if (chArray[whRV] >= '!' && chArray[whRV] <= '@') {

                for (int j = whRV; j < string.length() - 1; j++) {
                    chArray[j] = chArray[j + 1];
                }

                chArray[string.length() - 1] = '\0';
                spaceCount++;
                whRV--;

                //Make firstLetter smallchar to BIGCHAR
            } else if (chArray[whRV] >= 'a' && chArray[whRV] <= 'z' && firstLetter) {

                chArray[whRV] -= ' ';
                firstLetter = false;

                //Lets firstLetter BIGCHARs be BIGCHARs
            } else if (chArray[whRV] >= 'A' && chArray[whRV] <= 'Z' && firstLetter) {
                firstLetter = false;

                //Makes BIGCHAR to smallchar if not firstLetter
            } else if (chArray[whRV] >= 'A' && chArray[whRV] <= 'Z' && !firstLetter) {
                chArray[whRV] += ' ';
            }
        }

        return String.valueOf(chArray, 0, string.length() - spaceCount);
    }

    public static int checkDigit(int[] numbers) {

        int[] weighting = new int[numbers.length];
        int verifyCode = 0;
        int sum = 0;
        int rest = 0;

        for (int i = 0; i < numbers.length; i++) {

            weighting[i] += i + 2;
            numbers[i] *= weighting[i];
            sum += numbers[i];
        }

        rest = sum % 11;
        verifyCode = 11 - rest;

        if (verifyCode == 11) {
            verifyCode = 5;
        } else if (verifyCode == 10) {
            verifyCode = 0;
        }

        return verifyCode;
    }

    public static void main(String[] args) {
        //System.out.println(camelCase("! KeV iSt *Cool"));
/*

        char[] b= new char[]{'a', 'b','c' };

        char[] c= new char[b.length];

        char[] d= new char[c.length];

        for (int i=0;i< b.length-1;i++)
        {
                c[i] = b[i + 1];
        }
        for (int i=0;i< b.length-1;i++)
        {
            d[i] = c[i + 1];
        }


        c[b.length - 1] = 'G';



        System.out.println(String.valueOf(b));
        System.out.println(String.valueOf(c));
        System.out.println(String.valueOf(d));*/
    }
}