import Logic.WordFrequencyAnalyzer;
import Logic.WordFrequencyAnalyzerImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/** Dependency Injection
 *
 */
public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure(){
        bind(WordFrequencyAnalyzerImpl.class).to(WordFrequencyAnalyzer.class);
    }
}
