import java.util.Scanner;

public class BattleshipPlayer {
    private String name;
    private BattleshipGrid shipGrid;
    BattleshipPlayer(){
        name = null;
    }
    public void startGame(){
        if(name == null){
            System.out.println("Enter Name");
            name = inputString();
            System.out.println("Welcome " + name + " to Battleship");
        }
        initializeGrid();
    }
    public String playerName(){
        return name;
    }
    public Position shoot(){
        System.out.println("Type a position");
        Position p = new Position();
        while(p.toString().equals("&-0")){
            System.out.println("Invalid Position");
            System.out.println("Type a position");
            p = new Position();
        }
        return p;
    }
    public void updateGrid(Position pos, boolean hit, char initial){
        shipGrid.shotAt(pos,hit,initial);
    }
    public BattleshipGrid getGrid(){
        return shipGrid;
    }
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns){
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        Character[] letter = {'A','B','C','D','E','F','G','H','I','J'};
        updateGrid(pos,hit,initial);
        for(int i = 0;i<10;i++){
            System.out.print(letter[i]);
            for(int j = 0; j<10; j++){
                if(shipGrid.empty(new Position(i,j))){
                    System.out.print(" .");
                }
                else if(shipGrid.miss(new Position(i,j))){
                    System.out.print(" *");
                }
                else if(shipGrid.hit(new Position(i,j))){
                    System.out.print(" " + shipGrid.boatInitial(new Position(i,j)));
                }
            }
            System.out.println();
        }
        System.out.print("Turn " + turns + ": ");
        if(hit){
            System.out.println("You hit " + boatName + " at " + pos);
        }
        else{
            System.out.println("You missed at " + pos);
        }
        if(sunk){
            System.out.println("You sunk the " + boatName);
        }
        if(gameOver){
            System.out.println("All boats sunk. Game Over");
        }
        if(tooManyTurns && !gameOver){
            System.out.println("You took too many turns. Game Over");
        }
        System.out.println();
    }
    public void initializeGrid(){
        shipGrid = new BattleshipGrid();
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
