package pt.rumos.DigitalBank.management.utils;

import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static void writeLine(String str) {
        System.out.println(str);

    }

    public static void write(String str) {
        System.out.println(str);
    }


    public static int readInt() {
        return scanner.nextInt();
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }
}
