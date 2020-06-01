package princeton.fundamentals.chap1_5;

import static princeton.graph.chap4_1.PrintUtil.*;

public class PathCompression {
  int parent[];
  int count;

  public PathCompression(int totalELements) {
    parent = new int[totalELements];
    count = totalELements;
    for (int i = 0; i < totalELements; i++) parent[i] = i;
  }

  public int find(int key) {
    if (key == parent[key]) return key;
    parent[key] = find(parent[key]);
    return parent[key];
  }

  public boolean isConnected(int key1, int key2) {
    return find(key1) == find(key2);
  }

  public void union(int key1, int key2) {
    int p1 = find(key1);
    int p2 = find(key2);

    if (p1 == p2) return;

    parent[p1] = p2;

    count--;
  }

  public int count() {
    return count;
  }
}
