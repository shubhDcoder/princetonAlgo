package princeton.fundamentals.chap1_5;

public class QuickUnion {
    int elements[];
    int count;

    public QuickUnion(int totalELements) {
        count = totalELements;
        elements = new int[totalELements];
        for(int i = 0; i < elements.length; i++) elements[i] = i;
    }

    public int find(int key) {
        while(key != elements[key]) key = elements[key];
        return key;
    }

    public boolean connected(int key1, int key2) {
        return find(key1) == find(key2);
    }

    public void union(int key1, int key2) {
        int p1 = find(key1);
        int p2 = find(key2);
        if(p1 == p2) return;

        elements[p1] = p2;
        count--;
    }

    public int count() {
        return count;
    }
}