package codelab04;

import java.time.LocalDateTime;

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
}
