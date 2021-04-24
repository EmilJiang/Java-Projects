public class ComputerBlackjackPlayer extends BlackjackPlayer{
    private BlackjackStrategy strat;
    ComputerBlackjackPlayer(BlackjackStrategy theStrategy){
        strat = theStrategy;
    }
    public boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand){
        return strat.hit(playerHand.handValue(),dealerHand.handValue(), playerHand.soft());
    }
}
