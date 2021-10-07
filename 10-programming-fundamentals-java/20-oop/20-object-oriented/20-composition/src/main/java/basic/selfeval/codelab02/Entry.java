package basic.selfeval.codelab02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Entry {
    private final LocalDate date;
    private final String title;
    private final String body;

    public Entry(String title, String body) {
        date = LocalDate.now();
        this.title = title;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(date, entry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ": " + title + "\n\n" +
                body + '\n';
    }
}
