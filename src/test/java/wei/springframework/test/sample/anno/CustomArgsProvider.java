package wei.springframework.test.sample.anno;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * CustomArgsProvider.
 * TODO
 * 2019-06-20 06:58
 *
 * @author wei
 * @version 1.0.0
 **/
public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("A", 1, "1-1"),
                Arguments.of("B", 2, "2-1"),
                Arguments.of("C", 3, "3-1"),
                Arguments.of("D", 4, "4-1")
        );
    }
}
