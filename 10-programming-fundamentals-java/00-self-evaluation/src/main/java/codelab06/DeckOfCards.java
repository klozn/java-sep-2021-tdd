package codelab06;

import java.util.Arrays;
import java.util.StringJoiner;

public class DeckOfCards {
    public static final int DEFAULT_DECK_SIZE = 52;
    private Card[] cards;

    public DeckOfCards() {
        cards = initializeDefaultDeck();
    }

    public DeckOfCards(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    private static Card[] initializeDefaultDeck() {
        Card[] deck = new Card[DEFAULT_DECK_SIZE];

        for (int i = 0; i < DEFAULT_DECK_SIZE; ) {
            if (i < DEFAULT_DECK_SIZE / 4) {
                for (CardValue value : CardValue.values()) {
                    deck[i] = new Card(Suit.HEARTS, value);
                    i++;
                }
            }
            if (i < DEFAULT_DECK_SIZE / 2) {
                for (CardValue value : CardValue.values()) {
                    deck[i] = new Card(Suit.CLUBS, value);
                    i++;
                }
            }
            if (i < (DEFAULT_DECK_SIZE * 3) / 4) {
                for (CardValue value : CardValue.values()) {
                    deck[i] = new Card(Suit.DIAMONDS, value);
                    i++;
                }
            } else {
                for (CardValue value : CardValue.values()) {
                    deck[i] = new Card(Suit.SPADES, value);
                    i++;
                }
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
