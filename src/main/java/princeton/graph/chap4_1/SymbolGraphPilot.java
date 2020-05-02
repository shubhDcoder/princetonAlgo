import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraphPilot {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "movies.txt";
        String delimiter = "/";

        SymbolGraph symbolGraph = new SymbolGraph(fileName, delimiter);
        Graph graph = symbolGraph.getGraph();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String source = scanner.nextLine();
            int temp = symbolGraph.indexOf(source);
            if(temp != -1)
                for (int adj : graph.adj(temp)) {
                    PrintUtil.syso("\t" + symbolGraph.name(adj));
                }
            else 
                PrintUtil.syso("Nothing found!");
        }
        scanner.close();
    }
}