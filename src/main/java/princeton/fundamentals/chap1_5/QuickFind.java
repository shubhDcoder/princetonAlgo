package princeton.fundamentals.chap1_5;

import java.util.Arrays;
import static princeton.graph.chap4_1.PrintUtil.*;

public class QuickFind {
    int[] elements;
    int count;

    public QuickFind(int totalELements) {
        elements = new int[totalELements];
        for(int i = 0; i < totalELements; i++) elements[i] = i;
        count = totalELements;
    }

    public int count() {
        return count;
    }

    public int find(int key) {
        return elements[key];
    }

    public boolean isConnected(int key1, int key2) {
        return find(key1) == find(key2);
    }

    public void union(int key1, int key2) {
        int p1 = find(key1);
        int p2 = find(key2);

        if(p1 == p2) return;

        for(int i = 0; i < elements.length; i++)
            if(elements[i] == p1)
                elements[i] = p2;
        count--;
        syso("union : " + key1 + ", " + key2);
        syso(Arrays.toString(elements) + ", count => " + count);
    }
}