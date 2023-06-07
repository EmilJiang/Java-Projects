public class Ocean extends GoodOcean{
    public void placeAllBoats(){
        int rCor;
        int cCor;
        int vertOrHor;
        String direction;
        String bType;
        int numberBoats = 1;
        while(numberBoats<=5){
            try{
                vertOrHor = (int)Math.round(Math.random());
                rCor = (int)(Math.random()*10);
                cCor = (int)(Math.random()*10);
                if(numberBoats == 1){
                    bType = "Aircraft Carrier";
                }
                else if(numberBoats == 2){
                    bType = "Battleship";
                }
                else if(numberBoats == 3){
                    bType = "Cruiser";
                }
                else if(numberBoats == 4){
                    bType = "Destroyer";
                }
                else{
                    bType = "Submarine";
                }
                if(vertOrHor==1){
                    direction = "vertical";
                }
                else{
                    direction = "horizontal";
                }
                placeBoat(bType,direction,new Position(rCor,cCor));
                numberBoats +=1;
            }catch(Exception ignored){
            }
        }
    }
}
