import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/*

    Generates a CSV file of every possible Cribbage hand with the corresponding score.
    "U:{Card}" Denotes a card that is "face up". minimumCribScore of 4 generates a 400mb CSV file.
    I recommend keeping that number around 14 (~7mb).

 */

public class Main {

    public static final int numOfCards = 5; // number of cards in each hand combination
    public static final int minimumCribScore = 14; // Minimum hand score to write to file. WARNING: Any number below 4 will throw a java heap space exception

    public static void main(String[] args) throws IOException {

        // Initialize deck
        Deck deck = new Deck();

        ArrayList<ArrayList<Card>> combinations = CardCombinations.generate(deck.getCards(), numOfCards);

        // calculate data
        ArrayList<String[]> data = calculateData(combinations);

        // output data to file
        outputToFile(data);


    }

    private static ArrayList<String[]> calculateData(ArrayList<ArrayList<Card>> combinations) throws IOException {
        // Generate all combinations of r cards from the dec


        ArrayList<String[]> data = new ArrayList<>();

        String[] headers = {"Card 1", "Card 2", "Card 3", "Card 4", "Card 5", "Value"};

        data.add(headers);

        // For each combination
        for (ArrayList<Card> combination : combinations) {

            // for each turned over card
            for (int i = 0; i < 5; i++) {
                combination.get(i).turnOver(); // turn over i-th card
                Hand hand = new Hand(new ArrayList<>(combination)); // Create a new Hand object with a copy of the combination

                // calculate crib sum of this
                CribSim cribSim = new CribSim(hand);

                if(cribSim.getTotalHandValue() > minimumCribScore) {

                    ArrayList<Card> currCards = new ArrayList<>(hand.getCards());

                    String[] entry =
                            {currCards.get(0).toString(),
                            currCards.get(1).toString(),
                            currCards.get(2).toString(),
                            currCards.get(3).toString(),
                            currCards.get(4).toString(),
                            "" + cribSim.getTotalHandValue()};


                    data.add(entry);
                }

                // turn back over this card
                combination.get(i).turnOver();
            }
        }

        return data;


    }

    private static void outputToFile(ArrayList<String[]> data) {

        String localDir = System.getProperty("user.dir");

        // write data to output file
        File file = new File(localDir + "/cribData.csv");

        try {
            FileWriter output = new FileWriter(file);

            CSVWriter writer = new CSVWriter(output);

            // write everything in arraylist

            for(String[] entry : data) {
                writer.writeNext(entry);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    };



}

