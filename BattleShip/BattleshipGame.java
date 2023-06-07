public class BattleshipGame {
    private int moves;
    private Ocean ocean;
    private BattleshipPlayer player1;
    BattleshipGame(BattleshipPlayer player){
        ocean = new Ocean();
        moves = 1;
        ocean.placeAllBoats();
        ocean.printBoatLocations();
        player1 = player;
        player1.startGame();
    }
    public int play(){
        Position position;
        while(moves<=100 && !ocean.allSunk()){
            position = player1.shoot();
            ocean.shootAt(position);
            if(moves<100){
                player1.updatePlayer(position, ocean.hit(position), ocean.boatInitial(position), ocean.boatName(position),  ocean.sunk(position), ocean.allSunk(), false, moves);
            }
            else{
                player1.updatePlayer(position, ocean.hit(position), ocean.boatInitial(position), ocean.boatName(position),  ocean.sunk(position), ocean.allSunk(), true, moves);
            }
            moves++;
        }
        return moves-1;

    }
}
