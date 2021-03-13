import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the path to the source file");
        String fileInName = reader.readLine();
        System.out.println("Enter the path to the dest file");
        String fileOutName = reader.readLine();
        FileManager manager = new FileManager(fileInName, fileOutName);
        if (manager.filterInputFile()) {
            System.out.println("Done");
        } else {
            System.out.println("Path is incorrect");
        }
    }
}
