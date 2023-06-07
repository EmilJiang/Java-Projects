public class BattleshipGrid {
    private char[][] grid;
    BattleshipGrid(){
        grid = new char[10][10];
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                grid[i][j] = 'E';
            }
        }
    }
    public void shotAt(Position pos,boolean hit,char initial){
        int cPos = pos.columnIndex();
        int rPos = pos.rowIndex();
        if(hit){
            grid[rPos][cPos] = initial ;
        }
        else{
            grid[rPos][cPos] = 'M';
        }
    }
    public boolean hit(Position pos){
        int cPos = pos.columnIndex();
        int rPos = pos.rowIndex();
        if(grid[rPos][cPos] != 'E' && grid[rPos][cPos] != 'M'){
            return true;
        }
        return false;
    }
    public boolean miss(Position pos){
        int cPos = pos.columnIndex();
        int rPos = pos.rowIndex();
        if(grid[rPos][cPos] == 'M'){
            return true;
        }
        return false;
    }
    public boolean empty(Position pos){
        int cPos = pos.columnIndex();
        int rPos = pos.rowIndex();
        if(grid[rPos][cPos] == 'E'){
            return true;
        }
        return false;
    }
    public char boatInitial(Position pos){
        int cPos = pos.columnIndex();
        int rPos = pos.rowIndex();
        return grid[rPos][cPos];
    }
}
