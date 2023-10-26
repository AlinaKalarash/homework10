package Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOne {

   public static void main(String[] args) throws IOException {
        File file = new File("files/file.txt");

        InputStream fis = new FileInputStream(file);

        Scanner s = new Scanner(fis);

        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");

        Pattern pattern1 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

        while (s.hasNextLine()) {
            String phoneNumber = s.nextLine();
            Matcher matcher = pattern.matcher(phoneNumber);
            Matcher matcher1 = pattern1.matcher(phoneNumber);
            if (matcher.find() || matcher1.find()) {
                System.out.println(phoneNumber);
            }

        }
        
        fis.close();
        s.close();
    }

}
