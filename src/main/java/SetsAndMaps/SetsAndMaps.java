package SetsAndMaps;

import java.util.*;

public class SetsAndMaps {
    public static void main (String[] args) {
        List <Integer> nums = new ArrayList<>(List.of(1,1,2,3,4,4,5,5,6,7));
        System.out.println("nums = " + nums);
        task1(nums);
        task2(nums);

        List<String> strings = new ArrayList<>(List.of("Hello","hello","HelLo","Sea","Blue","Yellow","Wall", "daNCe"));
        task3(strings);

    }

    public static void task1(List <Integer> nums) {

        List<Integer> result = new ArrayList<>();

        for (Integer i : nums) {
            if (i % 2 != 0) {
                result.add(i);
            }
        }

        System.out.println(result);

    }
    public static void task2(List <Integer> nums) {
        List<Integer> filter = new ArrayList<>();

        for (Integer i : nums) {
            if (i % 2 == 0) {
                filter.add(i);
            }
        }
        Set<Integer> result = new TreeSet<>(filter);
        System.out.println(result);
    }

    public static void task3 (List<String> strings) {
        Set<String> words = new HashSet<>(strings);
        System.out.println(words);
    }

    public static void task4 (List <String> strings) {
        Map<String, Integer> count = new HashMap<>();

        for (String str : strings) {
            if (!count.containsKey(str)) {
                count.put(str, 1);
            } else {
                count.put(str, count.get(str) + 1);
            }
        }
    }
}


