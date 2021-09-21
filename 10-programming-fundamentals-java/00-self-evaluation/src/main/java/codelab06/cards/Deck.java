package codelab06.cards;

import java.util.Arrays;
import java.util.StringJoiner;

public class Deck {
    public static final int DEFAULT_DECK_SIZE = 52;
    private final Card[] cards;

    public Deck() {
        cards = initializeDefaultDeck();
    }

    public Deck(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    private static Card[] initializeDefaultDeck() {
        Card[] deck = new Card[DEFAULT_DECK_SIZE];

        int index = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck[index++] = new Card(suit, rank);
            }
        }
        return deck;
    }

    public boolean containsCard(Card card) {
        return Arrays.asList(cards).contains(card);
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner("\n");
        for (Card card : cards) {
            sj.add(card.toString());
        }
        return sj.toString();
    }
}
