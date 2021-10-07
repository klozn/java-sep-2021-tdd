package basic.selfeval.codelab02;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final String name;
    private final Person owner;
    private final List<Entry> entries;

    public Agenda(String name, Person owner) {
        this.name = name;
        this.owner = owner;
        entries = new ArrayList<>();
    }

    public Person getOwner() {
        return owner;
    }

    public boolean addEntry(Entry entry) {
        if (entries.size() == 25) {
            return false;
        }
        if (entries.contains(entry)) {
            return false;
        }
        return entries.add(entry);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(name);
        sb.append("\nBy: ").append(owner).append("\n");
        entries.forEach(entry -> sb.append(entry).append("\n"));
        return sb.toString();
    }
}
