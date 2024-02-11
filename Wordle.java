import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Wordle {
     public static boolean play = true;
     static String GREEN = "\033[0;32m";   
     static String YELLOW = "\033[0;33m";
     static String RESET = "\033[0m";
    
    public static void main(String[] args) {
        String[] words = new String[]{"ABOUT", "AWARE", "BLACK", "COOKS", "CRAZY"};

        String word = getWord(words);
        String guess;
        int i = 0;
        
        
        while(i < 6 || play == false) {
            System.out.println("Please enter a 5-letter guess\n");
            guess = getUserGuess();
            playGame(separateWord(guess), separateWord(word));
            i++;
        }
        
        System.out.println(GREEN + "THANKS FOR PLAYING!" + RESET);
    }
    
    public static String getWord(String[] words) {
        //get a random word from a list of 5-letter worsd
        Random rand = new Random();
        int randint = rand.nextInt(words.length);
        return words[randint];
    }

    public static String getUserGuess() {
        //get user input as a word
        Scanner scanner = new Scanner(System.in);
        String guess = scanner.nextLine().toUpperCase();
        if (guess.length() != 5) {
            throw new IllegalArgumentException("Word must be 5 letters");
        }
        else {
            return guess;
        }
    }

    public static ArrayList<String> separateWord(String word) {
        //break apart each word into characters and store into arraylist
        ArrayList<String> separatedWord = new ArrayList<String>();
        int j = 1;
        for (int i = 0; i < word.length(); i++) {
            separatedWord.add(word.substring(i, j));
            j++;
        }
        return separatedWord;

    }

    public static void playGame(ArrayList<String> guess, ArrayList<String> word) {
        if(word.equals(guess)) {
            System.out.println(GREEN + "You guessed the word! The Word was " + word.toString() + RESET);
            play = false;
            
        }
        
        for (int i = 0; i < word.size(); i++) {
            if (guess.get(i).equals(word.get(i))) {
                guess.set(i, GREEN + guess.get(i) + RESET);
                
            }
            else if (word.contains(guess.get(i))) {
                guess.set(i, YELLOW + guess.get(i) + RESET);
                
                
            }
            
        }
        System.out.println(guess.toString() +"\n");
        
    }
}