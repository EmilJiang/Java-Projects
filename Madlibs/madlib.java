import java.util.Scanner;

public class Madlibs {
    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static String queryReplace(String storyLine){
        while(storyLine.indexOf("<") != -1){
            String partOfSpeech = Madlibs.WordInsideBrackets(storyLine);
            System.out.println("Enter a " + partOfSpeech + ":");
            storyLine = Madlibs.substituteWord(storyLine, Madlibs.inputString());
        }
        return storyLine;
    }
    public static String WordInsideBrackets(String storyLine){
        String partOfSpeech = "";
        int bracketPlacement = storyLine.indexOf('<')+1;
        int bracketPlacement2 = storyLine.indexOf('>');
        if(bracketPlacement2 == -1){
            return "";
        }
        else{
            partOfSpeech += storyLine.substring(bracketPlacement,bracketPlacement2);
        }
        return partOfSpeech;
    }
    public static String substituteWord(String storyLine, String word){
        String story = "";
        int bracketPlacement = storyLine.indexOf('<');
        String subStrInStory = storyLine.substring(0,bracketPlacement);
        int bracketPlacement2 = storyLine.indexOf('>');
        String subStrInStory2 = storyLine.substring(bracketPlacement2+1);
        story+= subStrInStory + word + subStrInStory2;
        return story;

    }
    public static void main(String[] args){
        
        //Section 1 Test case 1
        String storyLine = "star-spangled <noun>";
        String word = "banner";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word) + "\n");

        //Section 1 Test case 2
        storyLine = "<greeting> it is a good day today";
        word = "Hey";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word)+ "\n");

        //Section 1 Test case 3
        storyLine = "I really like <verb> during the summer";
        word = "swimming";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word)+"\n");

        //Section 1 Test case 4
        storyLine = "My dog is <descriptive adjective>";
        word = "really cute";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word)+"\n");

        //Section 1 Test case 5
        storyLine = "There are <noun> in math a person uses <(less than) and >(greater than)";
        word = "instances";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word)+"\n");

        //Section 1 Test case 6
        storyLine = "This sentence has a <adjective> brackets that say <adjective>";
        word = "couple";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word)+"\n");

        //Section 1 Test case 7
        storyLine = "I just got $<amount of $> from the bank";
        word = "300";
        System.out.println("storyLine: " + storyLine);
        System.out.println("word: " + word);
        System.out.println("method returns: " + substituteWord(storyLine,word) + "\n");

        //Section 2 Test case 1
        storyLine = "I like to <verb> on the beach";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + WordInsideBrackets(storyLine) + "\n");

        //Section 2 Test case 2
        storyLine = "I like <plural noun> that are fluffy";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + WordInsideBrackets(storyLine) + "\n");

        //Section 2 Test case 3
        storyLine = "";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + WordInsideBrackets(storyLine) + "\n");

        //Section 2 Test case 4
        storyLine = "I like to eat dumplings";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + WordInsideBrackets(storyLine) + "\n");

        //Section 3 Test case 1
        storyLine = "When in the <noun> of <adjective> events";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 3 Test case 2
        storyLine = "During the holidays it is very cold";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 3 Test case 3
        storyLine = "<Verb + ing> is very fun at night";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 3 Test case 4
        storyLine = "I enjoy biking in the <weather>";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 3 Test case 5
        storyLine = "<Verb with ing> is a favorite sport of mine because it is <adjective>";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 3 Test case 5
        storyLine = "\"<Animal noise>\" said the cat as he was <verb + ing> away from the big bad <noun>";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 3 Test case 6
        storyLine = "<First Name> <Last Name> likes to drink lots of water";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Setion 3 Test case 7
        storyLine = "";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");
    }
}
