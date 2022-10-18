package org.example.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * InputUtil class includes methods to check format of user's input.
 */
public class InputUtil {

    /**
     * The method to check if input is an integer.
     */
    public static int getInteger(String hint, Scanner scanner) {
        System.out.print(hint);
        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("Your input should be an integer!");
            return getInteger(hint, scanner);
        }
    }

    public static String getString(String hint, Scanner scanner) {
        System.out.print(hint);
        return scanner.nextLine();
    }

    /**
     * The method to check date format.
     */
    public static Date[] getRentDay(String hint, Scanner scanner) {
        String string = getString(hint, scanner);
        if (string.split(" ").length != 2) {
            System.out.println("Invalid format!");
            return getRentDay(hint, scanner);
        }
        String[] s = string.split(" ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date start = simpleDateFormat.parse(s[0]);
            Date end = simpleDateFormat.parse(s[1]);
            if (start.after(end)) {
                System.out.println("Your pick-up date should be earlier than return date!");
                return getRentDay(hint, scanner);
            }
            return new Date[]{start, end};
        } catch (ParseException e) {
            System.out.println("Invalid format!");
            return getRentDay(hint, scanner);
        }
    }

    /**
     * The method to calculate rent days.
     */
    public static int getRentDay(Date[] dates) {
        return (int) (((dates[1].getTime() - dates[0].getTime()) / 24 / 60 / 60 / 1000) + 1);
    }

    public static boolean confirm(String hint, Scanner scanner) {
        System.out.print(hint);
        String s = scanner.nextLine();
        return s.equals("Y") || s.equals("y");
    }

    /**
     * The method to check email format input by user.
     */
    public static boolean checkEmail(String emailAddress) {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        return regex.matcher(emailAddress).matches();
    }
}
