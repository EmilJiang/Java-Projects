import java.util.Scanner;

public class HumanBlackjackPlayer extends BlackjackPlayer {
    private static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand){
        System.out.println("Dealer's Hand ");
        dealerHand.print();
        System.out.println("Player's Hand");
        playerHand.print();
        System.out.println("Do you want to hit?(yes/no) ");
        while(true){
            String x = inputString();
            if(x.equals("yes")){
                return true;
            }
            else if(x.equals("no")){
                return false;
            }
            else{
                System.out.println("You Typed Something Wrong, Reenter ");
            }
        }
    }
    public void dealerHit(BlackjackHand dealerHand){
        System.out.println("The dealer hit");
        System.out.println("Dealer's Hand");
        dealerHand.print();
        System.out.println();
    }
    public void playerBusts(BlackjackHand playerHand){
        System.out.println("Player's Hand");
        playerHand.print();
        System.out.println();
        System.out.println("Player Busts");
        System.out.println("---------------" + "\n");
    }
    public void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand){
        System.out.println("Dealer's Hand");
        dealerHand.print();
        System.out.println("Player's Hand");
        playerHand.print();
        System.out.println();
        System.out.println("Dealer and player tie");
        System.out.println("-----------------"+ "\n");
    }
    public void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand){
        System.out.println("Dealer's Hand");
        dealerHand.print();
        System.out.println("Player's Hand");
        playerHand.print();
        System.out.println();
        System.out.println("Player wins");
        System.out.println("------------"+ "\n");
    }
    public void dealerBusts(BlackjackHand dealerHand){
        System.out.println("Dealer's Hand");
        dealerHand.print();
        System.out.println();
        System.out.println("Dealer Busts");
        System.out.println("-------------"+ "\n");
    }
    public void dealerWins(BlackjackHand dealerHand, BlackjackHand playerHand){
        System.out.println("Dealer's Hand");
        dealerHand.print();
        System.out.println("Player's Hand");
        playerHand.print();
        System.out.println();
        System.out.println("Dealer wins" );
        System.out.println("------------"+ "\n");
    }
}
