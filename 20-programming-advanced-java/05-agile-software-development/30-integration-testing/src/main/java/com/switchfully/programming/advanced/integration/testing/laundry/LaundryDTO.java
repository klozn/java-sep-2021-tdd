package com.switchfully.programming.advanced.integration.testing.laundry;

import java.util.Objects;

public class LaundryDTO {

    private String type;
    private String owner;
    private String description;
    private Long minutesUntilCompletion;
    private boolean done;

    public LaundryDTO() {
    }

    public LaundryDTO(String type, String owner, String description, Long minutesUntilCompletion, boolean done) {
        this.type = type;
        this.owner = owner;
        this.description = description;
        this.minutesUntilCompletion = minutesUntilCompletion;
        this.done = done;
    }

    public String getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public Long getMinutesUntilCompletion() {
        return minutesUntilCompletion;
    }

    public boolean isDone(){
        return done;
    }

    @Override
    public String toString() {
        return "LaundryDTO{" +
                "type='" + type + '\'' +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", minutesUntilCompletion=" + minutesUntilCompletion +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaundryDTO that = (LaundryDTO) o;
        return done == that.done && Objects.equals(type, that.type) && Objects.equals(owner, that.owner) && Objects.equals(description, that.description) && Objects.equals(minutesUntilCompletion, that.minutesUntilCompletion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, owner, description, minutesUntilCompletion, done);
    }
}
