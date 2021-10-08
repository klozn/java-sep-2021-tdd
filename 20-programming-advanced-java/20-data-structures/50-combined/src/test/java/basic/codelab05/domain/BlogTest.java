package basic.codelab05.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {
    @Test
    void getBlogPostsPerAuthor_returnsExpectedResult() {
        var author = new Author("John");
        var differentAuthor = new Author("Not John");
        var postsByAuthor = new ArrayList<>(generatePostsFor(author));
        var allPosts = new ArrayList<>(generatePostsFor(differentAuthor));
        allPosts.addAll(postsByAuthor);
        var blog = new Blog(allPosts);

        List<BlogPost> result = blog.getBlogPostsPerAuthor(author);

        assertTrue(result.containsAll(postsByAuthor));
    }

    @Test
    void suggestABlogPost_returnsLastPostAdded() {
        var posts = generatePostsFor(new Author("John"));
        var lastPost = posts.get(posts.size() - 1);
        var blog = new Blog(posts);

        BlogPost suggested = blog.suggestABlogPost();

        assertEquals(lastPost, suggested);
    }

    private static List<BlogPost> generatePostsFor(Author author) {
        return new ArrayList<>(List.of(new BlogPost(author, "title", "test", Category.FUNNY, LocalDate.of(2020,4,21)),
                new BlogPost(author, "title", "test", Category.DIY, LocalDate.of(2020,5,20)),
                new BlogPost(author, "title", "test", Category.BEAUTY, LocalDate.of(2020, 6, 21)),
                new BlogPost(author, "title", "test", Category.MOVIES, LocalDate.of(2020,7,21)),
                new BlogPost(author, "title", "test", Category.SERIES, LocalDate.of(2020,8,20)),
                new BlogPost(author, "title", "test", Category.GAMING, LocalDate.of(2020, 9, 20))));
    }
}