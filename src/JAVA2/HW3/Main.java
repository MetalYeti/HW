package JAVA2.HW3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Петр", "Александр", "Николай", "Петр", "Василий", "Иван", "Алексей", "Николай", "Андрей", "Александр", "Петр", "Василий"};

        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));
        System.out.println(wordsSet);

        Map<String, Integer> wordsCount = new HashMap<>();
        Arrays.asList(words).forEach(x -> wordsCount.put(x, wordsCount.getOrDefault(x, 0) + 1));
        System.out.println(wordsCount);

        PhoneBook pb = new PhoneBook();

        pb.add("Вася", 323233);
        pb.add("Вася", 323232);
        pb.add("Вася", 323231);
        pb.add("Вася", 323233);

        pb.add("Петя", 234567);
        pb.add("Петя", 234521);

        System.out.println(pb);
    }
}
