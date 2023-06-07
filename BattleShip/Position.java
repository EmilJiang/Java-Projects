import java.util.Scanner;

public class Position {
    private char row;
    private int column;
    private int rowIndex;
    private int columnIndex;
    Position(int rowIndex1, int columnIndex1){
        rowIndex = rowIndex1;
        columnIndex = columnIndex1;
        row = (char) (rowIndex1+65);
        column = columnIndex1+1;
    }
    Position(char letter, int number){
        row = letter;
        column = number;
        columnIndex = column-1;
        rowIndex = (int) row - 65;
    }
    Position(){
        String s = inputString();
        rowIndex = PositionChecker.checkPosition(s).rowIndex();
        columnIndex = PositionChecker.checkPosition(s).columnIndex();
        if(rowIndex == -1){
            row = '&';
            column = 0;
        }
        else{
            row = (char)(rowIndex+65);
            column = columnIndex+1;
        }

    }
    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public char row(){
        return row;
    }
    public int column(){
        return column;
    }
    public String toString(){
        return row +"-"+ column;
    }
    public int rowIndex(){
        return rowIndex;
    }
    public int columnIndex(){
        return columnIndex;
    }
}
