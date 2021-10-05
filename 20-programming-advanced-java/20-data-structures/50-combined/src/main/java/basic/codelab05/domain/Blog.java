package basic.codelab05.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Blog {
    private final List<BlogPost> posts;

    public Blog() {
        posts = new ArrayList<>();
    }

    public Blog(List<BlogPost> posts) {
        this.posts = posts;
    }

    List<BlogPost> getBlogPostsPerAuthor(Author author) {
        return posts.stream()
                .filter(post -> post.getAuthor().equals(author))
                .collect(Collectors.toList());
        /*List<BlogPost> result = new ArrayList<>();
        for (BlogPost post : posts) {
            if (post.getAuthor() == author) {
                result.add(post);
            }
        }
        return result;*/
    }

    BlogPost suggestABlogPost() {
        Collections.sort(posts);
        return posts.get(0);
    }
}
