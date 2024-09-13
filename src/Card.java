
public class Card {

    // instance variables
    private final int value;
    private final int cribValue;
    private final SUIT suit;
    private final TYPE type;
    private boolean turnedOver = false;

    // constructor
    public Card(TYPE type, SUIT suit) {
        this.type = type;
        this.suit = suit;
        this.value = type.getValue();
        this.cribValue = type.getCribValue();
    }

    // getter variables
    public int getValue() {return value;}
    public SUIT getSuit() {return suit;}
    public TYPE getType() {return type;}
    public int getCribValue() {return cribValue;}
    public boolean isTurnedOver() {return turnedOver;}

    // turn over card
    public void turnOver() {
        turnedOver = !turnedOver;
    }

    // toString override
    @Override
    public String toString() {

        if(isTurnedOver()) {
            return "U:[" + type + ", " + suit + "]";
        }
        else {
            return "[" + type + ", " + suit + "]";
        }

    }

}