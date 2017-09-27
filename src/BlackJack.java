import java.util.*;
import java.lang.*;

public class BlackJack
{
	static Random ran=new Random();

    static int playerHand;
    static int dealerHand;

    static int game=1;

   	static int playerWins;
    static int dealerWins;
    static int ties;

    static int total=game-1;

    public static void main (String[] args)
    {
    	System.out.println("START GAME #"+game);
    	getCard();
        menu();
    }
    public static void menu()
    {
        Scanner scnr=new Scanner(System.in);
        int choice=0;
        boolean tryAgain=true;
		int n=0;

        while(choice!=4)
        {
            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print game statistics");
            System.out.println("4. Exit");
		do
		{
            try
            {
            	System.out.print("\nChoose an option: ");
                choice=scnr.nextInt();

                if(choice==1 || choice==2 || choice==3 || choice==4)
                	tryAgain=false;

                else if (choice<1 || choice>4)
                	throw new NumberFormatException("Integer is out of range.");
            }
            catch (NumberFormatException e1)
            {
            	System.out.println("\nInvalid Input!\nPlease enter an integer value between 1 and 4.\n");
            	menu();
            	scnr.nextLine();
            }
            catch (InputMismatchException e2)
            {
            	System.out.println("\nInvalid Input!\nPlease enter an integer value between 1 and 4.\n");
            	menu();
            	scnr.nextLine();
            }
		}
			while(tryAgain);


            if(choice==1)
                getCard();

            if(choice==2)
                holdHand();

            if(choice==3)
                printStats();

            if(choice==4)
            	System.exit(n);
        }
    }
    public static void getCard()
    {
       	int playerCard=ran.nextInt(13)+1;

            if(playerCard==1)
            {
            	playerHand+=playerCard;

				if(playerHand>21)
				{
				 	System.out.println("\nYour card is an ACE!");
               	 	System.out.println("Your hand is: "+playerHand);
               	 	result();
				}
				else if(playerHand==21)
					result();
				else
				{
				 System.out.println("\nYour card is an ACE!");
               	 System.out.println("Your hand is: "+playerHand);
               	 System.out.println();
				}
            }
            else if(playerCard==11)
            {
                playerCard=10;
                playerHand+=playerCard;

				if(playerHand>21)
				{
				 	System.out.println("\nYour card is a JACK!");
               	 	System.out.println("Your hand is: "+playerHand);
               	 	result();
				}
				else if(playerHand==21)
					result();
				else
				{
					System.out.println("\nYour card is a JACK!");
                	System.out.println("Your hand is: "+playerHand);
               		System.out.println();
				}
            }
            else if(playerCard==12)
            {
                playerCard=10;
                playerHand+=playerCard;

  				if(playerHand>21)
				{
				 	System.out.println("\nYour card is an QUEEN!");
               	 	System.out.println("Your hand is: "+playerHand);
               	 	result();
				}
				else if(playerHand==21)
					result();
				else
				{
               		System.out.println("\nYour card is a QUEEN!");
                	System.out.println("Your hand is: "+playerHand);
                	System.out.println();
				}
            }
            else if(playerCard==13)
            {
                playerCard=10;
                playerHand+=playerCard;

				if(playerHand>21)
				{
				 	System.out.println("\nYour card is a KING!");
               	 	System.out.println("Your hand is: "+playerHand);
               	 	result();
				}
				else if(playerHand==21)
					result();
				else
				{
					System.out.println("\nYour card is a KING!");
                	System.out.println("Your hand is: "+playerHand);
                	System.out.println();
				}
            }
            else
            {
            	playerHand+=playerCard;

				if(playerHand>21)
				{
				 	System.out.println("\nYour card is a "+playerCard+ "!");
               	 	System.out.println("Your hand is: "+playerHand);
               	 	result();
				}
				else if(playerHand==21)
					result();
				else
				{
					System.out.println("\nYour card is a "+playerCard+ "!");
                	System.out.println("Your hand is: "+playerHand);
                	System.out.println();
				}
            }
    }
    public static void holdHand()
    {
    	int dealerCard=(int)(Math.random()*11+16);

        dealerHand+=dealerCard;

       	result();
    }
    public static void printStats()
    {
        System.out.println("\nNumber of Player wins: "+playerWins);
        System.out.println("Number of Dealer wins: "+dealerWins);
        System.out.println("Number of tie games: "+ties);
        System.out.println("Total # of games played: "+total+"");

        double percentage=((double)playerWins/total)*100;
        System.out.println("Percentage of Player wins: "+percentage+ "%\n");
    }
    public static void result()
    {
    	if(playerHand>21)
    	{
    		System.out.println("\nYou exceeded 21! You lose :(\n");
            dealerWins++;
    	}
    	else if(playerHand==21)
		{
			System.out.println("\nDealer's hand: "+dealerHand);
            System.out.println("Your hand: "+playerHand);

            System.out.println("\nBLACKJACK! You win!\n");
            playerWins++;
		}
		else if(dealerHand==21)
        {
        	System.out.println("\nDealer's hand: "+dealerHand);
            System.out.println("Your hand: "+playerHand);

            System.out.println("\nBLACKJACK! You lose!\n");
            dealerWins++;
        }
       else if(dealerHand>21 || playerHand>dealerHand)
       	{
       		System.out.println("\nDealer's hand: "+dealerHand);
            System.out.println("Your hand: "+playerHand);

            System.out.println("\nYou win!\n");
            playerWins++;
       	}
       	else if(playerHand<dealerHand)
        {
            System.out.println("\nDealer's hand: "+dealerHand);
            System.out.println("Your hand: "+playerHand);

            System.out.println("\nDealer wins!\n");
            dealerWins++;
        }
       else if(dealerHand==playerHand)
        {
            System.out.println("\nDealer's hand: "+dealerHand);
            System.out.println("Your hand: "+playerHand);

            System.out.println("\nIt's a tie! No one wins!\n");
            ties++;
        }

		    playerHand=0;
            dealerHand=0;
            total++;
            game++;

            System.out.println("START GAME #"+game+ "\n");
    }
}
