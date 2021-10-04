package basic.codelab05.domain;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {
    private final static String TEST_BODY = "A very short and a very silly post.";

    @Test
    void getAllUniqueWordsFromBodyTest() {
        BlogPost blogPost = new BlogPost(new Author("testAuthor"), "testTitle", TEST_BODY, Category.DIY);

        Collection<String> uniqueWords = blogPost.getAllUniqueWordsFromBody();

        assertTrue(uniqueWords.containsAll(List.of("a", "very", "short", "and", "silly", "post")));
    }
}