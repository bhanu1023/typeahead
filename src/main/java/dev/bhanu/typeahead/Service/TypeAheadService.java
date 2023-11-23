package dev.bhanu.typeahead.Service;

import dev.bhanu.typeahead.DTO.SuggestionDTO;
import dev.bhanu.typeahead.Model.Frequency;
import dev.bhanu.typeahead.Model.Suggestion;
import dev.bhanu.typeahead.Model.TopSuggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAheadService {

    private TopSuggestions topSuggestions;
    private Frequency frequencyMap;

    @Autowired
    public TypeAheadService(TopSuggestions topSuggestions, Frequency frequency) {
        this.topSuggestions = topSuggestions;
        this.frequencyMap = frequency;
    }

    public List<String> getTopSuggestions(String prefix) {
        addSuggestion(new SuggestionDTO(prefix));
        return topSuggestions.getTopSuggestions(prefix).stream().map(Suggestion::getWord).toList();
    }

    public void addSuggestion(SuggestionDTO prefix) {
        String word = prefix.getSuggestion();
        int frequency = frequencyMap.getFrequency(word) + 1;
        frequencyMap.setFrequency(word, frequency);

        for(int i=3;i<=word.length();i++){
            String subString = word.substring(0, i);
            if(topSuggestions.getTopSuggestions(subString).size() < 5){
                topSuggestions.setTopSuggestions(subString, word, frequency);
            }
            else{
                Suggestion lastSuggestion = topSuggestions.getTopSuggestions(subString).last();
                if(lastSuggestion.getFrequency() < frequency){
                    topSuggestions.getTopSuggestions(subString).remove(lastSuggestion);
                    topSuggestions.setTopSuggestions(subString, word, frequency);
                }
            }
        }
    }
}
