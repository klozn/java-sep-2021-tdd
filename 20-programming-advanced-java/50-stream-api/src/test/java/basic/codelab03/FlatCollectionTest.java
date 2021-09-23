package basic.codelab03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static basic.codelab03.FlatCollection.transform;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class FlatCollectionTest {

    @Test
    void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(transform(collection)).hasSameElementsAs(expected);
    }

}
