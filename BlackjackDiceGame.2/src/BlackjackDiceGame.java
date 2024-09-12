import java.util.Random;
import java.util.Scanner;

public class BlackjackDiceGame {

    public static int rulTerning(){
        Random rand = new Random();
           return rand.nextInt(5) + 1;
    }

    public static String blackJackPullCard(){
        String card;
        Random rand = new Random();
        return switch (rand.nextInt(12) + 1){
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velkommen til Blackjack Dice Game!!");
        System.out.println("Vil du spille Blackjack eller terning? 1/2");
        if (scanner.nextInt() == 1) {
            System.out.println("Velkommen til Blackjack!");
            System.out.println("Start spillet og træk dine kort ved at taste 1.");
            if (scanner.nextInt() == 1) {
                String spillerKortEt = blackJackPullCard();
                String computerKortEt = blackJackPullCard();
                String spillerKortTo = blackJackPullCard();
                String spillerKortTre = blackJackPullCard();
                System.out.println("Dit første kort er : " + spillerKortEt);
                System.out.println("Det 2. kort du træk var: " + spillerKortTo);
                System.out.println("Dine korts samlede værdi er = " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo)));
                System.out.println("Dealeren trækker kortet: " + computerKortEt);
                System.out.println("Vil du hit eller stand 1/2");
                if (scanner.nextInt() == 1) {
                    if (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) <=21) {
                        System.out.println("Det 3. kort du træk var: " + spillerKortTre);
                        System.out.println("Dine korts samlede værdi er = " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre)));
                        System.out.println("Vil du hit eller stand 1/2");
                        if (scanner.nextInt() == 1) {
                            String spillerKortFire = blackJackPullCard();
                            if(blackJackConvert(spillerKortEt) + (blackJackConvert(spillerKortTo)) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) <= 21){
                                System.out.println("Det 4. kort du træk var: " + spillerKortFire);
                                System.out.println("Dine korts samlede værdi er = " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire)));
                                System.out.println("Vil du hit eller stand 1/2");
                                if (scanner.nextInt() == 1) {
                                    String spillerKortFem = blackJackPullCard();
                                    if (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFem) <= 21){
                                        System.out.println("Det 5. kort du træk var: " + spillerKortFem);
                                        System.out.println("Dine korts samlede værdi er = " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) + blackJackConvert(spillerKortFem)));
                                        System.out.println("Vil du hit eller stand 1/2");
                                        if (scanner.nextInt() == 1) {
                                            String spillerKortSeks = blackJackPullCard();
                                            if (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFem + blackJackConvert(spillerKortSeks)) <= 21){
                                                System.out.println("Det 6. kort du træk var: " + spillerKortSeks);
                                                System.out.println("Dine korts samlede værdi er = " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) + blackJackConvert(spillerKortFem) + blackJackConvert(spillerKortSeks)));
                                                System.out.println("Vil du hit eller stand 1/2");

                                            }



                                        }else {
                                            System.out.println("Du Stander");
                                            int dealerSum = blackJackConvert(computerKortEt);
                                            while(dealerSum <17) {

                                                dealerSum = dealerSum + blackJackConvert(blackJackPullCard());
                                                System.out.println("Dealeren trækker et kort og er nu på " + dealerSum);
                                            }
                                            if (dealerSum>21){
                                                System.out.println("Dealer bustede og du VINDER!!!!!!!!!!!!!!!1");
                                            } else if (dealerSum > (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) + blackJackConvert(spillerKortFem))) {
                                                System.out.println("Dealer ender på " + dealerSum + " Du endte på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) + blackJackConvert(spillerKortFem)) + " Derfor taber du......");
                                            }else {
                                                System.out.println("Du ender på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) + blackJackConvert(spillerKortFem)) + " Dealer ender på " + dealerSum +" Derfor vinder du!!!!?!?!??!");
                                            }
                                        }


                                    }else {
                                        System.out.println("Du trak: " + spillerKortFem + " og der dermed gået over 21");
                                        System.out.println("dine korts samlede værdi: " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire) + blackJackConvert(spillerKortFem)));
                                        System.out.println("BUUUUUST");
                                    }
                                }else {
                                    System.out.println("Du Stander");
                                    int dealerSum = blackJackConvert(computerKortEt);
                                    while(dealerSum <17) {

                                        dealerSum = dealerSum + blackJackConvert(blackJackPullCard());
                                        System.out.println("Dealeren trækker et kort og er nu på " + dealerSum);
                                    }
                                    if (dealerSum>21){
                                        System.out.println("Dealer bustede og du VINDER!!!!!!!!!!!!!!!1");
                                    } else if (dealerSum > (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire))) {
                                        System.out.println("Dealer ender på " + dealerSum + " Du endte på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire)) + " Derfor taber du......");
                                    }else {
                                        System.out.println("Du ender på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire)) + " Dealer ender på " + dealerSum +" Derfor vinder du!!!!?!?!??!");
                                    }
                                }

                            }else {
                                System.out.println("Du trak: " + spillerKortFire + " og der dermed gået over 21");
                                System.out.println("dine korts samlede værdi: " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre) + blackJackConvert(spillerKortFire)));
                                System.out.println("BUUUUUST");
                            }

                        }else {
                            System.out.println("Du Stander");
                            int dealerSum = blackJackConvert(computerKortEt);
                            while(dealerSum <17) {

                                dealerSum = dealerSum + blackJackConvert(blackJackPullCard());
                                System.out.println("Dealeren trækker et kort og er nu på " + dealerSum);
                            }
                            if (dealerSum>21){
                                System.out.println("Dealer bustede og du VINDER!!!!!!!!!!!!!!!1");
                            } else if (dealerSum > (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre))) {
                                System.out.println("Dealer ender på " + dealerSum + " Du endte på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre)) + " Derfor taber du......");
                            }

                            else {
                                System.out.println("Du ender på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre)) + " Dealer ender på " + dealerSum +" Derfor vinder du!!!!?!?!??!");
                            }
                        };


                    }else {
                        System.out.println("Du trak: " + spillerKortTre + " og der dermed gået over 21");
                        System.out.println("dine korts samlede værdi: " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre)));
                        System.out.println("BUUUUUST");

                    }

                } else {
                    System.out.println("Du Stander");
                    int dealerSum = blackJackConvert(computerKortEt);
                    while(dealerSum <17) {

                        dealerSum = dealerSum + blackJackConvert(blackJackPullCard());
                        System.out.println("Dealeren trækker et kort og er nu på " + dealerSum);
                    }
                    if (dealerSum>21){
                        System.out.println("Dealer bustede og du VINDER!!!!!!!!!!!!!!!1");
                    } else if (dealerSum > (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre))) {
                        System.out.println("Dealer ender på " + dealerSum + " Du endte på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre)) + " Derfor taber du......");
                    } else if (dealerSum == (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre))) {
                        System.out.println("Push du får dine penge igen");

                    } else {
                        System.out.println("Du ender på " + (blackJackConvert(spillerKortEt) + blackJackConvert(spillerKortTo) + blackJackConvert(spillerKortTre)) + " Dealer ender på " + dealerSum +" Derfor vinder du!!!!?!?!??!");
                    }

                }

            }


        }


    }


}
