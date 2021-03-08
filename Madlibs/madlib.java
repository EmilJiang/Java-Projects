import java.util.Scanner;

class MablibStoryExecuteable extends MadLibStory {
    public static void alivenessTest(boolean run){
        if (run)Madlib.playMadlibs(new String[]{});}
        public static void main(String args[]){
        alivenessTest(false);
        MadLibStory.run();}}
public class Madlib {
    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static String queryReplace(String storyLine){
        while(storyLine.indexOf("<") != -1){
            String partOfSpeech = Madlib.wordInsideBrackets(storyLine);
            if(partOfSpeech.charAt(0) == 'a' || partOfSpeech.charAt(0) == 'A'){
                System.out.println("Enter an " + partOfSpeech + ":");
            }
            else if(partOfSpeech.charAt(0) == 'e' || partOfSpeech.charAt(0) == 'E'){
                System.out.println("Enter an " + partOfSpeech + ":");
            }
            else if(partOfSpeech.charAt(0) == 'i' || partOfSpeech.charAt(0) == 'I'){
                System.out.println("Enter an " + partOfSpeech + ":");
            }
            else if(partOfSpeech.charAt(0) == 'o' || partOfSpeech.charAt(0) == 'O'){
                System.out.println("Enter an " + partOfSpeech + ":");
            }
            else if(partOfSpeech.charAt(0) == 'u' || partOfSpeech.charAt(0) == 'U'){
                System.out.println("Enter an " + partOfSpeech + ":");
            }
            else{
                System.out.println("Enter a " + partOfSpeech + ":");
            }
            storyLine = Madlib.substituteWord(storyLine, Madlib.inputString());
        }
        return storyLine;
    }
    public static String wordInsideBrackets(String storyLine){
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
    public static void playMadlibs(String fullStory[]){
        System.out.println("Welcome to Madlibs. Game created by Emil Jiang");
        for(int line = 0; line<fullStory.length; line++){
            fullStory[line] = queryReplace(fullStory[line]);
        }
        for(int i =0; i< fullStory.length; i++){
            System.out.println(fullStory[i]);
        }
    }
    public static void main(String[] args){

        //substituteWord Testing
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

        //WordInsideBrackets
        //Section 2 Test case 1
        storyLine = "I like to <verb> on the beach";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + wordInsideBrackets(storyLine) + "\n");

        //Section 2 Test case 2
        storyLine = "I like <plural noun> that are fluffy";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + wordInsideBrackets(storyLine) + "\n");

        //Section 2 Test case 3
        storyLine = "";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + wordInsideBrackets(storyLine) + "\n");

        //Section 2 Test case 4
        storyLine = "I like to eat dumplings";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + wordInsideBrackets(storyLine) + "\n");

        //queryReplace Testing
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

        //A and An testing
        //Section 4 Test case 1
        storyLine = "The refrigerator is very <adjective>";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 4 Test case 2
        storyLine = "During the <event>, I was laughing the whole time";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 4 Test case 3
        storyLine = "<Interjection>, I am finally home";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 4 Test case 4
        storyLine = "<Unique Name> was bullied for her beutiful name";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 4 Test case 5
        storyLine = "The cat always bothered the dog with a <object>";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Section 4 Test case 6
        storyLine = "<Plural noun> are the worst";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Setion 4 Test case 7
        storyLine = "I have a hate-love relationship with my <noun>";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n");

        //Setion 4 Test case 8
        storyLine = "I am <verb> away from the police";
        System.out.println("storyline: " + storyLine);
        System.out.println("method returns: " + queryReplace(storyLine) + "\n"); 

        //Section 5 test case 1
        String [] storyLineArray = new String[]{"A vacation is when you take a trip to some <adjective> place with your <adjective> family",
                "Usually you go to some place that is near a/an <noun> or up a/an <noun>.",
                "A good vacation place is one where you can ride <plural noun> or play <game> or go hunting for <plural noun>.",
                "I like to spend my time <verb + ing>.",
                "When parents go on a vacations, they spend their time eating three <plural noun> a day, and fathers play golf and mothers sit around <verb + ing>",
                "Last summer, my little brother fell in a/an <noun> and got poisin <plant> all over his <part of body>."};
        System.out.println("method returns: ");
        playMadlibs(storyLineArray);
    }
}
