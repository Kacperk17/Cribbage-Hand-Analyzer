

public class CribSim {

    // hand
    private Hand hand;
    private int totalHandValue;

    // constructor
    public CribSim(Hand hand) {

        this.hand = hand;

        this.totalHandValue = getFifteenTotal() + getPairValues() + getRunningTotal() + getKnob();


    }

    // getter methods
    public Hand getHand() {return hand;}
    public int getTotalHandValue() {return totalHandValue;}

    public int getPairValues() {
        return CribCalculator.calculatePairValues(hand);
    }
    public int getFlush() {
        return CribCalculator.calculateFlush(hand);
    }
    public int getRunningTotal() {
        return CribCalculator.calculateRuns(hand);
    }

    public int getFifteenTotal() {
        return CribCalculator.countFifteen(hand);
    }
    public int getKnob() {return CribCalculator.calculateKnob(hand);}



    // toString override
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\nValue: ").append(totalHandValue);
        sb.append("\nHand: ").append(hand);

        return sb.toString();

    }

}
