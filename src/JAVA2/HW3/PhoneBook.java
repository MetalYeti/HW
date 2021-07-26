package JAVA2.HW3;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<Integer>> phones = new HashMap<>();

    public Set<Integer> get(String name) {
        return phones.get(name);
    }

    public void add(String name, int phone) {
        if (phones.containsKey(name)){
            phones.get(name).add(phone);
        }else{
            Set<Integer> phoneSet = new HashSet<>();
            phoneSet.add(phone);
            phones.put(name, phoneSet);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        phones.forEach((k, v) -> sb.append(k).append(": ").append(v).append("\n"));

        return sb.toString();
    }
}
