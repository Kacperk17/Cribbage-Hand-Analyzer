import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    // instance variables
    private final ArrayList<Card> cards = new ArrayList<>();

    // constructor
    public Deck() {

        // declare list of all suits and all types
        SUIT[] suits = {SUIT.HEARTS, SUIT.DIAMONDS, SUIT.CLUBS, SUIT.SPADES};

        TYPE[] types = {TYPE.ACE, TYPE.TWO, TYPE.THREE, TYPE.FOUR, TYPE.FIVE, TYPE.SIX, TYPE.SEVEN, TYPE.EIGHT, TYPE.NINE, TYPE.TEN, TYPE.JACK, TYPE.QUEEN, TYPE.KING};

        // iterate over each suit and add 1 of each type of card into cards
        for(SUIT suit : suits) {

            for(TYPE type : types) {
                cards.add(new Card(type, suit));
            }

        }
    }

    // getter variable
    public ArrayList<Card> getCards() {return cards;}

    // method to remove card from deck
    public void removeCard(Card card) {
        cards.remove(card);
    }

    // shuffle deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // toString override
    @Override
    public String toString() {
        return cards.toString();
    }

}
