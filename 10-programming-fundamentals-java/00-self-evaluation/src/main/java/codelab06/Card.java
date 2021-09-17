package codelab06;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final CardValue value;

    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public String toString() {
        return String.format("[%s of %s]", value.toString().toLowerCase(), suit.toString().toLowerCase());
    }
}
