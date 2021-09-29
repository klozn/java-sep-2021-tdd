package codelab04;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message implements Comparable<Message>{
    private final LocalDateTime dateTime;
    private final StormTrooper sender;
    private final String body;

    public Message(LocalDateTime dateTime, StormTrooper sender, String body) {
        this.dateTime = dateTime;
        this.sender = sender;
        this.body = body;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public StormTrooper getSender() {
        return sender;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int compareTo(Message o) {
        return -dateTime.compareTo(o.dateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(dateTime, message.dateTime) && Objects.equals(sender, message.sender) && Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, sender, body);
    }
}
