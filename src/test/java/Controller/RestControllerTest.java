package Controller;

import Datatype.HighestFrequencyForNWords;
import Datatype.HighestFrequencyForWord;
import Datatype.HighestFrequencyRequest;
import Logic.WordFrequency;
import Logic.WordFrequencyAnalyzer;
import Logic.WordFrequencyImpl;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class RestControllerTest extends JerseyTest {

    private WordFrequencyAnalyzer wfaMock = Mockito.mock(WordFrequencyAnalyzer.class);

    @Override
    protected Application configure(){
        ResourceConfig resourceConfig = new ResourceConfig(RestController.class);
        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(wfaMock).to(WordFrequencyAnalyzer.class);
                }
        });
        return resourceConfig;
    }

    /** Test whether the response status is correct (OK)
     *
     */
    @Test
    public void returnHighestFrequencyWordResponseOkTest(){
        String testString = "A test string.";
        when(wfaMock.calculateHighestFrequency("A test string.")).thenReturn(1);
        HighestFrequencyRequest hfr = new HighestFrequencyRequest(testString);
        Entity<HighestFrequencyRequest> entity = Entity.entity(hfr, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateHighestFrequency").request().post(entity);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    /** Test whether the response status is correct (OK)
     *
     */
    @Test
    public void testReturnHighestFrequencyWordResponseOk(){
        String testString = "A test string.";
        String testWord = "test";
        when(wfaMock.calculateFrequencyForWord(testString, testWord)).thenReturn(1);
        HighestFrequencyForWord hfrw = new HighestFrequencyForWord(testString, testWord);
        Entity<HighestFrequencyForWord> entity = Entity.entity(hfrw, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateFrequencyForWord").request().post(entity);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    /** Test whether the response status is correct (OK)
     *
     */
    @Test
    public void testReturnMostFrequentNWordsResponseOk(){
        String testString = "A test string.";
        int testN = 2;
        ArrayList<WordFrequency> array = new ArrayList<>(2);
        array.add(new WordFrequencyImpl("A", 1));
        array.add(new WordFrequencyImpl("string", 1));
        when(wfaMock.calculateMostFrequentNWords(testString, testN)).thenReturn(array);
        HighestFrequencyForNWords hffnw = new HighestFrequencyForNWords(testString, testN);
        Entity<HighestFrequencyForNWords> entity = Entity.entity(hffnw, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateMostFrequentNWords").request().post(entity);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    /** Test whether the response media is of the type plain text
     *
     */
    @Test
    public void returnHighestFrequencyWordResponseMediaTypeShouldBePlainText(){
        String testString = "A test string.";
        when(wfaMock.calculateHighestFrequency("A test string.")).thenReturn(1);
        HighestFrequencyRequest hfr = new HighestFrequencyRequest(testString);
        Entity<HighestFrequencyRequest> entity = Entity.entity(hfr, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateHighestFrequency").request().post(entity);
        assertEquals(MediaType.TEXT_PLAIN, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    }

    /** Test whether the response media is of the type plain text
     *
     */
    @Test
    public void testReturnHighestFrequencyWordResponseMediaTypeShouldBePlainText(){
        String testString = "A test string.";
        String testWord = "test";
        when(wfaMock.calculateFrequencyForWord(testString, testWord)).thenReturn(1);
        HighestFrequencyForWord hfrw = new HighestFrequencyForWord(testString, testWord);
        Entity<HighestFrequencyForWord> entity = Entity.entity(hfrw, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateFrequencyForWord").request().post(entity);
        assertEquals(MediaType.TEXT_PLAIN, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    }

    /** Test whether the response media is of the type plain text
     *
     */
    @Test
    public void testReturnMostFrequentNWordsResponseMediaTypeShouldBePlainText(){
        String testString = "A test string.";
        int testN = 2;
        ArrayList<WordFrequency> array = new ArrayList<>(2);
        array.add(new WordFrequencyImpl("A", 1));
        array.add(new WordFrequencyImpl("string", 1));
        when(wfaMock.calculateMostFrequentNWords(testString, testN)).thenReturn(array);
        HighestFrequencyForNWords hffnw = new HighestFrequencyForNWords(testString, testN);
        Entity<HighestFrequencyForNWords> entity = Entity.entity(hffnw, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateMostFrequentNWords").request().post(entity);
        assertEquals(MediaType.TEXT_PLAIN, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
    }

    /** Test whether the contents of the response are correct.
     *
     */
    @Test
    public void returnHighestFrequencyWordResponseTextShouldBeCorrect(){
        String testString = "A test string.";
        when(wfaMock.calculateHighestFrequency("A test string.")).thenReturn(1);
        HighestFrequencyRequest hfr = new HighestFrequencyRequest(testString);
        Entity<HighestFrequencyRequest> entity = Entity.entity(hfr, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateHighestFrequency").request().post(entity);
        assertEquals(response.readEntity(String.class), "1");
    }

    /** Test whether the contents of the response are correct.
     *
     */
    @Test
    public void testReturnHighestFrequencyWordResponseTextShouldBeCorrect(){
        String testString = "A test string.";
        String testWord = "test";
        when(wfaMock.calculateFrequencyForWord(testString, testWord)).thenReturn(1);
        HighestFrequencyForWord hfrw = new HighestFrequencyForWord(testString, testWord);
        Entity<HighestFrequencyForWord> entity = Entity.entity(hfrw, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateFrequencyForWord").request().post(entity);
        assertEquals(response.readEntity(String.class), "1");
    }

    /** Test whether the contents of the response are correct.
     *
     */
    @Test
    public void testReturnMostFrequentNWordsResponseTextShouldBeCorrect(){
        String testString = "A test string.";
        int testN = 2;
        ArrayList<WordFrequency> array = new ArrayList<>(2);
        array.add(new WordFrequencyImpl("a", 1));
        array.add(new WordFrequencyImpl("string", 1));
        when(wfaMock.calculateMostFrequentNWords(testString, testN)).thenReturn(array);
        HighestFrequencyForNWords hffnw = new HighestFrequencyForNWords(testString, testN);
        Entity<HighestFrequencyForNWords> entity = Entity.entity(hffnw, MediaType.APPLICATION_JSON);
        Response response = target("/WordAnalyzer/calculateMostFrequentNWords").request().post(entity);
        assertEquals(response.readEntity(String.class), "[(\"a\", 1), (\"string\", 1)]");
    }

    /** Test whether the input parameters to the method call calculateHighestFrequency are correct
     *
     */
    @Test
    public void returnHighestFrequencyWordInputParametersShouldBeCorrect(){
        String testString = "A test string.";
        HighestFrequencyRequest hfr = new HighestFrequencyRequest(testString);
        Entity<HighestFrequencyRequest> entity = Entity.entity(hfr, MediaType.APPLICATION_JSON);
        target("/WordAnalyzer/calculateHighestFrequency").request().post(entity);

        Mockito.verify(wfaMock, times(1)).calculateHighestFrequency(testString);
    }

    /** Test whether the input parameters to the method call calculateFrequencyForWord are correct
     *
     */
    @Test
    public void testReturnHighestFrequencyWordInputParametersShouldBeCorrect(){
        String testString = "A test string.";
        String testWord = "test";
        HighestFrequencyForWord hfrw = new HighestFrequencyForWord(testString, testWord);
        Entity<HighestFrequencyForWord> entity = Entity.entity(hfrw, MediaType.APPLICATION_JSON);
        target("/WordAnalyzer/calculateFrequencyForWord").request().post(entity);

        Mockito.verify(wfaMock, times(1)).calculateFrequencyForWord(testString, testWord);
    }

    /** Test whether the input parameters to the method call calculateMostFrequentNWords are correct
     *
     */
    @Test
    public void testReturnMostFrequentNWordsInputParametersShouldBeCorrect(){
        String testString = "A test string.";
        int testN = 2;
        HighestFrequencyForNWords hffnw = new HighestFrequencyForNWords(testString, testN);
        Entity<HighestFrequencyForNWords> entity = Entity.entity(hffnw, MediaType.APPLICATION_JSON);
        target("/WordAnalyzer/calculateMostFrequentNWords").request().post(entity);

        Mockito.verify(wfaMock, times(1)).calculateMostFrequentNWords(testString, 2);
    }
}
