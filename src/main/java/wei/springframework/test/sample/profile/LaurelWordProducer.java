package wei.springframework.test.sample.profile;

import org.springframework.stereotype.Component;

/**
 * Created by jt on 2019-02-16.
 */
@Component
public class LaurelWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Laurel";
    }
}
