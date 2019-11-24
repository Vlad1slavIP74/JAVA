package LAB3;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*; 
import java.util.Map;
import java.io.FileReader;
import java.util.Scanner;

// Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.

public class LAB3 {
    String[] words;
    public static void main(String[] args)  throws IOException  {
        LAB3 lab3 = new LAB3();
        try {
            String location = lab3.getLocation();
            Scanner fileInOneString = lab3.readFile(location);    
            int countWords = lab3.getCount();
            String[] words = lab3.getWords(countWords);
            HashMap<String, Integer> result = lab3.workWithFile(fileInOneString, words);
            lab3.display(result);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "title for Errorr",JOptionPane.PLAIN_MESSAGE);
            System.exit(1); 
        }    
    }
    //Read file  
    public Scanner readFile(String fileName) throws IOException {
        FileReader fr= new FileReader(fileName);   
        Scanner scan = new Scanner(fr);
        return scan;
    }

    public String getLocation() {
        return JOptionPane.showInputDialog("Enter path");
    }

    public int getCount() {
        String count;
        int parseCount;

        count = JOptionPane.showInputDialog("Enter words count");
        parseCount = Integer.parseInt(count);
        
        try {
            if (parseCount <= 0) {
                throw new Exception("Enter size > 0");
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "title for Error",JOptionPane.PLAIN_MESSAGE);
            System.exit(1); 
        }
        
        return parseCount;
    }

    public String[] getWords(int size) {
        String[] listWords = new String[size];
        for (int i = 0; i < size; i++) {
            listWords[i] = JOptionPane.showInputDialog("Enter words for Search");
        }
        return listWords;
    }

    public void buildHashMap(String[] oneLine, HashMap<String, Integer> myHashMap, String[] words) {
        for (String s : oneLine) {
            for (int i = 0; i < words.length; i++) {    
                if (Arrays.asList(s.split(" ")).contains(words[i])) {
                    int newValue = myHashMap.get(words[i]) + 1;
                    myHashMap.put(words[i], newValue);
                }
            }
        }
    }

    public HashMap<String, Integer> workWithFile(Scanner scan, String[] words) {
        String[] oneLine = null;
        // String[] words = {"Lorem", "ipsum"};
        HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++)
            myHashMap.put(words[i], 0);

        while (scan.hasNextLine()) {
            this.buildHashMap(scan.nextLine().split("[!?.:]+"), myHashMap, words); //([.!?])([\\s\\n])([A-Z]*)
        }
        scan.close();
        for (int i = 0; i < words.length; i++) { 
            System.out.println(myHashMap.get(words[i]));
        }
        return myHashMap;
    }

    public void display (HashMap<String, Integer> dataToDisplay) {
        JFrame window = new JFrame("title");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(200, 250);
        window.setLocationRelativeTo(null);
        
        int size = dataToDisplay.size();
        Object[][] word = new Object [size][size];
        Object[] count = {"Words", "Count"};
        int i = 0;
        for(Map.Entry<String, Integer> item : dataToDisplay.entrySet()) {
            word[i][0] = item.getKey();
            word[i][1] = item.getValue();         
        //  count[i] = "";
         i++;
        }

        JTable table = new JTable(word, count);
        window.add(new JScrollPane(table));
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}