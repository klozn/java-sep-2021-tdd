package codelab06;

import codelab06.cards.Card;
import codelab06.cards.Deck;
import codelab06.cards.Rank;
import codelab06.cards.Suit;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Card[] cards = deck.getCards();;

        Deck deck2 = new Deck(cards);

        System.out.println(deck.containsCard(new Card(Suit.SPADES, Rank.ACE)));
        System.out.println(deck2);
        System.out.println(deck.containsCard(null));
    }
}
