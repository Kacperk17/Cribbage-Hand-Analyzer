import java.util.ArrayList;
import java.util.HashMap;

public class Hand {

    // instance variables
    private final ArrayList<Card> cards;
    private int value = 0;

    // constructor
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Hand() {
        this.cards = new ArrayList<>();
    }


    // getter variable
    public ArrayList<Card> getCards() {
        return cards;
    }
    public int getValue() {return value;}

    // add card to hand
    public void giveCard(Card card) {
        cards.add(card);
        value += card.getValue();
    }

    // take away card from hand
    public void removeCard(Card card) {

        if(cards.contains(card)) {
            cards.remove(card);
            value -= card.getValue();
        }
        else {
            throw new IllegalArgumentException("Hand does not contaion card");
        }
    }

    // method to count amount of each TYPE of card in hand
    public HashMap<TYPE, Integer> getTypeCount() {

        HashMap<TYPE, Integer> counts = new HashMap<>();

        // for each type int hand, add it to the hashmap count

        for(Card card : cards) {
            if(counts.containsKey(card.getType())) {
                counts.put(card.getType(), counts.get(card.getType()) + 1);
            }
            else {
                counts.put(card.getType(), 1);
            }

        }


        return counts;
    }

    // method to count amount of each SUIT of card in hand
    public HashMap<SUIT, Integer> getSuitCount() {

        HashMap<SUIT, Integer> counts = new HashMap<>();

        // for each type int hand, add it to the hashmap count

        for(Card card : cards) {
            if(counts.containsKey(card.getSuit())) {
                counts.put(card.getSuit(), counts.get(card.getSuit()) + 1);
            }
            else {
                counts.put(card.getSuit(), 1);
            }

        }


        return counts;
    }

    // Method that returns turned over card
    public Card getTurnedOverCard() {
        for(Card card : cards) {
            if(card.isTurnedOver()) {
                return card;
            }
        }

        return null;
    }

    // method that returns if the hand has a turned over card
    public boolean hasTurnedOverCard() {
        if(getTurnedOverCard().equals(null)) {
            return false;
        }
        else {
            return true;
        }
    }

    // toString override
    @Override
    public String toString() {
        return cards.toString();
    }
}
