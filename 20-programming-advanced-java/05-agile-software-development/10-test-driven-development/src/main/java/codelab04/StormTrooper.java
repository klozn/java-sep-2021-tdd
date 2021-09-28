package codelab04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StormTrooper {
    private final String username;
    private final Set<StormTrooper> friends = new HashSet<>();
    private final TreeSet<Message> messages = new TreeSet<>();

    public StormTrooper(String username) {
        this.username = username;
    }

    public Set<StormTrooper> getFriends() {
        return friends;
    }

    public boolean addFriend(StormTrooper friend) {
        return friends.add(friend) && friend.friends.add(this);
    }

    private boolean addMessage(Message message) {
        return messages.add(message);
    }

    public TreeSet<Message> getMessages() {
        return messages;
    }

    public TreeSet<Message> getMessagesFrom(StormTrooper friend) {
        if (friends.contains(friend)) {
            return messages.stream()
                    .filter(m -> m.getSender().equals(friend))
                    .collect(Collectors.toCollection(TreeSet<Message>::new));
        }
        return null;
    }

    public boolean sendMessage(String body, StormTrooper friend) {
        return sendMessage(new Message(LocalDateTime.now(), this, body), friend);
    }

    public boolean sendMessage(Message message, StormTrooper friend) {
        if (friends.contains(friend)) {
            return friend.addMessage(message);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StormTrooper that = (StormTrooper) o;
        return username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

}
