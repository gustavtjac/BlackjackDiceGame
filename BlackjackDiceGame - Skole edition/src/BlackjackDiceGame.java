import com.sun.source.tree.BreakTree;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackjackDiceGame {


    public static int rulDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    public static String vinder(int a, int b) {
        if (a > b) {
            return "Du vandt";
        } else if (a == b) {
            return "I endte på samme sum det er derfor en PUSH ";
        }
        return "Du tabte";
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("Velkommen til BlackjackDicegame");
        System.out.println("Skriv 1 for at spille");
        if (in.nextInt() == 1) {
            int spillerKastEt = rulDice();
            int spillerKastTo = rulDice();
            int spillerKastSum = spillerKastEt + spillerKastTo;
            System.out.println("Du ruller nu to terninger");
            System.out.println("Terning 1: " + spillerKastEt);
            System.out.println("Terning 2: " + spillerKastTo);
            System.out.println("Din terning sum er nu : " + spillerKastSum);
            System.out.println("Vil du hit eller stand?");
            System.out.println("Hit = 1 ");
            System.out.println("Stand = 2");
            if (in.nextInt() == 1) {
                boolean rul = true;
                int spillerKastUpdated = spillerKastSum;
                while (rul) {
                    int nyRul = rulDice();
                    System.out.println("du rullede: " + nyRul);
                    spillerKastUpdated = spillerKastUpdated + nyRul;
                    System.out.println("Din nye sum er nu : " + spillerKastUpdated);
                    if (spillerKastUpdated > 21) {
                        System.out.println("du bustede og tabte dine penge");
                        rul = false;
                        break;
                    }
                    System.out.println("Vil du hit eller stand?");
                    System.out.println("Hit = 1 ");
                    System.out.println("Stand = 2");
                    if (in.nextInt() == 1) {

                    } else {
                        rul = false;
                        System.out.println("nu ruller botten");
                        boolean botRul = true;

                        int botRulUpdated = 0;
                        while (botRul) {
                            int botRulStatus = rulDice();
                            System.out.println("Botten rullede: " + botRulStatus);
                            botRulUpdated = botRulUpdated + botRulStatus;
                            Thread.sleep(800);
                            System.out.println("Bottens sum er nu : " + botRulUpdated);
                            if (botRulUpdated >= 17) {
                                botRul = false;
                                System.out.println(vinder(spillerKastUpdated, botRulUpdated));
                            }

                        }
                    }
                }


            } else {


                System.out.println("nu ruller botten");
                boolean botRul = true;

                int botRulUpdated = 0;
                while (botRul) {
                    int botRulStatus = rulDice();
                    System.out.println("Botten rullede: " + botRulStatus);
                    botRulUpdated = botRulUpdated + botRulStatus;
                    Thread.sleep(800);
                    System.out.println("Bottens sum er nu : " + botRulUpdated);
                    if (botRulUpdated >= 17) {
                        botRul = false;
                        System.out.println(vinder(spillerKastSum, botRulUpdated));
                    }


                }


            }

        }
    }
}