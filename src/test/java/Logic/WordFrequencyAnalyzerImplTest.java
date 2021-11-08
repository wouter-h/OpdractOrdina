package Logic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyAnalyzerImplTest {

    @Test
    void testCalculateHighestFrequencyWithNullString(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency(null), 0);
    }

    @Test
    void testCalculateHighestFrequencyWithEmptyString(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency(""), 0);
    }

    @Test
    void testCalculateHighestFrequencyWithNonLetters(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency(",.\\/,/.,, ..,- --08 64 33"), 0);
    }

    @Test
    void testCalculateHighestFrequencyWithNonLatinLetters(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency("ÖÖçç ÖÖçÖÖç ÖÖçÖÖç"), 0);
    }

    @Test
    void testCalculateHighestFrequencyWithNonLatinLettersWithEmptySpaceInFront(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency(" ÖÖçç ÖÖçÖÖç ÖÖçÖÖç"), 0);
    }

    @Test
    void testCalculateHighestFrequencyCheckingForSingleLetter(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency("testt ttest tesst e"), 1);
    }

    @Test
    void testCalculateHighestFrequencyCapitalization(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency("The the tHe over the THE"), 5);
    }

    @Test
    void testCalculateHighestFrequencyNormalSentence1(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency("The sun shines over the lake"), 2);
    }

    @Test
    void testCalculateHighestFrequencyNormalSentence2(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateHighestFrequency("The sun shines bright."), 1);
    }

    @Test
    void testCalculateFrequencyForWordWithNullText(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord(null, "test"), 0);
    }

    @Test
    void testCalculateFrequencyForWordWithEmptyText(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("", "test"), 0);
    }

    @Test
    void testCalculateFrequencyForWordWithNullWord(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("test text", null), 0);
    }

    @Test
    void testCalculateFrequencyForWordWithEmptyWord(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("test text", ""), 0);
    }

    @Test
    void testCalculateFrequencyForWordNonExistingWord(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("Hello World! How is everyone doing?", "Sun"), 0);
    }

    @Test
    void testCalculateFrequencyForWordNonExistingWord2(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("Hello World! How is everyone doing?", "e"), 0);
    }

    @Test
    void testCalculateFrequencyForWordWithNoWordsPresent(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("!@#$%&% %^&$^ (^% '''' ,. ,. ,.", "test"), 0);
    }

    @Test
    void testCalculateFrequencyForWordNormal1(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord("Hello World!", "world"), 1);
    }

    @Test
    void testCalculateFrequencyForWordNormal1WithSpaceInFront(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord( "Hello World!", "world"), 1);
    }

    @Test
    void testCalculateFrequencyForWordWordHasCapitals(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord( "Hello World!", "wORld"), 1);
    }

    @Test
    void testCalculateFrequencyForWordWithNonLatinWords(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        assertEquals(wordFrequencyAnalyzer.calculateFrequencyForWord( " ÖÖçç Hello ÖÖçç World!   ÖÖçç ÖÖçç ÖÖçç ", "wORld"), 1);
    }

    @Test
    void testCalculateMostFrequentNWordsNullText(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords(null, 3);
        assertEquals("[]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWordsEmptyText(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("", 3);
        assertEquals("[]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWordsWithN0(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("test test la l1", 0);
        assertEquals("[]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWordsWithNNegative(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("test test la l1", -1);
        assertEquals("[]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWordsWithNMuchBigger(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("test test la l1", 10000);
        assertEquals("[(\"test\", 2), (\"l\", 1), (\"la\", 1)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords1(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("test test la l1", 3);
        assertEquals("[(\"test\", 2), (\"l\", 1), (\"la\", 1)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords2(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("test test la l1", 1);
        assertEquals("[(\"test\", 2)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords3(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("test test la l1", 2);
        assertEquals("[(\"test\", 2), (\"l\", 1)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords4(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("mmmm l mmm test mm m test test la l1", 2);
        assertEquals("[(\"test\", 3), (\"l\", 2)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords5(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("\"The sun suun suuun sn shines bright bright0brIGHT.\"", 7);
        assertEquals("[(\"bright\", 3), (\"shines\", 1), (\"sn\", 1), (\"sun\", 1), (\"suun\", 1), (\"suuun\", 1), (\"the\", 1)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords6(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("\"The suuun suun sun sn shines bright bright0brIGHT.\"", 7);
        assertEquals("[(\"bright\", 3), (\"shines\", 1), (\"sn\", 1), (\"sun\", 1), (\"suun\", 1), (\"suuun\", 1), (\"the\", 1)]", words.toString());
    }

    @Test
    void testCalculateMostFrequentNWords7(){
        WordFrequencyAnalyzer wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
        List<WordFrequency> words = wordFrequencyAnalyzer.calculateMostFrequentNWords("\"The suuun suuun suun suun sun sun sun sn sn sn sn shines bright bright0brIGHT.\"", 7);
        assertEquals("[(\"sn\", 4), (\"bright\", 3), (\"sun\", 3), (\"suun\", 2), (\"suuun\", 2), (\"shines\", 1), (\"the\", 1)]", words.toString());
    }
}
