public class ComputerBattleshipPlayer extends BattleshipPlayer{
    @Override
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
        this.updateGrid(pos,hit,initial);
    }

    @Override
    public String playerName() {
        return "Computer Player";
    }

    @Override
    public void startGame() {
        this.initializeGrid();
    }

    @Override
    public Position shoot() {
        int rCor = (int)(Math.random()*10);
        int cCor = (int)(Math.random()*10);
        while(!(this.getGrid().empty(new Position(rCor,cCor)))){
            rCor = (int)(Math.random()*10);
            cCor = (int)(Math.random()*10);
        }
        return new Position(rCor,cCor);
    }
}
