package codelab06;

public class Main {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        Card[] cards = deck.getCards();;

        DeckOfCards deck2 = new DeckOfCards(cards);

        System.out.println(deck.containsCard(new Card(Suit.SPADES, CardValue.ACE)));
        System.out.println(deck2);
        System.out.println(deck.containsCard(null));
    }
}
