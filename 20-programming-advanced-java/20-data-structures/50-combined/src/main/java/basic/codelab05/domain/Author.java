package basic.codelab05.domain;

import java.util.Objects;
import java.util.UUID;

public class Author {
    private final String name;
    private final UUID id;

    public Author(String name) {
        this.name = name;
        id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
