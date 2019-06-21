package wei.springframework.test.sample.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 2019-02-16.
 */
@Service
public class HearingInterpreter {

    @Autowired
    private WordProducer wordProducer;

    public String whatIheard(){
        String word = wordProducer.getWord();

        System.out.println(word);

        return word;
    }
}
