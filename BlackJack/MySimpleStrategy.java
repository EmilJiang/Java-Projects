public class MySimpleStrategy extends BlackjackStrategy{
    public boolean hit(int handValue, int dealerHandValue, boolean soft){
        if(soft){
            return true;
        }
        if(dealerHandValue == 11 && handValue<21){
            return true;
        }
        if(handValue < 17){
            return true;
        }
        return false;
    }
}
