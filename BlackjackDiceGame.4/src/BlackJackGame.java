import java.util.Random;
import java.util.Scanner;

public class BlackJackGame {
    public static int rulTerning(){
        Random rand = new Random();
        return rand.nextInt(5) + 1;}
    public static String blackJackPullCard(){
        Random rand = new Random();
        return switch ((rand.nextInt(13) + 1)){
            case 1 -> "Ace";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 ->  "Nine";
            case 10 ->  "Ten";
            case 11 ->  "Jack";
            case 12 ->  "Queen";
            case 13 ->  "King";
            default -> "";};}
    public static int blackJackConvert(String a){
        return switch (a){
            case "Ace" -> 1;
            case "Two" -> 2;
            case "Three" -> 3;
            case "Four" -> 4;
            case "Five" -> 5;
            case "Six" -> 6;
            case "Seven" -> 7;
            case "Eight" -> 8;
            case "Nine" -> 9;
            case "Ten" -> 10;
            case "Jack" -> 10;
            case "Queen" -> 10;
            case "King" -> 10;
            default -> 0;
        };
    }
public static int playerCardHit(int a) {
       int playerSum = a;
       String newPlayerCard = blackJackPullCard();
       int newPlayerCardInt = blackJackConvert(newPlayerCard);
    System.out.println("You hit a: " + newPlayerCard);
    playerSum = playerSum + newPlayerCardInt;
    System.out.println("Your cardsum is now: " + playerSum);
       return playerSum;



}

public static int botcardHit(int a){

return 1;
}

public static void main(String[] args) {
    System.out.println("welcome to Blackjack!");
    boolean spilIGang = true;
    while (spilIGang){
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to draw your first two cards");
        if (input.nextInt()==1){
            String playerFirstCard = blackJackPullCard();
            String playerSecondCard=blackJackPullCard();
            String botFirstCard = blackJackPullCard();
            int playerSum = (blackJackConvert(playerFirstCard) + blackJackConvert(playerSecondCard));
            int botSum = (blackJackConvert(botFirstCard));
            System.out.println("Your first hit is a/an: " + playerFirstCard);
            System.out.println("Your second hit is a/an: " + playerSecondCard);
            System.out.println("Your cards total value is: " + playerSum);
            System.out.println("The dealer flipped a " + botFirstCard);
            if (input.nextInt()==1){
                while ()
            }

        }else {
            System.out.println("Wrong input");
            continue;

        }


    }

}

}
