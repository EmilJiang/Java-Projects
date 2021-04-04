public class BlackjackHand extends Hand{

    private int handValue;
    private boolean soft;
    BlackjackHand(){
        super(0);
    }
    BlackjackHand(boolean dealer){
        super(1);
        if(!dealer){
            super.addCard();
        }
    }
    private void computeValue() {
        handValue = 0;
        boolean aces = false;
        soft = false;
        for (int i = 0; i < numberofCards(); i++) {
            if (nthCard(i).getValue() == 11 || nthCard(i).getValue() == 12 || nthCard(i).getValue() == 13) {
                handValue += 10;
            } else {
                handValue += nthCard(i).getValue();
            }
            if (nthCard(i).getValue() == 1) {
                aces = true;
            }
        }
        if (aces && handValue < 12) {
            handValue += 10;
            soft = true;
        }
    }
    public void addCard(PlayingCard playingcard){
        super.addCard(playingcard);
        computeValue();
    }
    public void addCard(){
        super.addCard();
        computeValue();
    }
    public int handValue() {
        return handValue;
    }

    public boolean soft() {
        return soft;
    }
}
