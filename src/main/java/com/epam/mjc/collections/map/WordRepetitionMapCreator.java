package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordRepetitionMapCreator {
    public Map<String, Integer> createWordRepetitionMap(String sentence) {
        Map<String, Integer> result = new HashMap<>();
        String[] words = sentence.replaceAll("[^\\w|\\s]", "").split(" ");
        if (words.length > 1) {
            for (String word : words) {
                String lowerCaseWord = word.toLowerCase(Locale.ROOT);
                if (result.putIfAbsent(lowerCaseWord, 1) != null) {
                    result.computeIfPresent(lowerCaseWord, (key, value) -> value + 1);
                }
            }
        }

        return result;
    }
}
