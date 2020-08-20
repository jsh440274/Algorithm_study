import java.util.Scanner;

public class Main {
    static char[][] testcase;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.nextLine();
        for (int testcount = 0; testcount < c; testcount++) {
            testcase = new char[5][5];
            for (int i = 0; i < 5; i++) {
                String line = sc.nextLine();
                testcase[i] = line.toCharArray();
            }
            int alreadyKnow = sc.nextInt();
            while (alreadyKnow != 0) {
                String givenLetter = sc.nextLine();
                System.out.println(givenLetter + " " + findLetters(givenLetter));
            }
        }
    }

    static String findLetters(String givenLetter, int testIndex, int currentIndex) {
        if (givenLetter.length() <= testIndex) {
            return "YES";
        }
        if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex - 1][currentIndex -1]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else if (givenLetter.charAt(testIndex) == testcase[currentIndex][currentIndex]) {
            return findLetters(givenLetter, testIndex + 1, currentIndex + 1);
        } else {
            return "NO";
        }
    }
}
