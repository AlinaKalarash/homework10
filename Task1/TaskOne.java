package Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) throws IOException {
        File file = new File("files/file.txt");

        InputStream fis = new FileInputStream(file);

        Scanner s = new Scanner(fis);

        while (s.hasNextLine()) {
            String phoneNumber = s.nextLine();
            if (isValid(phoneNumber) || isValid1(phoneNumber)) {
                System.out.println(phoneNumber);
            }

        }


        fis.close();
        s.close();
    }



    //xxx-xxx-xxxx
    public static boolean isValid(String phoneNumber) {
        String[] parts = phoneNumber.split("-");

        if (parts.length != 3) {
            return false;
        }
        if (parts[0].length() != 3 || parts[1].length() != 3 || parts[2].length() != 4) {
            return false;
        }

        for (String part : parts) {

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }



    //(xxx) xxx-xxxx
    public static boolean isValid1(String phoneNumber) {
        String[] parts = phoneNumber.split(" ");

        for (int i = 0; i < parts[0].toCharArray().length; i++) {
            char[] c = parts[0].toCharArray();
            if (c[0] != '(' || !Character.isDigit(c[1]) || !Character.isDigit(c[2]) || !Character.isDigit(c[3]) || c[4] != ')') {
                return false;
            }

        }
        String[] partsOfParts = parts[1].split("-");
        if (partsOfParts.length != 2) {
            return false;
        }
        if (partsOfParts[0].length() != 3 || partsOfParts[1].length() != 4) {
            return false;
        }
        for (String part : partsOfParts) {

            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }

        return true;
    }

}
