package Datatype;

/** The object that is used to consume the http post body for a request to find the number of frequencies in a text.
 * n is the number of frequencies to find
 * and text is the text to find the frequencies in.
 *
 */
public class HighestFrequencyForNWords extends HighestFrequencyRequest {
    private int n;

    public HighestFrequencyForNWords() {
    }

    public HighestFrequencyForNWords(String text, int n) {
        super(text);
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
