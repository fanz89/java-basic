package soal_b.controller;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {

    public static MainController getInstance() {
        return SoalBHolder.INSTANCE;
    }

    private static class SoalBHolder {

        private static final MainController INSTANCE = new MainController();
    }

    public String methodA(String str) {

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append((Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }

        return sb.toString();
    }

    public String methodB(String str) {

        StringBuilder sb = new StringBuilder();

        char vowel[] = {'A', 'I', 'U', 'E', 'O', 'a', 'i', 'u', 'e', 'o'};
        boolean isVowel;

        for (char s : str.toCharArray()) {

            isVowel = false;

            for (char v : vowel) {
                if (s == v) {
                    isVowel = true;
                    break;
                }
            }

            sb.append((isVowel) ? "" : s);

        }

        return sb.toString();

    }

    public String methodC(String str) {

        str = str.replaceAll("Developer", "De5vl3o3pr");
        str = str.replaceAll("PT. ", "PT2.");
        str = str.replaceAll("Global", "Gbaik");
        str = str.replaceAll("Tiket", "t");
        str = str.replaceAll("Network", "Nwr");
        str = str.replaceAll(" ", "2");

        return str;
    }

    interface MyMap {
        Map<String, Integer> myMap(String str);
    }

    public void methodD(String text) {
        Map<String, Integer> map = new HashMap<>();

        MyMap kelompokanKata = (str) -> {
            String[] arrKata = str.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

            Arrays.stream(arrKata).forEach(kata -> {
                if (map.containsKey(kata)) {
                    map.put(kata, map.get(kata) + 1);
                } else {
                    map.put(kata, 1);
                }
            });

            return map;
        };

        // mengelompokan kata
        kelompokanKata.myMap(text);

        // Jumlah kata dari teks di atas
        System.out.println("Jumlah kata : " + map.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println();

        // Jumlah kemunculan tiap kata dari teks di atas
        System.out.println("Kemunculan kata : ");
        System.out.println(map.toString());
        System.out.println();

        // Jumlah kata yang hanya muncul satu kali
        System.out.println("Jumlah kata 1 kali muncul : " + map.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .mapToInt(Map.Entry::getValue)
                .sum());
        System.out.println();

        // Jumlah kata yang paling banyak muncul dan katanya
        System.out.print("Jumlah Kata yang paling banyak muncul : ");
        Integer max = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue)).get().getValue();

        Map<String, Integer> maxValue = map.entrySet()
                .stream()
                .filter(m -> m.getValue().equals(max))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(maxValue.size());
        System.out.println("Katanya : " + Arrays.toString(maxValue.keySet().toArray()));
        System.out.println();

        // Jumlah kata yang paling sedikit muncul dan katanya
        System.out.print("Jumlah Kata yang paling sedikit muncul : ");
        Integer min = map.entrySet()
                .stream()
                .min(Comparator.comparing(Map.Entry::getValue)).get().getValue();

        Map<String, Integer> minValue = map.entrySet()
                .stream()
                .filter(m -> m.getValue().equals(min))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(minValue.size());
        System.out.println("Katanya : " + Arrays.toString(minValue.keySet().toArray()));


    }

}
