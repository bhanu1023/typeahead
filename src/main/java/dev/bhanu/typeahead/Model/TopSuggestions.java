package dev.bhanu.typeahead.Model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TopSuggestions {
    private Map<String, TreeSet<Suggestion>> topSuggestions;
    public TopSuggestions() {
        this.topSuggestions = new HashMap<>();
    }

    public TreeSet<Suggestion> getTopSuggestions(String prefix) {
        return topSuggestions.getOrDefault(prefix, new TreeSet<>());
    }

    public void setTopSuggestions(String prefix, String word, int frequency) {
        if(!topSuggestions.containsKey(prefix)){
            topSuggestions.put(prefix, new TreeSet<>());
        }
        if(topSuggestions.get(prefix).contains(new Suggestion(word, frequency))){
            topSuggestions.get(prefix).remove(new Suggestion(word, frequency));
        }
        topSuggestions.get(prefix).add(new Suggestion(word, frequency));
    }
}
