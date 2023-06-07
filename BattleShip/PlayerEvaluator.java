public class PlayerEvaluator {
    private int numRuns;
    private int maxTurns;
    private int minTurns = 999;
    private int totalTurns;
    PlayerEvaluator(EmilJiangStrategy player, int runs){
        numRuns = runs;
        for(int i = 0; i<runs; i++){
            BattleshipGame BG = new BattleshipGame(player);
            System.out.println(i);
            int turns = BG.play();
            if(turns == 100){
                System.out.println("HERE");
            }
            totalTurns+=turns;
            maxTurns = Math.max(maxTurns,turns);
            minTurns = Math.min(minTurns,turns);
        }
    }
    public int maxTurns(){
        return maxTurns;
    }
    public int minTurns(){
        return minTurns;
    }
    public float averageTurns(){
        return ((float)totalTurns) / ((float)numRuns);
    }
}
