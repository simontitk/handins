import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class ProfanityFilter {

    private static HashSet<String> createSwearwords(String line) {

        HashSet<String> swearWords = new HashSet<>();
        if (!line.isEmpty()) {
            for (String word: line.split(" ")) {
                swearWords.add(word.toLowerCase());
            }
        
        }
         return swearWords;
    }


    private static boolean isInPunctuation(char c) {
    
        HashSet<Character> punctuationCharacters = new HashSet<>(Arrays.asList(',', '.', '!', '?'));
        return punctuationCharacters.contains(c);
    }


    private static boolean isInSwearWords(String word, HashSet<String> swearWords) {

        int len = word.length();
        char lastChar = word.charAt(len-1);

        if (isInPunctuation(lastChar)) {
            word = word.substring(0, len-1);
        }
        return swearWords.contains(word.toLowerCase());        
    }


    private static String replaceWord(String word) {

        char[] replaceCharacters = {'*', '&', '#', '$', '%'};
        int len = word.length();
        char lastChar = word.charAt(len-1);
        
        String newWord = "";
        for (int i=0; i<len; i++) {
            newWord += replaceCharacters[(i % 5)];
        }
        if (isInPunctuation(lastChar)) {
            newWord = newWord.substring(0, len-1) + lastChar;
        }
        return newWord;
    }

    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashSet<String> swearWords = createSwearwords(scn.nextLine());
       
        while (scn.hasNext()) {

            String line = scn.nextLine();
            String result = "";

            if (!line.isEmpty()) {

                for (String word: line.split(" ")) {
                    
                    if (isInSwearWords(word, swearWords)) {
                        word = replaceWord(word);
                    }
                    result = result + word + " ";
                } 
            }
            System.out.println(result.trim());
        }
        scn.close();
    }
      
}

