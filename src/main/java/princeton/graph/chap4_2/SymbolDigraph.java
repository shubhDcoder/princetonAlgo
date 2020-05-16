package princeton.graph.chap4_2;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class SymbolDigraph {
    Map<String, Integer> map;
    String[] keys;
    DiGraph graph;

    public SymbolDigraph(String file, String delimiter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));

        map = new HashMap<>();

        String line;
        while((line = reader.readLine()) != null) {
            String[] vrtx = line.split(delimiter);
            for(String v : vrtx)
                map.putIfAbsent(v, map.size());
        }

        keys = new String[map.size()];
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            keys[entry.getValue()] = entry.getKey();
        }

        graph = new DiGraph();
        graph.initGraph(map.size());
        reader = new BufferedReader(new FileReader(new File(file)));
        while((line = reader.readLine()) != null) {
            String[] vrtx = line.split(delimiter);
            for(int i = 1; i < vrtx.length; i++)
                graph.addEdge(map.get(vrtx[0]), map.get(vrtx[i]));
        }
    }

    public boolean isThere(String key) {
        return map.containsKey(key);
    }

    public Integer getIndex(String key) {
        return isThere(key) ? map.get(key) : null;
    }

    public String getKey(int index) {
        return keys[index];
    }

    public DiGraph getGraph() {
        return graph;
    }

}