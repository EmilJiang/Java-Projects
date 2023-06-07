import java.util.ArrayList;

public class EmilJiang2BattleshipStrategy extends ComputerBattleshipPlayer{
    private ArrayList<Position> arr;
    private int num;
    @Override
    public void startGame() {
        this.initializeGrid();
        arr = new ArrayList<Position>();
        num = 0;
        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                arr.add(new Position(i,j));
            }
        }
    }

    @Override
    public Position shoot() {
        num++;
        return arr.get(num - 1);
    }

    @Override
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
        super.updatePlayer(pos, hit, initial, boatName, sunk, gameOver, tooManyTurns, turns);
    }
}
