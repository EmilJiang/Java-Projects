/*My strategy starts off with the checkerboard pattern by hitting every other position. Every boat will be hit at least once after this.
This will determine the boat placement for every boat except the destroyer. I go down the board and check for the first hit on every boat. I then check for the next hit for the same boat
initial and if the second hit is in the vertical direction I know the boat is in the vertical direction. The same for horizontal. I check for the number of hits for each boat.
If there is a double hit for aircraft carrier, there will be a hit one before the first checkerboard hit, a hit one after, and one hit in plus 3 squares in the
direction determined before. This is the same as if three hits are shown except it will only be one ahead and three ahead. For Battleship
carrier, there will always be two hit and the strategy will hit one ahead, one before if the boat is not on a edge,
and one three spaces ahead also if it is not on the edge. This makes sure the battleship is sunk. For submarine and cruiser, if there is two hit
already, it just shoots in the middle of the two. If there is only one shown, it will add one position in each direction
to make sure the boat is sunk. This can only be done if it is not on the edge. If it is on the edge the strategy will exclude the edge.
For destroyer, it does the same as if submarine and cruiser is only hit once after checkerboard pattern.
This makes sure each boat is sunk and the max turns is 69 while min turns is 59 and the average is 64.2*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmilJiangStrategy extends ComputerBattleshipPlayer{
    private int num;
    private ArrayList<Character> numhit;
    private ArrayList<Position> pos;
    private boolean start;
    private boolean doneSecond;
    private int num1;
    private ArrayList<Position> positionList;


    @Override
    public void startGame() {
        this.initializeGrid();
        num = 0;
        num1 = 0;
        positionList = new ArrayList<>();
        doneSecond = false;
        numhit = new ArrayList<>();
        numhit.add('A');
        numhit.add('B');
        numhit.add('C');
        numhit.add('D');
        numhit.add('S');
        pos = new ArrayList<>();
        int x = 0;
        for(int i = 0; i<10; i++){
            if(x%2==0){
                for(int j = 0; j<10; j+=2){
                    pos.add(new Position(j,i));
                }
            }
            else{
                for(int j = 1; j<10; j+=2){
                    pos.add(new Position(j,i));
                }
            }
            x++;
        }
        start = true;
    }
    @Override
    public Position shoot() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int s = 0;
        if(start){
            start = false;
            return new Position(0,0);
        }
        num++;
        if(num<50){
            return pos.get(num);
        }
        else if(!doneSecond){
            doneSecond = true;
            int x = 0;
            Position[] pos = new Position[10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (this.getGrid().hit(new Position(i, j))) {
                        pos[x] = new Position(i, j);

                        if (this.getGrid().boatInitial(new Position(i, j)) == 'A') {
                            a++;
                        }
                        else if (this.getGrid().boatInitial(new Position(i, j)) == 'B') {
                            b++;
                        }
                        else if (this.getGrid().boatInitial(new Position(i, j)) == 'C') {
                            c++;
                        }
                        else if (this.getGrid().boatInitial(new Position(i, j)) == 'D') {
                            d++;
                        }
                        else if (this.getGrid().boatInitial(new Position(i, j)) == 'S') {
                            s++;
                        }
                        x++;
                    }

                }

            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (this.getGrid().hit(new Position(i, j))) {
                        if (this.getGrid().boatInitial(new Position(i, j)) == 'A' && (a < 5)) {
                            if(a==1) {
                                a+=4;
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i + 2, j));
                                positionList.add(new Position(i + 3, j));
                                positionList.add(new Position(i + 4, j));
                            }
                            else if (i< 8 && this.getGrid().boatInitial(new Position(i+2 , j)) == 'A' && i<8 && this.getGrid().hit(new Position(i + 2, j))) {
                                if (a == 2) {
                                    a += 3;
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i + 3, j));
                                } else if (a == 3) {
                                    a += 2;
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i + 3, j));
                                }
                            } else if (this.getGrid().boatInitial(new Position(i , j+2)) == 'A' && j<8 && this.getGrid().hit(new Position(i, j + 2))) {
                                if (a == 2) {
                                    a += 3;
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i, j+1));
                                    positionList.add(new Position(i, j + 3));
                                } else {
                                    a += 2;
                                    positionList.add(new Position(i, j + 1));
                                    positionList.add(new Position(i, j + 3));
                                }
                            }
                        } else if (this.getGrid().boatInitial(new Position(i, j)) == 'B' && (b < 4)) {
                            if (b==1){
                                b+=3;
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i + 2, j));
                                if(i<=6){
                                    positionList.add(new Position(i + 3, j));
                                }

                            }
                            else if (i<8 && this.getGrid().boatInitial(new Position(i+2, j)) == 'B'  && this.getGrid().hit(new Position(i + 2, j))) {
                                if (b == 2) {
                                    b += 2;
                                    positionList.add(new Position(i + 1, j));
                                    if(i<=6){
                                        positionList.add(new Position(i + 3, j));
                                    }
                                    if(i>0){
                                        positionList.add(new Position(i - 1, j));
                                    }
                                }
                            } else if (this.getGrid().boatInitial(new Position(i , j+2)) == 'B' && this.getGrid().hit(new Position(i, j + 2))) {
                                if (b == 2) {
                                    b += 2;
                                    positionList.add(new Position(i, j+1));
                                    if(j<=6){
                                        positionList.add(new Position(i , j+3));
                                    }
                                    if(j>0){
                                        positionList.add(new Position(i, j - 1));
                                    }
                                }
                            }
                        } else if (this.getGrid().boatInitial(new Position(i, j)) == 'C' && (c < 3)) {
                            if (c == 1) {
                                c += 2;
                                if(i==9 && j==9){
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j - 1));
                                }
                                else if(i==9 && j == 0){
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if(i == 0 && j==0){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if(i == 0 && j == 9){
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i + 1, j));
                                }
                                else if( i == 0){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if( i == 9){
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if( j == 0){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i-1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if( j == 9){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i-1, j));
                                    positionList.add(new Position(i, j - 1));
                                }
                                else{
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                            } else if (c == 2) {
                                c += 1;
                                if (i<8 && this.getGrid().boatInitial(new Position(i + 2, j)) == 'C' && this.getGrid().hit(new Position(i + 2, j))) {
                                    positionList.add(new Position(i + 1, j));
                                } else {
                                    positionList.add(new Position(i, j + 1));
                                }
                            }
                        }
                        else if (this.getGrid().boatInitial(new Position(i, j)) == 'S' && (s < 3)) {

                            if (s == 1) {
                                s += 2;
                                if(i==9 && j==9){
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j - 1));
                                }
                                else if(i==9 && j == 0){
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if(i == 0 && j==0){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if(i == 0 && j == 9){
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i + 1, j));
                                }
                                else if( i == 0){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if( i == 9){
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if( j == 0){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i-1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                                else if( j == 9){
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i-1, j));
                                    positionList.add(new Position(i, j - 1));
                                }
                                else{
                                    positionList.add(new Position(i - 1, j));
                                    positionList.add(new Position(i, j - 1));
                                    positionList.add(new Position(i + 1, j));
                                    positionList.add(new Position(i, j + 1));
                                }
                            }
                            else if (s == 2) {
                                s += 1;
                                if (i< 8 && this.getGrid().hit(new Position(i + 2, j))) {
                                    positionList.add(new Position(i + 1, j));
                                } if(j<8 && this.getGrid().hit(new Position(i,j+2))){
                                    positionList.add(new Position(i, j + 1));
                                }
                            }
                            else {
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i + 2, j));
                            }
                        } else if (this.getGrid().boatInitial(new Position(i, j)) == 'D') {
                            if(i!=0 && i!= 9 && j!=0 && j!=9){
                                positionList.add(new Position(i - 1, j));
                                positionList.add(new Position(i, j - 1));
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i, j + 1));
                            }
                            else if(i==9 && j==9){
                                positionList.add(new Position(i - 1, j));
                                positionList.add(new Position(i, j - 1));
                            }
                            else if(i==9 && j == 0){
                                positionList.add(new Position(i - 1, j));
                                positionList.add(new Position(i, j + 1));
                            }
                            else if(i == 0 && j==0){
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i, j + 1));
                            }
                            else if(i == 0 && j == 9){
                                positionList.add(new Position(i, j - 1));
                                positionList.add(new Position(i + 1, j));
                            }
                            else if( i == 0){
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i, j - 1));
                                positionList.add(new Position(i, j + 1));
                            }
                            else if( i == 9){
                                positionList.add(new Position(i - 1, j));
                                positionList.add(new Position(i, j - 1));
                                positionList.add(new Position(i, j + 1));
                            }
                            else if( j == 0){
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i-1, j));
                                positionList.add(new Position(i, j + 1));
                            }
                            else if( j == 9) {
                                positionList.add(new Position(i + 1, j));
                                positionList.add(new Position(i - 1, j));
                                positionList.add(new Position(i, j - 1));
                            }
                        }
                    }
                }
            }
            Set<Position> set = new HashSet<>(positionList);
            positionList.clear();
            positionList.addAll(set);
        }
        else{
            num1++;
            if(num1<=positionList.size()){
                return positionList.get(num1-1);
            }
        }
        return new Position(0,0);
    }
    @Override
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
        super.updatePlayer(pos,hit,initial,boatName,sunk,gameOver,tooManyTurns,turns);
    }
    @Override
    public String playerName() {
        return "Emil Jiang's Strategy";
    }
    public String author(){
        return "Emil Jiang";
    }
}

