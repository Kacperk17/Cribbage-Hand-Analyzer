import java.util.*;

public class CribCalculator {


    // calculates amount of score to give player based on pairs
    public static int calculatePairValues(Hand hand) {


        int sum = 0;
        HashMap<TYPE, Integer> map = hand.getTypeCount();

        for(Map.Entry<TYPE, Integer> entry : map.entrySet()) {
            switch (entry.getValue()) {
                case 2 -> sum += 2;
                case 3 -> sum += 6;
                case 4 -> sum += 12;
            }
        }


        return sum;
    }

    //calculate amount of score to give player based on flush
    public static int calculateFlush(Hand hand) {

        int sum = 0;
        HashMap<SUIT, Integer> map = hand.getSuitCount();

        for(Map.Entry<SUIT, Integer> entry : map.entrySet()) {
            switch (entry.getValue()) {
                case 4 -> sum += 4;
                case 5 -> sum += 5;
            }
        }

        return sum;
    }

    // calculate amount of score to give player based on runs
    public static int calculateRuns(Hand hand) {



        int sum = 0;

        int runningCount = 1;

        ArrayList<Card> cards = hand.getCards();
        HashMap<TYPE, Integer> duplicates = hand.getTypeCount();

        // sort the cards by value
        cards.sort(Comparator.comparing(Card::getValue));

        int multiplier = 0;
        for(int i = 0; i < cards.size() - 1; i++) {

            Card currCard = cards.get(i);
            Card nextCard = cards.get(i + 1);

            int difference = nextCard.getValue() - currCard.getValue();

            if(difference ==  1) {
                runningCount += 1;
            }
            else if(difference == 0) {
                if(duplicates.get(currCard.getType()) ==  2) {
                    multiplier += 2;
                }
                if(duplicates.get(currCard.getType()) == 3) {
                    multiplier = 3;
                }
            }
            else {
                runningCount = 1;
                multiplier = 0;
            }


        }

        if(runningCount >= 3) {
            if(multiplier > 0) {
                sum += runningCount * multiplier;
            }
            else {
                sum += runningCount;
            }
        }

        return sum;
    }

    // calculate amount of '15' sums
    public static int countFifteen(Hand hand) {
        return countFifteenHelper(hand, 15, 0) * 2;
    }

    private static int countFifteenHelper(Hand hand, int target, int start) {

        ArrayList<Card> cards = hand.getCards();

        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }

        int count = 0;
        for (int i = start; i < cards.size(); i++) {
            count += countFifteenHelper(hand, target - cards.get(i).getCribValue(), i + 1);
        }

        return count;
    }

    public static int calculateKnob(Hand hand) {
        boolean knob = false;

        SUIT suitOfTurnedOverCard = null;


        try {
            suitOfTurnedOverCard = hand.getTurnedOverCard().getSuit();
        } catch (Exception ex) {
            System.out.println(hand);
        }



        // go through hand and look for JACK
        for(Card card : hand.getCards()) {

            // if card is not the turned over card
            if (!card.isTurnedOver()) {

                // if card is a jack
                if(card.getType().equals(TYPE.JACK)) {

                    // if this card's suit is the same as turned over card
                    if(card.getSuit().equals(suitOfTurnedOverCard)) {
                        knob = true;
                    }

                }


            }

        }

        if(knob) {
            return 1;
        }
        else {
            return 0;
        }

    }


}
