package Logic;

public class WordFrequencyImpl implements WordFrequency {
    private String word;
    private int frequency;

    public WordFrequencyImpl(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord(){
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public String toString() {
        return "(\""+ word +"\", " + frequency + ")";
    }
}
