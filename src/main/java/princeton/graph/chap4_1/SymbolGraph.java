package princeton.graph.chap4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymbolGraph {

  Graph graph;
  String[] keys;
  Map<String, Integer> mapper;

  public SymbolGraph(String fileName, String delimiter) throws FileNotFoundException {
    mapper = new HashMap<>();
    Scanner scanner = new Scanner(new File(fileName));
    // creation of mapper
    while (scanner.hasNextLine()) {
      String[] splittedLine = scanner.nextLine().split(delimiter);
      for (String name : splittedLine)
        if (mapper.containsKey(name) == false) mapper.put(name, mapper.size());
    }
    // creation of keys
    keys = new String[mapper.size()];
    for (String name : mapper.keySet()) keys[mapper.get(name)] = name;

    // initialize graph
    graph = new Graph(keys.length);
    scanner = new Scanner(new File(fileName));
    while (scanner.hasNextLine()) {
      String[] splittedLine = scanner.nextLine().split(delimiter);
      for (int i = 1; i < splittedLine.length; i++) {
        graph.addEdge(indexOf(splittedLine[0]), indexOf(splittedLine[i]));
      }
    }
    scanner.close();
  }

  public Graph getGraph() {
    return graph;
  }

  public String name(int ind) {
    return keys[ind];
  }

  public int indexOf(String key) {
    return isThere(key) ? mapper.get(key) : -1;
  }

  public boolean isThere(String key) {
    return mapper.containsKey(key);
  }
}
