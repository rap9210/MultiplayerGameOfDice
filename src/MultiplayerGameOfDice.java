import java.util.Random;
import java.util.Scanner;

public class MultiplayerGameOfDice {
    public static void main(String[] args){
        //Starting by importing Scanner and Random class to access
        //during various sections of the game.
        Scanner scn = new Scanner(System.in);
        Random r = new Random();
        /*
        Pre game setup.
        Prompt user for the number of players. Max 4
        Prompt the user for the name of each player. Assign to
        player variables.
        if statements to separate games based on number of players.
         */
        String player_1;
        String player_2;
        String player_3;
        String player_4;
        String roll_q = "";
        System.out.println("Initiate Game of Dice? y/n ");
        String initiate_GoD = scn.nextLine();
        while((initiate_GoD.equalsIgnoreCase("y"))&&(!roll_q.equalsIgnoreCase("q"))) {
            System.out.println("Welcome to Game of Dice ");
            System.out.println("Enter 'r' to view the rules or 's' to skip: ");
            String rules = scn.nextLine();
            while (rules.equalsIgnoreCase("r"))
            {
                System.out.println("Game of Dice: ");
                System.out.println("The order of the players is randomly selected.");
                System.out.println("Then each player takes their turn throwing the dice.");
                System.out.println("The totals of each dice roll are added to the players score.");
                System.out.println("If a player rolls a '1' on each die (also known as SNAKE EYES) \nthat players gets 25pts instead of 2.");
                System.out.println("If a player rolls a '1' on either die but doesn't roll a SNAKE EYES, \nthey lose their turn and gain 0pts");
                System.out.println("The first player to 100 wins!");
                System.out.println();
                System.out.println("Okay! So are you ready to play? y/n or 'r' to view rules again.");
                rules = scn.nextLine();
            }
            /*
            After all the players names have been recorded and the rules explained it's time to start the game
            depending on how many players were entered. player_1 starts and player_4 is last.
            */
            int turn_counter = 0;   //will go up after each person rolls. When the last person rolls reset to 0.


            int dice_roll_1;        //Variables to hold values of both 'dice'
            int dice_roll_2;
            int player_1_score = 0; //Variables to store the score of each player.
            int player_2_score = 0;
            int player_3_score = 0;
            int player_4_score = 0;
            System.out.println("Alright! First things first.\nHow many players will be playing today? max[4]");
            String num_players = scn.nextLine();
            if (num_players.equals("1")) {
                if (turn_counter == 0) {
                    System.out.println("Enter the name for ");
                    System.out.print("player_1: ");
                    player_1 = scn.nextLine();
                    System.out.println("Alright " + player_1 + " let's get started! You can quit at any time by entering 'q'");
                    System.out.println("Enter 'roll' to roll the dice: ");
                    roll_q = scn.nextLine();
                    if (!roll_q.equalsIgnoreCase("q")) {
                        do {
                            dice_roll_1 = 1 + r.nextInt(6);
                            dice_roll_2 = 1 + r.nextInt(6);
                            System.out.println(dice_roll_1);
                            System.out.println(dice_roll_2);
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_1_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                            } else if ((dice_roll_1 == 1) || (dice_roll_2 == 1)) {
                                System.out.println("Sorry! You gained no points this turn!");
                            } else {
                                player_1_score += dice_roll_1 + dice_roll_2;
                                System.out.println(player_1 + "Score: " + player_1_score);
                            }
                            if (player_1_score < 100) {
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            } else {
                                System.out.println("You did it! You got to 100!");
                                System.out.println("end of game");
                            }
                        } while ((!roll_q.equalsIgnoreCase("q")) && (player_1_score < 100));
                    }

                }

            }else if (num_players.equals("2")) {
                System.out.println("Enter the name for ");
                System.out.print("player_1: ");
                player_1 = scn.nextLine();
                System.out.println("Enter the name for ");
                System.out.print("player_2: ");
                player_2 = scn.nextLine();
                System.out.println("Alright "+player_1+" rolls first, let's get started! You can quit at any time by entering 'q'");
                System.out.println("Enter 'roll' to roll the dice: ");
                roll_q = scn.nextLine();
                if(!roll_q.equalsIgnoreCase( "q")) {
                    do {
                        dice_roll_1 = 1 + r.nextInt(6);
                        dice_roll_2 = 1 + r.nextInt(6);
                        System.out.println(dice_roll_1);
                        System.out.println(dice_roll_2);
                        if (turn_counter == 0) {
                            /*
                            Use turn counter to alternate between players.
                            Conditions for a Snake Eyes.
                            If not Snake Eyes but a die is '1'
                            If no '1' is rolled.
                             */
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_1_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                turn_counter++;
                            }else if ((dice_roll_1 == 1)||(dice_roll_2 == 1))
                            {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter++;
                            }
                            else
                            {
                                player_1_score += dice_roll_1+dice_roll_2;
                                System.out.println(player_1+"Score: "+player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                turn_counter++;
                        }

                        }
                        else if (turn_counter == 1)
                        {
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_2_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                turn_counter--;
                            }else if ((dice_roll_1 == 1)||(dice_roll_2 == 1))
                            {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter--;
                            }
                            else
                            {
                                player_2_score += dice_roll_1+dice_roll_2;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: "+player_2_score);
                                turn_counter--;
                            }

                        }
                        if ((player_1_score < 100)&&(player_2_score < 100)) {
                            if (turn_counter == 0) {
                                System.out.println(player_1+", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            }
                            else if (turn_counter == 1){
                                System.out.println(player_2+", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            }
                        }
                         /*
                        Set Win condition and appropriate message.
                         */
                        else if (player_1_score >= 100){
                            System.out.println(player_1+" WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        }
                        else if (player_2_score >= 100){
                            System.out.println(player_2+" WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        }
                    } while ((!roll_q.equalsIgnoreCase("q"))&&(player_1_score < 100)&&(player_2_score < 100));
                }

            } else if (num_players.equals("3")) {
                System.out.println("Enter the name for ");
                System.out.print("player_1: ");
                player_1 = scn.nextLine();
                System.out.println("Enter the name for ");
                System.out.print("player_2: ");
                player_2 = scn.nextLine();
                System.out.println("Enter the name for ");
                System.out.print("player_3: ");
                player_3 = scn.nextLine();
                System.out.println("Alright "+player_1+" rolls first, "+player_2+" second, and "+player_3+" last. Let's get started! \nYou can quit at any time by entering 'q'");
                System.out.println("Enter 'roll' to roll the dice: ");
                roll_q = scn.nextLine();
                if(!roll_q.equalsIgnoreCase( "q")) {
                    do {
                        dice_roll_1 = 1 + r.nextInt(6);
                        dice_roll_2 = 1 + r.nextInt(6);
                        System.out.println(dice_roll_1);
                        System.out.println(dice_roll_2);
                        if (turn_counter == 0) {
                            /*
                            Use turn counter to alternate between player 1 and 2
                            Conditions for a Snake Eyes.
                            If not Snake Eyes but a die is '1'
                            If no '1' is rolled.
                             */
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_1_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                turn_counter++;
                            }else if ((dice_roll_1 == 1)||(dice_roll_2 == 1))
                            {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter++;
                            }
                            else
                            {
                                player_1_score += dice_roll_1+dice_roll_2;
                                System.out.println(player_1+"Score: "+player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                turn_counter++;
                            }

                        }
                        else if (turn_counter == 1)
                        {
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_2_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                turn_counter++;
                            }else if ((dice_roll_1 == 1)||(dice_roll_2 == 1))
                            {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter++;
                            }
                            else
                            {
                                player_2_score += dice_roll_1+dice_roll_2;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: "+player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                turn_counter++;
                            }

                        }else if (turn_counter == 2)
                        {
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_3_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                turn_counter-=2;
                            }else if ((dice_roll_1 == 1)||(dice_roll_2 == 1))
                            {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter-=2;
                            }
                            else
                            {
                                player_3_score += dice_roll_1+dice_roll_2;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: "+player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                turn_counter-=2;
                            }

                        }
                        if ((player_1_score < 100)&&(player_2_score < 100)&&(player_3_score < 100)) {
                            if (turn_counter == 0) {
                                System.out.println(player_1+", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            }
                            else if (turn_counter == 1){
                                System.out.println(player_2+", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            }else if (turn_counter == 2){
                                System.out.println(player_3+", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            }
                        }
                        /*
                        Set Win condition and appropriate message.
                         */
                        else if (player_1_score >= 100){
                            System.out.println(player_1+" WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        }
                        else if (player_2_score >= 100){
                            System.out.println(player_2+" WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        }else if (player_3_score >= 100){
                            System.out.println(player_3+" WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                    }
                }while ((!roll_q.equalsIgnoreCase("q"))&&(player_1_score < 100)&&(player_2_score < 100)&&(player_3_score < 100));
            }
            }else if (num_players.equals("4")) {
                System.out.println("Enter the name for ");
                System.out.print("player_1: ");
                player_1 = scn.nextLine();
                System.out.println("Enter the name for ");
                System.out.print("player_2: ");
                player_2 = scn.nextLine();
                System.out.println("Enter the name for ");
                System.out.print("player_3: ");
                player_3 = scn.nextLine();
                System.out.println("Enter the name for ");
                System.out.print("player_4: ");
                player_4 = scn.nextLine();
                System.out.println("Alright "+player_1+" rolls first, "+player_2+" second, "+player_3+" third and "+player_4+" last. Let's get started! \nYou can quit at any time by entering 'q'");
                System.out.println("Enter 'roll' to roll the dice: ");
                roll_q = scn.nextLine();
                if(!roll_q.equalsIgnoreCase( "q")) {
                    do {
                        dice_roll_1 = 1 + r.nextInt(6);
                        dice_roll_2 = 1 + r.nextInt(6);
                        System.out.println(dice_roll_1);
                        System.out.println(dice_roll_2);
                        if (turn_counter == 0) {
                            /*
                            Use turn counter to alternate between players.
                            Conditions for a Snake Eyes.
                            If not Snake Eyes but a die is '1'
                            If no '1' is rolled.
                             */
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_1_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter++;
                            } else if ((dice_roll_1 == 1) || (dice_roll_2 == 1)) {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter++;
                            } else {
                                player_1_score += dice_roll_1 + dice_roll_2;
                                System.out.println(player_1 + "Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter++;
                            }

                        } else if (turn_counter == 1) {
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_2_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter++;
                            } else if ((dice_roll_1 == 1) || (dice_roll_2 == 1)) {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter++;
                            } else {
                                player_2_score += dice_roll_1 + dice_roll_2;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter++;
                            }

                        } else if (turn_counter == 2) {
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_3_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter++;
                            } else if ((dice_roll_1 == 1) || (dice_roll_2 == 1)) {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter++;
                            } else {
                                player_3_score += dice_roll_1 + dice_roll_2;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter++;
                            }

                        } else if (turn_counter == 3) {
                            if ((dice_roll_1 == 1) && (dice_roll_2 == 1)) {
                                System.out.println("SNAKE EYES!");
                                player_4_score += 25;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter -= 3;
                            } else if ((dice_roll_1 == 1) || (dice_roll_2 == 1)) {
                                System.out.println("Sorry! You gained no points this turn!");
                                turn_counter -= 3;
                            } else {
                                player_4_score += dice_roll_1 + dice_roll_2;
                                System.out.println(player_1 + " Score: " + player_1_score);
                                System.out.println(player_2 + " Score: " + player_2_score);
                                System.out.println(player_3 + " Score: " + player_3_score);
                                System.out.println(player_4 + " Score: " + player_4_score);
                                turn_counter -= 3;
                            }
                        }
                        if ((player_1_score < 100) && (player_2_score < 100) && (player_3_score < 100) && (player_4_score < 100)) {
                            if (turn_counter == 0) {
                                System.out.println(player_1 + ", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            } else if (turn_counter == 1) {
                                System.out.println(player_2 + ", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            } else if (turn_counter == 2) {
                                System.out.println(player_3 + ", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            } else if (turn_counter == 3) {
                                System.out.println(player_4 + ", it's your turn.");
                                System.out.println("Enter 'roll' to roll again: ");
                                roll_q = scn.nextLine();
                            }
                        } else if (player_1_score >= 100) {
                            System.out.println(player_1 + " WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        } else if (player_2_score >= 100) {
                            System.out.println(player_2 + " WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        } else if (player_3_score >= 100) {
                            System.out.println(player_3 + " WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        } else if (player_4_score >= 100) {
                            System.out.println(player_4 + " WINS!");
                            System.out.println("Would you like to play again? y/n");
                            initiate_GoD = scn.nextLine();
                        }

                    } while ((!roll_q.equalsIgnoreCase("q")) && (player_1_score < 100) && (player_2_score < 100) && (player_3_score < 100)
                            && (player_4_score < 100));

                }
            }
        }
    }
}
