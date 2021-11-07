package Datatype;

/** The object that is used to consume the http post body for a request to find the highest frequency of a word
 *  in a text.
 * text is the text to find the frequencies in.
 *
 */
public class HighestFrequencyRequest {
    private String text;

    public HighestFrequencyRequest() {
    }

    public HighestFrequencyRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
