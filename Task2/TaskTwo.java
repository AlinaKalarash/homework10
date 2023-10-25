package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.Scanner;

class TaskTwo {
    public static void main(String[] args) throws IOException {
        File file = new File("files/file2.txt");
        InputStream fis = new FileInputStream(file);

        Scanner s = new Scanner(fis);

        String[] headings = s.nextLine().split(" ");

        while (s.hasNextLine()) {
            String[] userData = s.nextLine().split(" ");
            User user = new User(userData[0], Integer.parseInt(userData[1]));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(user);

            System.out.println(json);
        }

        fis.close();
        s.close();
    }
}

class User {
    private String name;
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
