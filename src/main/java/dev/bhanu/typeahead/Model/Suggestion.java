package dev.bhanu.typeahead.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion implements Comparable<Suggestion>{
    private String word;
    private int frequency;

    @Override
    public int compareTo(Suggestion other) {
        if (this.word.equals(other.word)){
            return 0;
        }
        return this.frequency > other.frequency ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }

}
