public class BlackjackDealer {
    public double playBlackjack(BlackjackPlayer player, int numGames){
        double playerScore = 0;
        int games = numGames;
        while(numGames>0){
            BlackjackHand dealerHand = new BlackjackHand(true);
            BlackjackHand playerHand = new BlackjackHand(false);
            while(playerHand.handValue() <22 && player.hit(dealerHand, playerHand)){
                playerHand.addCard();
            }
            if(playerHand.handValue()>=22){
                player.playerBusts(playerHand);
            }
            while(playerHand.handValue() <22 && dealerHand.handValue()<17){
                dealerHand.addCard();
                player.dealerHit(dealerHand);
            }
            if(dealerHand.handValue()>=22){
                player.dealerBusts(dealerHand);
                playerScore+=1;
            }
            if(dealerHand.handValue()<22 && playerHand.handValue()<22){
                if(dealerHand.handValue()>playerHand.handValue()){
                    player.dealerWins(dealerHand,playerHand);
                }
                else if(dealerHand.handValue()<playerHand.handValue()){
                    player.playerWins(playerHand,dealerHand);
                    playerScore+=1;
                }
                else{
                    player.playerTies(playerHand,dealerHand);
                    playerScore+=.5;
                }
            }
            numGames-=1;
        }
        return playerScore/games;
    }
}
