import java.awt.event.*;
import java.util.ArrayList;

public class ButtonActionListener implements ActionListener{

    public static Hash hash = new Hash();
    public static int numberOfAttempts;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("convertToMd5")){
            GUI.md5Output_txtf.setText(hash.generateMD5(GUI.keywordInput_txtf.getText()));
            // System.out.println(hash.generateMD5(GUI.keywordInput_txtf.getText()));
        } else if (e.getActionCommand().equals("convertToKeyword")){
            
            numberOfAttempts = 0;

            ArrayList<Character> charsetLowercase = new ArrayList<Character>();
            ArrayList<Character> charsetUppercase = new ArrayList<Character>();
            ArrayList<Character> charsetBothcase = new ArrayList<Character>();
            
            for (char c = 'a'; c <= 'z'; c++) {
                charsetLowercase.add(c);
                charsetBothcase.add(c);
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                charsetUppercase.add(c);
                charsetBothcase.add(c);
            }

            int keywordCharCount = Integer.parseInt(GUI.keywordCharCount_txtf.getText());

            if (GUI.lowercase_radio.isSelected()){
                words(charsetLowercase, keywordCharCount);
            } else if (GUI.uppercase_radio.isSelected()){
                words(charsetUppercase, keywordCharCount);
            } else if (GUI.bothcase_radio.isSelected()) {
                words(charsetBothcase, keywordCharCount);
            }

        }
    }

    public static void words(ArrayList<Character> charset, int n) {
        for(int i = n; i <= n; ++i) {
            wordsRecursive("", charset, i);
        }
     }
     
    public static void wordsRecursive(String base, ArrayList<Character> charset, int n) {
        if(n == 0) {
            // System.out.println(base);
            numberOfAttempts++;
            if (hash.generateMD5(base).equals(GUI.md5Input_txtf.getText())){
                GUI.keywordOutput_txtf.setText(base);
                GUI.numberOfAttempts_txtf.setText(String.valueOf(numberOfAttempts));
                System.out.println(base);
            }
        } else {
            for(int i = 0; i < charset.size(); i++) {
                wordsRecursive(base + charset.get(i), charset, n - 1);
            }
        }
    }

    // public static void words(char min, char max, int n) {
    //     for(int i = n; i <= n; ++i) {
    //         wordsRecursive("", min, max, i);
    //     }
    //  }
     
    // public static void wordsRecursive(String base, char min, char max, int n) {
    //     if(n == 0) {
    //         if (base.equals("aaa")){
    //             System.out.println(base);
    //         }
    //     } else {
    //         for(char c = min; c <= max; ++c) {
    //             wordsRecursive(base + c, min, max, n - 1);
    //         }
    //     }
    // }


    /* 
    Old function which results in heap space error because combinations are stored in ArrayList


    public ArrayList<String> getWords(ArrayList<Character> charset, int wordLength) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("");
        int start = 0;
        for(int currentLength = 1; currentLength <= wordLength; currentLength++) {
           int ArrayLength = words.size();
           for(int i = start; i < ArrayLength; i++) {
              for(int j = 0; j < charset.size(); j++) {
                words.add(words.get(i) + charset.get(j));
              }
           }
           start = ArrayLength;
        }
        return words;
    }

    public String checkWords(ArrayList<String> words) {
        Hash hash = new Hash();
        String keyword = "Not found";
        for (int i = 0; i < words.size(); i++){
            if (hash.generateMD5(words.get(i)).equals(GUI.md5Input_txtf.getText())){
                keyword = words.get(i);
                break;
            }
        }
        return keyword;
    } */
  
}


