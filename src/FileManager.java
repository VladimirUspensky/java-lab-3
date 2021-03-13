import java.io.*;
import java.util.HashMap;

public class FileManager {
    private String fileInName;
    private String fileOutName;

    /**
     * Class constructor
     * Saves name of the src file and name of the dst file
     * @param fileInName src file name
     * @param fileOutName dst file name
     */
    public FileManager(String fileInName, String fileOutName) {
        setFileInName(fileInName);
        setFileOutName(fileOutName);
    }

    public String getFileInName() {
        return fileInName;
    }

    public void setFileInName(String fileInName) {
        this.fileInName = fileInName;
    }

    public String getFileOutName() {
        return fileOutName;
    }

    public void setFileOutName(String fileOutName) {
        this.fileOutName = fileOutName;
    }

    /**
     * Creates HashMap, where keys are symbols, values - number of letters
     * Writes filtered data into destination file
     * @return true if all went well, false if file path is incorrect
     */
    public boolean filterInputFile() {
        HashMap<Character, Integer> symbols = new HashMap<Character, Integer>();
        try {
            FileReader reader = new FileReader(this.fileInName);
            FileWriter writer = new FileWriter(this.fileOutName);
            int symbol;
            int cnt;
            while ((symbol = reader.read()) != -1) {
                char ch_symbol = Character.toLowerCase((char) symbol);
                if (isLatin(ch_symbol)) {
                    if (symbols.containsKey(ch_symbol)) {
                        cnt = symbols.get(ch_symbol);
                        symbols.put(ch_symbol, ++cnt);
                    } else {
                        symbols.put(ch_symbol, 1);
                    }
                }
            }
            for (Character key: symbols.keySet()) {
                writer.write(key + " - " +  symbols.get(key) + '\n');
            }
            reader.close();
            writer.close();
        } catch (IOException exception) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the symbol is Latin
     * @param symbol given symbol
     * @return true if symbol is Latin, false if not
     */
    private boolean isLatin(char symbol) {
        return (Character.UnicodeBlock.of(symbol).equals(Character.UnicodeBlock.BASIC_LATIN)
                && !Character.isDigit(symbol) && Character.isAlphabetic(symbol));
    }

}
