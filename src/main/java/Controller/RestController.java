package Controller;

import Datatype.HighestFrequencyForNWords;
import Datatype.HighestFrequencyForWord;
import Datatype.HighestFrequencyRequest;
import Logic.WordFrequency;
import Logic.WordFrequencyAnalyzer;
import Logic.WordFrequencyAnalyzerImpl;
import Logic.WordFrequencyImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("WordAnalyzer")
public class RestController {
    @Inject
    private WordFrequencyAnalyzer wfa;// = new WordFrequencyAnalyzerImpl();

    /** the method that is called on the path "calculateHighestFrequency" that
     * should return the highest frequency of a word found in a text
     *
     * @param hfr the object that contains the text to analyze for the highest frequency
     * @return a response with the answer
     */
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("calculateHighestFrequency")
    public Response returnHighestFrequencyWord(HighestFrequencyRequest hfr) {
        System.out.println(hfr.getText());
        int frequency = wfa.calculateHighestFrequency(hfr.getText());
        return Response.status(200).entity(frequency).build();
    }

    /** the method that is called on the path "calculateFrequencyForWord" that
     * should return the highest frequency of a word found in a text
     *
     * @param hfw the object that contains the text to analyze for the highest frequency
     *            , it also contains the word to analyze the text for
     * @return a response with the answer
     */
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("calculateFrequencyForWord")
    public Response returnFrequencyForWord(HighestFrequencyForWord hfw) {
        System.out.println("Text: " + hfw.getText() + "\nWord: " + hfw.getWord());
        int frequency = wfa.calculateFrequencyForWord(hfw.getText(), hfw.getWord());
        return Response.status(200).entity(frequency).build();
    }

    /** the method that is called on the path "calculateMostFrequentNWords" that
     * should return the n highest frequency of the words found in a text
     *
     * @param hffnw the object that contains the text and the number of frequencies to find
     * @return a response with the answer
     */
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("calculateMostFrequentNWords")
    public Response returnMostFrequentNWords(HighestFrequencyForNWords hffnw) {
        System.out.println(hffnw.getText() + "\nn words: " + hffnw.getN());
        List<WordFrequency> wordFrequencies = wfa.calculateMostFrequentNWords(hffnw.getText(), hffnw.getN());
        return Response.status(200).entity(wordFrequencies.toString()).build();
    }

    /** Testing method that doesnt have any real function.
     * It's main purpose it to see whether the service is online and working (and the other methods do not work)
     * or if it is completely down
     *
     * @return
     */
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("test")
    public Response hello1() {
        return Response.status(200).entity("hello").build();
    }
}
