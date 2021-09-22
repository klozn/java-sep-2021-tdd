package com.switchfully.programming.advanced.integration.testing.laundry;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "LAUNDRY")
public class Laundry {

    public static final int TIME_TO_COMLETE = 30;
    @Column
    @Enumerated(EnumType.STRING)
    private LaundryType laundryType;
    @Column
    private String owner;
    @Column
    private String description;
    @Column
    private LocalDateTime creationDate;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laundry_seq")
    @SequenceGenerator(name = "laundry_seq", sequenceName = "laundry_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private Laundry() {

    }

    public Laundry(LaundryType laundryType, String owner, String description, LocalDateTime creationDate) {
        this.laundryType = laundryType;
        this.owner = owner;
        this.description = description;
        this.creationDate = creationDate;
    }

    public LaundryType getType() {
        return laundryType;
    }

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public Long getTimeUntilCompletion(LocalDateTime now) {
        return Math.max(0, TIME_TO_COMLETE - Duration.between(creationDate, now).toMinutes());
    }

    public boolean isDone(LocalDateTime now) {
        return getTimeUntilCompletion(now) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laundry laundry = (Laundry) o;
        return laundryType == laundry.laundryType && Objects.equals(getOwner(), laundry.getOwner()) && Objects.equals(getDescription(), laundry.getDescription()) && Objects.equals(creationDate, laundry.creationDate) && Objects.equals(id, laundry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laundryType, getOwner(), getDescription(), creationDate, id);
    }

    @Override
    public String toString() {
        return "Laundry{" +
                "laundryType=" + laundryType +
                ", owner='" + owner + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", id=" + id +
                '}';
    }
}
