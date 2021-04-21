import java.util.Scanner;
public class PlayingCard {
    private int suit;
    private int value;
    final public static int ACE = 1;
    final public static int KING = 13;
    final public static int QUEEN = 12;
    final public static int JACK = 11;
    final public static int HEARTS = 1;
    final public static int SPADES = 2;
    final public static int CLUBS = 3;
    final public static int DIAMONDS = 4;
    private static boolean random = true;
    private static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    PlayingCard(int suitOfCard, int valueOfCard){
        suit = suitOfCard;
        value = valueOfCard;
    }
    PlayingCard(){
        if(random){
            suit = (int) (Math.random()*4)+1;
            value = (int) (Math.random()*13)+1;
        }
        else{
            System.out.println("Enter a number between 1-4(inclusive) for card suit ");
            suit = Integer.parseInt(inputString());
            System.out.println("Enter a number between 1-13(inclusive) for card value ");
            value = Integer.parseInt(inputString());
        }
    }
    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public static void setRandom(boolean random) {
        PlayingCard.random = random;
    }

    public String toString(){
        String cardName = "";
        if(value == 13){
            cardName += "King of ";
        }
        else if(value == 12){
            cardName+="Queen of ";
        }
        else if(value == 11){
            cardName+="Jack of ";
        }
        else if(value == 1){
            cardName+="Ace of ";
        }
        else{
            cardName+= value + " of ";
        }
        if(suit == 1){
            cardName+="Hearts";
        }
        else if(suit == 2){
            cardName+="Spades";
        }
        else if(suit == 3){
            cardName+="Clubs";
        }
        else if(suit == 4){
            cardName+="Diamonds";
        }
        return cardName;
    }
}
