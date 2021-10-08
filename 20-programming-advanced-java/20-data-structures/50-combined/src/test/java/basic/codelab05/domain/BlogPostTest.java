package basic.codelab05.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class BlogPostTest {
    private final static String TEST_BODY = "A very short, and a very silly post.";

    @Test
    void getAllUniqueWordsFromBodyTest() {
        var blogPost = new BlogPost(new Author("testAuthor"), "testTitle", TEST_BODY, Category.DIY, LocalDate.now());

        var uniqueWords = blogPost.getAllUniqueWordsFromBody();

        assertThat(uniqueWords).containsExactly("a", "very", "short", "and", "silly", "post");
    }
}