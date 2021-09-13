package basic.codelab02;

import java.util.Arrays;

public class Agenda {
    private String name;
    private Person owner;
    private Entry[] entries;

    public Agenda(String name, Person owner) {
        this.name = name;
        this.owner = owner;
        entries = new Entry[25];
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public Entry[] getEntries() {
        return entries;
    }

    public boolean addEntry(Entry entry) {
        boolean firstEntryOfTheDay = true;
        for (Entry e: entries) {
            if (e.equals(entry)) {
                firstEntryOfTheDay = false;
                break;
            }
        }
        if (firstEntryOfTheDay) {
            for (Entry e: entries) {
                if (e == null) {
                    e = entry;
                    break;
                }
            }
        }
        return firstEntryOfTheDay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Agenda{");
        sb.append("name='").append(name).append('\'');
        sb.append(", owner=").append(owner);
        sb.append(", entries=").append(Arrays.toString(entries));
        sb.append('}');
        return sb.toString();
    }
}
