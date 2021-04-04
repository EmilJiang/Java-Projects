import java.util.ArrayList;

public class Hand {
    private ArrayList<PlayingCard> cards;
    Hand(int intialCards){
        cards = new ArrayList<PlayingCard>();
        for(int i = 0; i<intialCards; i++)
        {
            addCard(new PlayingCard());
        }
    }
    public int numberofCards(){
        return cards.size();
    }
    public PlayingCard nthCard(int n){
        return cards.get(n);
    }
    public void print(){
        for(PlayingCard i: cards){
            System.out.println(i);
        }
    }
    public void addCard(PlayingCard playingcard){
        cards.add(playingcard);
    }
    public void addCard(){
        addCard(new PlayingCard());
    }

}
