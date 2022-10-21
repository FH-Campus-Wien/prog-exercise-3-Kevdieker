package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar(int dayCount, int firstDay) {

        int count = 1;

        // Keeps Track where we are in the week
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
        int rdmNum = 1 + rdmObj.nextInt(101);

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

            //Makes Spaces go away
            if (chArray[whRV] == ' ') {

                for (int j = whRV; j < string.length() - 1; j++) {
                    chArray[j] = chArray[j + 1];
                }

                chArray[string.length() - 1] = '\n';
                spaceCount++;
                whRV--;

                firstLetter = true;

                //Makes SpecialCases go away
            } else if (chArray[whRV] > 32 && chArray[whRV] < 65) {

                for (int j = whRV; j < string.length() - 1; j++) {
                    chArray[j] = chArray[j + 1];
                }

                chArray[string.length() - 1] = '\n';
                spaceCount++;
                whRV--;

                //Makes smallchar BIGchar
            } else if (chArray[whRV] >= 97 && chArray[whRV] <= 122 && firstLetter) {

                chArray[whRV] -= 32;
                firstLetter = false;

            } else if (chArray[whRV] >= 65 && chArray[whRV] <= 90 && firstLetter) {
                firstLetter = false;
            }

            //Makes BIGchar smallchar
            else if (chArray[whRV] >= 65 && chArray[whRV] <= 90 && !firstLetter) {
                chArray[whRV] += 32;
            }
        }

        return String.valueOf(chArray, 0, string.length() - spaceCount);
    }


    public static void main(String[] args) {


    }
}