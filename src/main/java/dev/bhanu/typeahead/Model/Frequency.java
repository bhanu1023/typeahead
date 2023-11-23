package dev.bhanu.typeahead.Model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Frequency {
    private Map<String, Integer> frequencyMap;

    public Frequency() {
        this.frequencyMap = new HashMap<>();
    }

    public int getFrequency(String word) {
        return frequencyMap.getOrDefault(word, 0);
    }

    public void setFrequency(String word, int frequency) {
        frequencyMap.put(word, frequency);
    }
}
