package Logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyImplTest {

    /** Tests whether the getWord method of WordFrequencyImpl returns the correct value for null
     * (null string)
     */
    @Test
    void testGetWordNullWordString(){
        WordFrequency wordFrequency = new WordFrequencyImpl(null, 0);
        assertEquals(wordFrequency.getWord(), null);
    }

    /** Tests whether the getWord method of WordFrequencyImpl returns the correct value for ""
     * (empty string)
     */
    @Test
    void testGetWordEmptyWordString(){
        WordFrequency wordFrequency = new WordFrequencyImpl("", 0);
        assertEquals(wordFrequency.getWord(), "");
    }

    /** Tests whether the getWord method of WordFrequencyImpl returns the correct value for "Test"
     * (regular string)
     */
    @Test
    void testGetWordNonEmptyWordString(){
        WordFrequency wordFrequency = new WordFrequencyImpl("Test", 0);
        assertEquals(wordFrequency.getWord(), "Test");
    }

    /** Tests whether the getFrequency method of WordFrequencyImpl returns the correct value for 0
     * (0 value)
     */
    @Test
    void testGetZeroFrequency(){
        WordFrequency wordFrequency = new WordFrequencyImpl("", 0);
        assertEquals(wordFrequency.getFrequency(), 0);
    }

    /** Tests whether the getFrequency method of WordFrequencyImpl returns the correct value for 1000
     * (regular value)
     */
    @Test
    void testGetNonZeroFrequency(){
        WordFrequency wordFrequency = new WordFrequencyImpl("", 1000);
        assertEquals(wordFrequency.getFrequency(), 1000);
    }

    /** Tests whether the getWord and getFrequency methods of WordFrequencyImpl returns the correct value for
     *  "Test" and 10 (regular string and regular value)
     *
     */
    @Test
    void testGetBothWordAndFrequency(){
        WordFrequency wordFrequency = new WordFrequencyImpl("Test", 10);
        assertEquals(wordFrequency.getWord(), "Test");
        assertEquals(wordFrequency.getFrequency(), 10);
    }

    /** Tests whether the toString method  of WordFrequencyImpl returns the correct value for
     *  "Test" and 10 (regular string and regular value)
     *
     */
    @Test
    void testToStringMethod(){
        WordFrequency wordFrequency = new WordFrequencyImpl("Test", 10);
        assertEquals("(\"Test\", 10)", wordFrequency.toString());
    }

    /*@Test
    void testToStringMethodWithNullWord(){
        WordFrequency wordFrequency = new WordFrequencyImpl(null, 10);
        WordIsNullException exception = assertThrows(WordIsNullException.class, wordFrequency::toString);
    }*/

    /** Tests whether the toString method  of WordFrequencyImpl returns the correct value for
     *  "" and 10 (empty string and regular value)
     *
     */
    @Test
    void testToStringMethodWithEmptyWord(){
        WordFrequency wordFrequency = new WordFrequencyImpl("", 10);
        assertEquals("(\"\", 10)", wordFrequency.toString());
    }
}
