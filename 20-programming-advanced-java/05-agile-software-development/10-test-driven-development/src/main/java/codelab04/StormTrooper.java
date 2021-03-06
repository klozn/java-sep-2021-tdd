package codelab04;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StormTrooper {
    private final String username;
    private final Set<StormTrooper> friends = new HashSet<>();
    private final List<Message> messages = new ArrayList<>();
    private Rank rank;

    public StormTrooper(String username) {
        this.username = username;
        rank = Rank.SOLDIER;
    }

    public Set<StormTrooper> getFriends() {
        return friends;
    }

    public boolean addFriend(StormTrooper friend) {
        if (!possibleFriendship(friend)) {
            throw  new IllegalArgumentException("Not a possible friend");
        }
        if (!friends.contains(friend)) {
            if (friends.add(friend)) {
                return friend.getFriends().add(this);
            }
        }
        return false;
    }

    private boolean possibleFriendship(StormTrooper possibleFriend) {
        return switch (rank) {
            default -> true;
            case SOLDIER -> possibleFriend.rank != Rank.GENERAL;
            case GENERAL -> possibleFriend.rank != Rank.SOLDIER;
        };
    }

    private void receiveMessage(Message message) {
        messages.add(message);
        Collections.sort(messages);
    }

    public List<Message> getMessages() {
        Collections.sort(messages);
        return messages;
    }

    public List<Message> getMessagesFrom(StormTrooper friend) {
        if (friends.contains(friend)) {
            return messages.stream()
                    .filter(m -> m.getSender().equals(friend))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public boolean sendMessage(String body, StormTrooper friend) {
        return sendMessage(new Message(LocalDateTime.now(), this, body), friend);
    }

    public boolean sendMessage(Message message, StormTrooper friend) {
        if (friends.contains(friend)) {
            friend.receiveMessage(message);
            return true;
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

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
