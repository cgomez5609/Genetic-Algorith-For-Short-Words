package GeneticAlgo;

import java.util.ArrayList;
import java.util.Random;

public class Populations {
    private int wordLength;
    private String[] words;
    private int[] fit;
    private int length;
    private String goal;
    private ArrayList<String> pool = new ArrayList<>();

    public Populations(int length, int wordLength, String goal) {
        this.wordLength = wordLength;
        this.length = length;
        this.goal = goal;
        this.words = new String[this.length];
        this.fit = new int[this.length];
    }

    public void generatePopulations() {
        for (int i = 0; i < this.words.length; i++) {
            DNA temp = new DNA(this.wordLength, this.goal);
            this.words[i] = temp.getWord();
            this.fit[i] = temp.getFitness();
        }
    }

    public void generatePool() {
        this.pool = new ArrayList<>();
        for (int i = 0; i < this.words.length; i++) {
            for(int j = 0; j < this.fit[i]; j++) {
                this.pool.add(this.words[i]);
            }
        }
    }

    public void selection() {
        int length = this.pool.size();
        Random rand = new Random();
        for(int i = 0; i < this.words.length; i++) {
            int first = rand.nextInt(length-1);
            int second = rand.nextInt(length-1);
            if (first == second)
                second = rand.nextInt(length-1);
            String a = this.pool.get(first);
            String b = this.pool.get(second);
            String newWord = crossover(a,b);
            this.words[i] = newWord;
            this.words[i] = this.mutation(this.words[i]);
        }
    }

    public String crossover(String a, String b) {
        String s = "";
        int aLength = a.length() / 2;
        s += a.substring(0, aLength);
        s += b.substring(aLength);
        return s;
    }

    public String mutation(String s) {
        Random rand = new Random();
        String newWord = "";
        for (int i = 0; i < s.length(); i++) {
            int n = rand.nextInt(100);
            if (n < 35) {
                char c = DNA.generateLetter();
                newWord += c;
            } else {
                newWord += s.charAt(i);
            }
        }
        return newWord;
    }

    public String[] getWords() {
        return this.words;
    }

    public int[] getFit(){
        return this.fit;
    }

    public ArrayList<String> getPool() {
        return this.pool;
    }

}
