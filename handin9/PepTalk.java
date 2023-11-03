import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class PepTalk {

    public static ArrayList<String> splitToSyllables(String word) {

        Pattern p = Pattern.compile("[aeiouAEIOU]");
        Matcher m = p.matcher(word);
        ArrayList<String> syls = new ArrayList<>();
        ArrayList<String> vows = new ArrayList<>();
        ArrayList<String> cons = new ArrayList<>(Arrays.asList(p.split(word)));
        while (m.find()) {
                vows.add(m.group(0));
        }

        int i = 0;
        while (i < cons.size()) {
            String group = cons.get(i);
            String first = group.substring(0, group.length()/2);
            String second = group.substring(group.length()/2, group.length());

            // if it's the first consonant group, don't split it
            if (i==0) {
                syls.add(group+vows.get(i));
            }

            // if there are more consonant groups than vowels, then don't split the last one
            else if (i == vows.size()) {
                syls.set((i-1), syls.get(i-1)+group);
            }

            // split the consonant group, add the first half to the previous syllable and add the second half to the current
            else {
                syls.set((i-1), syls.get(i-1)+first);
                syls.add(second+vows.get(i));
            }

            i++;
        }

        // if there are any remanining vowels, add them as their own syllables
        while (i < vows.size()) {
            syls.add(vows.get(i));
            i++;
        }
        return syls;
    }
    

    public static ArrayList<String> peptizeSyllables(ArrayList<String> syls) {
        
        ArrayList<String> pepSyl = new ArrayList<>();

        Pattern p = Pattern.compile("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]*");
        for (String syl : syls) {  
            pepSyl.add(p.matcher(syl).replaceFirst("p").toLowerCase());
        }
        return pepSyl;
    }
   
    
    public static String buildPepWord(ArrayList<String> syllables, ArrayList<String> peptizedSyllables) {

        String pepWord = "";

        for (int i = 0; i < syllables.size(); i++) {
            pepWord += syllables.get(i) + peptizedSyllables.get(i);   
        }
        return pepWord;
    }

    
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String[] words = scn.nextLine().split(" ");
        String result = "";

        for (String word : words) {
            ArrayList<String> syls = splitToSyllables(word);
            ArrayList<String> pepSyls = peptizeSyllables(syls);
            String pepWord = buildPepWord(syls, pepSyls);
            result += pepWord + " ";
        }
       System.out.println(result.strip());
       scn.close();
    }
    
}
