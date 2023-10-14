
import java.util.Random;
import java.util.Scanner;

public class TASK1 {
    static Scanner sc = new Scanner(System.in);
    static int games=0,lost=0;

    public static void guess(int attempt,int number, int count) {
        if(attempt==0){
            System.out.println("You ran out of attempts!!!");
            lost++;
            return;
        }
        System.out.println("Enter a number to guess: ");
        int guess= sc.nextInt();
        if(guess==number){
            System.out.println("You guessed it right!!");
            System.out.println("It took you "+count+" attempts to guess it right");
        }
        else{
            if(guess>number){
                System.out.println("Your guess is higher than the number!!");
            }
            else{
                System.out.println("Your guess is lower than the number!!");
            }
            guess(attempt-1,number,count+1);
        }

    }


    public static void main(String[] args) {
        String choice;
        int min=0,max=100,attempt;
        System.out.println("Specify the number of attempts allowed per game: ");
        attempt=sc.nextInt();
        do {
            Random rr = new Random();
            int number = rr.nextInt(max - min + 1) + min;
            guess(attempt, number, 0);
            System.out.println("NUMBER TO GUESS WAS: "+number);
            System.out.println("WANT TO PLAY AGAIN? (Y for yes,N for no)");
            choice = sc.next();
            games++;
        } while (choice.compareToIgnoreCase("y") == 0);
        System.out.println("Scoreboard: ");
        System.out.println("Number of games played: "+games);
        System.out.println("Number of games won: "+(games-lost));
    }
}
