package GeneticAlgo;

public class GA {
    public static void main(String[] args) {
        String goal = "welcome";
        Populations pop = new Populations(200, goal.length(), goal);
        boolean match = false;
        int generation = 0;

        while (match != true) {
            pop.generatePopulations();
            pop.generatePool();
            String[] words = pop.getWords();
            pop.selection();
            match = checkForMatch(words, goal);
            generation++;
            String best = bestMatch(words, goal);
            System.out.println("The best match so far: " + best + " for " + goal);
            System.out.println("This is generation: " + generation);
        }
    }

    public static boolean checkForMatch(String[] arr, String goal) {
        boolean match = false;
        for(int i =0; i < arr.length; i++) {
            if (arr[i].equals(goal))
                match = true;
        }
        return match;
    }

    public static String bestMatch(String[] arr, String goal) {
        String s = arr[0];
        int score = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            score = 0;
            for(int j = 0; j < goal.length(); j++) {
                if (arr[i].charAt(j) == goal.charAt(j)) {
                    score++;
                }
            }
            if (score > temp) {
                temp = score;
                s = arr[i];
            }
        }
        return s;
    }

}
