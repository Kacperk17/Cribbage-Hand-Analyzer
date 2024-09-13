public enum TYPE {
    ACE (1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    // constructor and instance variables
    private final int value;
    private int cribValue;

    TYPE(int value) {
        this.value = value;

        if(value > 10) {
            this.cribValue = 10;
        }
        else {
            this.cribValue = value;
        }
    }

    public int getValue() {return value;}
    public int getCribValue() {return cribValue;}
}
