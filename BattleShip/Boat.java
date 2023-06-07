import java.util.ArrayList;
import java.util.Arrays;

public class Boat {
    private String boatName;
    private String orientation;
    private Position position;
    private ArrayList<int[]> aircraftHitList;
    private ArrayList<int[]> aircraftPositionList;
    private int size;
    public Boat(String boatName1, Position position1, String orientation1){
        boatName = boatName1;
        orientation = orientation1;
        position = position1;
        if(boatName1.equals("Aircraft Carrier")){
            size = 5;
        }
        else if(boatName.equals("Battleship")){
            size = 4;
        }
        else if(boatName.equals("Cruiser")){
            size = 3;
        }
        else if(boatName.equals("Destroyer")){
            size = 2;
        }
        else if(boatName.equals("Submarine")){
            size = 3;
        }
        aircraftHitList = new ArrayList<>();
        aircraftPositionList = new ArrayList<>();
        if(orientation.equals("horizontal")){
            for(int i =0; i<size;  i++){
                int[] a = {position1.rowIndex(),position1.columnIndex()+i};
                aircraftHitList.add(a);
                aircraftPositionList.add(a);
            }
        }
        else if(orientation.equals("vertical")){
            for(int i =0; i<size;  i++){
                int[] a = {position1.rowIndex()+i,position1.columnIndex()};
                aircraftHitList.add(a);
                aircraftPositionList.add(a);
            }
        }

    }
    public String name(){
        return boatName;
    }
    public char abbreviation(){
        return boatName.charAt(0);
    }
    public int size(){
        return size;
    }
    public Position position(){
        return position;
    }
    public boolean onBoat(Position p){
        int[] a = {p.rowIndex(),p.columnIndex()};
        for(int i =0; i<aircraftPositionList.size();i++){
            if(Arrays.equals(a, aircraftPositionList.get(i))){
                return true;
            }
        }
        return false;
    }
    public boolean isHit(Position p){
        int[] a = {p.rowIndex(),p.columnIndex()};
        if(onBoat(p)){
            for(int i =0;i<aircraftHitList.size();i++){
                if(Arrays.equals(aircraftHitList.get(i), a)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public void hit(Position position){
        int[] a = {position.rowIndex(),position.columnIndex()};
        for(int i =0; i<aircraftPositionList.size();i++){
            if(Arrays.equals(a, aircraftPositionList.get(i))){
                aircraftHitList.remove(aircraftPositionList.get(i));
            }
        }

    }
    public boolean sunk(){
        if(aircraftHitList.size() == 0){
            return true;
        }
        return false;
    }
    public String direction(){
        return orientation;
    }
}
