package GeneticAlgo;

import java.util.Random;

public class DNA {
    private int genes;
    private String word;
    private double fitness;
    private String goal;

    public DNA(int genes, String goal) {
        this.genes = genes;
        this.goal = goal;
        this.word = generateWord(this.genes);
        this.fitness = checkFitness();
    }

    public String getWord() {
        return this.word;
    }

    public int getFitness() {
        double b = this.fitness * 10;
        return (int)b;
    }

    public String generateWord(int length) {
        Random rand = new Random();
        String word = "";
        for(int i = 0; i < length; i++) {
            int n = rand.nextInt(26);
            char letter = (char)('a' + n);
            word += letter;
        }
        return word;
    }

    public static char generateLetter() {
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }

    public double checkFitness() {
        int score = 0;
        for (int i = 0; i < this.word.length(); i++) {
            if (this.goal.charAt(i) == this.word.charAt(i))
                score++;
        }

        double value = (double)score / goal.length(); // based off percentage

        return value;
    }
}
