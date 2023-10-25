package Task3;

import java.io.*;
import java.util.*;

public class TaskThree {
    public static void main(String[] args) throws IOException {
        File file = new File("files/words.txt");
        InputStream fis = new FileInputStream(file);

        Scanner s = new Scanner(fis);

        List<String> stringsList = new ArrayList<>();

        while (s.hasNextLine()) {
            String[] strings = s.nextLine().split(" ");
            for (String word: strings) {
                stringsList.add(word);
            }
        }

        Map<String, Integer> stringCountMap = new HashMap<>();

        for (String str : stringsList) {
            if (stringCountMap.containsKey(str)) {
                int count = stringCountMap.get(str);
                stringCountMap.put(str, count + 1);
            } else {
                stringCountMap.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        fis.close();
        s.close();
    }

}
