package ru.ywojctb.demo.api.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class StringService {


     public Map<Character, Integer> countCharacters(char[] chars) {

        Map<Character, Integer> map = new HashMap<>();

        for (char character : chars) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        return map;

    }

    private static Map<Character, Integer> sortedString(Map<Character, Integer> map) {

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> sortedMap.put(e.getKey(), e.getValue()));

        return sortedMap;
    }

}
