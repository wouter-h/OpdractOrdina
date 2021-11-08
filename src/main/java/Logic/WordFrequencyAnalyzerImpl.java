package Logic;

import jakarta.annotation.ManagedBean;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer{

    /** Calculates the highest frequency of a word in a text
     *
     * @param text the text to find the highest frequency in
     * @return the highest frequency
     */
    public int calculateHighestFrequency(String text){
        if(text == null){
            return 0;
        }
        String lowerCaseText = text.toLowerCase();
        List<String> wordsInText = getWordsInText(lowerCaseText);
        int highestFrequency = 0;
        for(int i = 0; i < wordsInText.size(); ++i){
            int frequency = calculateFrequencyForWord(wordsInText, wordsInText.get(i));
            if(frequency > highestFrequency){
                highestFrequency = frequency;
            }
        }
        return highestFrequency;
    }

    /** Calculates the frequency of a word in a text
     *
     * @param text the text to calculate the frequency of a word in
     * @param word the word the calculate the frequency of
     * @return the frequency
     */
    public int calculateFrequencyForWord(String text, String word) {
        if(word == null || word.length() == 0 || text == null){
            return 0;
        }
        String lowerCaseText = text.toLowerCase();
        String lowercaseWord = word.toLowerCase();
        List<String> wordsInText = getWordsInText(lowerCaseText);
        return calculateFrequencyForWord(wordsInText, lowercaseWord);
    }

    /** Calculates the highest frequency of n words in a text
     * It calculates the n highest frequencies, and in case of tie breakers in alphabetically ascending order
     *
     * @param text the text to calculate the frequencies in
     * @param n the n highest words to return
     * @return the List of words and corresponding frequencies of the n highest words
     */
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        if(text == null){
            return new ArrayList<>(0);
        }
        String lowerCaseText = text.toLowerCase();
        List<WordFrequency> wordFrequencies = new ArrayList<>();
        List<String> wordsInText = getWordsInText(lowerCaseText);
        for(String word : wordsInText) {
            int frequency = calculateFrequencyForWord(text, word);
            addWord(wordFrequencies, new WordFrequencyImpl(word, frequency));
        }
        return getHighestNWords(wordFrequencies, n);
    }

    /** A helper function that returns all the words in a text
     *
     * @param text the text to find the words in
     * @return the List of words
     */
    private List<String> getWordsInText(String text){
        List<String> words = new ArrayList<>();
        int textLength = text.length();
        for(int i = 0; i < textLength; ++i){
            StringBuilder sb = new StringBuilder();
            while(i < textLength && WordFrequencyAnalyzerImpl.isLetter(text.charAt(i))){
                sb.append(text.charAt(i));
                ++i;
            }
            String word = sb.toString();
            if(word.length() > 0) {
                words.add(word);
            }
        }
        return words;
    }

    /** Calculates the frequency of a word appearing in a List of words
     *
     * @param text the List of words to calculate the frequency of a word in
     * @param word the word to calculate the frequency of
     * @return the frequency
     */
    private int calculateFrequencyForWord(List<String> text, String word) {
        if(word == null || word.length() == 0 || text == null){
            return 0;
        }
        int frequency = 0;
        for(String w : text){
            if(w.equals(word)) {
                ++frequency;
            }
        }
        return frequency;
    }

    /** It checks whether a character is a latin character
     *
     * @param c the character
     * @return true if it is, false otherwise
     */
    //non latin characters
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    /** The method that adds a word to the word frequencies list.
     * It does so by doing a binary search and inserting it in the right placce.
     * The result should always be a List order from high to low frequency wise, and
     * in the case of tie-breakers in alphabetically ascending order
     *
     * @param wordFrequencies The list to add the word in
     * @param wordFrequency The word to add
     */
    private static void addWord(List<WordFrequency> wordFrequencies, WordFrequency wordFrequency) {
        int left = 0;
        int right = wordFrequencies.size() - 1;
        int middle = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (wordFrequencies.get(middle).getFrequency() == wordFrequency.getFrequency()) {
                if(wordFrequencies.get(middle).getWord().compareTo(wordFrequency.getWord()) < 0){
                    left = middle + 1;
                } else if(wordFrequencies.get(middle).getWord().compareTo(wordFrequency.getWord()) > 0) {
                    right = middle - 1;
                } else { //word already exists in the list
                    return;
                }
            }
            if (wordFrequencies.get(middle).getFrequency() < wordFrequency.getFrequency()) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        middle = left + (right - left) / 2;
        wordFrequencies.add(middle, wordFrequency);
    }

    /** Returns a list of the n highest frequency words
     *
     * @param wordFrequencies the list to find the N highest frequencies in, this list should already be sorted
     * @param n the n highest frequencies to find
     * @return the List of n highest frequencies
     */
    private static List<WordFrequency> getHighestNWords(List<WordFrequency> wordFrequencies, int n){
        if(n > wordFrequencies.size()){
            n = wordFrequencies.size();
        }
        if(n < 0){
            n = 0;
        }
        return wordFrequencies.subList(0, n);
    }
}
