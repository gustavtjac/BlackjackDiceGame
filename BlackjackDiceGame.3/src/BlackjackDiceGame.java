import java.util.Random;
import java.util.Scanner;

public class BlackjackDiceGame {

    public static int rulTerning(){
        Random rand = new Random();
        return rand.nextInt(5) + 1;
    }

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
            default -> "";
        };

    }
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



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
boolean tænd = true;
while (tænd){
    System.out.println("Welcome to Blackjack!!!");
    System.out.println("Press 1 to play!");
    if (sc.nextInt() == 1){
        String spillerKort1 = blackJackPullCard();
        String spillerKort2 = blackJackPullCard();
        String dealerKort1 = blackJackPullCard();
        System.out.println("Here are your first two cards: ");
        System.out.println("First card: " + spillerKort1);
        System.out.println("Second card: " + spillerKort2);
        System.out.println("The combined value of your cards are " + (blackJackConvert(spillerKort1) + blackJackConvert(spillerKort2)));
        System.out.println("The Dealer flipped a: " + dealerKort1);
        System.out.println("Do you want to hit or stand?");
        System.out.println("Hit = 1 Stand = 2");
        if (sc.nextInt() == 1){
            boolean hit = true;
            int spillersum = blackJackConvert(spillerKort1) + blackJackConvert(spillerKort2);
            while (hit){
                String newCard = blackJackPullCard();
                int newCardInt = blackJackConvert(newCard);
                spillersum = spillersum + newCardInt;
                if (spillersum >21){
                    hit = false;
                    System.out.println("You hit a/an " + newCard + " and landed on: " +spillersum);
                    System.out.println("YOUU BUSTED!!!!!");
                }else {
                    System.out.println("You pulled a/an " + newCard + " and landed on: " + spillersum);
                    System.out.println("Do you want to hit or stand?");
                    System.out.println("Hit = 1 Stand = 2");
                    if (sc.nextInt() == 1){

                    }else {
                        hit = false;
                        int botSum = blackJackConvert(dealerKort1);
                        while (botSum < 17){
                            String newCardBot = blackJackPullCard();
                            int newCardIntBot = blackJackConvert(newCard);
                            botSum = botSum + newCardIntBot;
                            System.out.println("The dealer flipped a/an: " + newCardBot + " and their card sum is: " + botSum);
                    } if (botSum > 21){
                            System.out.println("The dealer BUSTED with a total value of " + botSum);
                            System.out.println("You WON");
                        }
                        else if (botSum > spillersum){
                            System.out.println("The dealer landed on: " + botSum);
                            System.out.println("You landed on: " + spillersum);
                            System.out.println("so therefore youu lost.......");

                        } else if(spillersum > botSum){
                            System.out.println("The dealer landed on: " + botSum);
                            System.out.println("You landed on: " + spillersum);
                            System.out.println("so therefore you WONNNN!!!!!!!!!!1!!!!");

                        }else {
                            System.out.println("The dealer landed on: " + botSum);
                            System.out.println("You landed on: " + spillersum);
                            System.out.println("You tied and it's a push");

                        }
                }
            }
        }



    }else if (sc.nextInt() == 2){
            boolean bot = true;
            int botSum = blackJackConvert(dealerKort1);
            int spillersum = blackJackConvert(spillerKort1) + blackJackConvert(spillerKort2);
                while (botSum < 17){
                    String newCard = blackJackPullCard();
                    int newCardInt = blackJackConvert(newCard);
                    botSum = botSum + newCardInt;
                    System.out.println("The dealer flipped a/an: " + newCard + " and their card sum is: " + botSum);
                }
            }


            }

        }

}



    }

