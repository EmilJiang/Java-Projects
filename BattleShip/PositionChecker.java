public class PositionChecker {

    public static Position checkPosition(String inputPos){
        Position p;
        int hyphenTest = inputPos.indexOf('-');
        if (hyphenTest>-1){
            char letter = inputPos.charAt(0);
            String letterTest = inputPos.substring(0,hyphenTest);
            if(letterTest.length()==1){
                char hyphen = inputPos.charAt(1);
                String d = inputPos.substring(hyphenTest+1);
                if(d.length() >=  1){
                    String number = inputPos.substring(hyphenTest+1);
                    int numberTest;
                    try{
                        numberTest = Integer.parseInt(number);
                    }
                    catch(NumberFormatException numberFormatException){
                        p = new Position(-1,-1);
                        return p;
                    }
                    if((letter>='A' && letter<='J')&& (numberTest>=1 && numberTest<=10) && (hyphen == '-')){
                        p = new Position(letter,numberTest);
                        return p;
                    }
                }
                else{
                    p = new Position(-1,-1);
                    return p;
                }
            }
            else{
                p = new Position(-1,-1);
                return p;
            }
        }
        else{
            p = new Position(-1,-1);
            return p;
        }
        p = new Position(-1,-1);
        return p;
    }
    public static void main(String args[]){
        System.out.println(PositionChecker.checkPosition(""));
    }
}
