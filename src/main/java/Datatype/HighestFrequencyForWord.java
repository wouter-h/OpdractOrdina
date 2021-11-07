package Datatype;

/** The object that is used to consume the http post body for a request to find the frequency of a word in a text.
 * word is the word to find the frequencies of
 * and text is the text to find the frequencies in.
 *
 */
public class HighestFrequencyForWord extends HighestFrequencyRequest {
    private String word;

    public HighestFrequencyForWord() {
    }

    public HighestFrequencyForWord(String text, String word) {
        super(text);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
