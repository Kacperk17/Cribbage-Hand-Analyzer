import java.util.ArrayList;


public class CardCombinations {

    public static ArrayList<ArrayList<Card>> generate(ArrayList<Card> cards, int numOfCardsPerCombination) {
        return generateCombinations(cards, numOfCardsPerCombination);
    }

    private static ArrayList<ArrayList<Card>> generateCombinations(ArrayList<Card> cards, int r) {
        ArrayList<ArrayList<Card>> combinations = new ArrayList<>();
        generateCombinationsHelper(cards, r, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(ArrayList<Card> cards, int r, int start, ArrayList<Card> current, ArrayList<ArrayList<Card>> combinations) {
        if (current.size() == r) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < cards.size(); i++) {
            current.add(cards.get(i));
            generateCombinationsHelper(cards, r, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }

}
