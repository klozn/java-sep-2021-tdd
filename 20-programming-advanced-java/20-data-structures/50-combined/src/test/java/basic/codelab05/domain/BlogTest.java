package basic.codelab05.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogTest {
    @Test
    void getBlogPostsPerAuthor_returnsExpectedResult() {
        Author author = new Author("John");
        Author differentAuthor = new Author("Not John");
        List<BlogPost> postsByAuthor = new ArrayList<>(generatePostsFor(author));
        List<BlogPost> allPosts = new ArrayList<>(generatePostsFor(differentAuthor));
        allPosts.addAll(postsByAuthor);
        Blog blog = new Blog(allPosts);

        List<BlogPost> result = blog.getBlogPostsPerAuthor(author);

        assertTrue(result.containsAll(postsByAuthor));
        assertEquals(result.size(), postsByAuthor.size());
    }

    @Test
    void suggestABlogPost_returnsLastPostAdded() {
        List<BlogPost> posts = generatePostsFor(new Author("John"));
        BlogPost lastPost = posts.get(posts.size() - 1);
        Blog blog = new Blog(posts);

        BlogPost suggested = blog.suggestABlogPost();

        assertEquals(lastPost, suggested);
    }

    private static List<BlogPost> generatePostsFor(Author author) {
        return new ArrayList<>(List.of(new BlogPost(author, "title", "test", Category.FUNNY),
                new BlogPost(author, "title", "test", Category.DIY),
                new BlogPost(author, "title", "test", Category.BEAUTY),
                new BlogPost(author, "title", "test", Category.MOVIES),
                new BlogPost(author, "title", "test", Category.SERIES),
                new BlogPost(author, "title", "test", Category.GAMING)));

    }
}