import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyProgram
{
    public static void main(String[] args) throws InterruptedException
    {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        List<List<String>> wordPairs = Arrays.asList(
            Arrays.asList("Banana", "Monkey"),
            Arrays.asList("Coffee", "Tea"),
            Arrays.asList("Laptop", "Desktop"),
            Arrays.asList("McDonalds", "Burger King"),
            Arrays.asList("Soccer", "Football"),
            Arrays.asList("Disney", "Illumination"),
            Arrays.asList("Minions", "Monsters Inc."),
            Arrays.asList("Potato", "French Fries"),
            Arrays.asList("Airplane", "Car"),
            Arrays.asList("Star Wars", "Star Trek")
            );
        
        System.out.print("# of players: ");
        int numPlayers = scanner.nextInt();
        
        System.out.print("# of rounds: ");
        int numRounds = scanner.nextInt();
        
        int chosenWordPair = rand.nextInt(wordPairs.size());
        String majorityWord = wordPairs.get(chosenWordPair).get(0);
        String imposterWord = wordPairs.get(chosenWordPair).get(1);
        
        int imposter = rand.nextInt(numPlayers) + 1;
        
        System.out.println("Pass the computer to player 1");
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        
        for (int round = 0; round <= numRounds; round++) {
            if (round == 0) {
                for (int currentPlayer = 1; currentPlayer <= numPlayers; currentPlayer ++) {
                    if (currentPlayer == imposter) {
                        System.out.println("Player " + currentPlayer + ", your word is: " + imposterWord);
                    }
                    else {
                        System.out.println("Player " + currentPlayer + ", your word is: " + majorityWord);
                    }
                    if (currentPlayer == numPlayers) {
                        System.out.println("All words given out. Pass the computer back to player 1 to start the rounds. You have 10 seconds.");
                    } else { 
                        System.out.println("Pass the computer to the next user, (Player " + (currentPlayer + 1) + "). You have 10 seconds.");
                    }
                    TimeUnit.SECONDS.sleep(10);
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                }
            }
            else {
                System.out.println("=== THIS IS ROUND " + round + " ===");
                System.out.println();
                for (int currentPlayer = 1; currentPlayer <= numPlayers; currentPlayer ++) {
                    System.out.println("Pass the computer to player " + currentPlayer);
                    TimeUnit.SECONDS.sleep(5);
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    System.out.println("Player " + currentPlayer + ", give a one-word clue about your word. You have 15 seconds.");
                    TimeUnit.SECONDS.sleep(15);
                    System.out.println();
                    if (currentPlayer == numPlayers) {
                        System.out.println("Round " + round + " is over.");
                        TimeUnit.SECONDS.sleep(3);
                    } else {
                        System.out.println("Pass the computer to the next user. You have 5 seconds.");
                    TimeUnit.SECONDS.sleep(5);   
                    }
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
