package princeton.fundamentals.chap1_5;

public class QuickWeightedUnion {
  int parent[];
  int size[];
  int count;

  public QuickWeightedUnion(int totalElements) {
    count = totalElements;
    size = new int[totalElements];
    parent = new int[totalElements];
    for (int i = 0; i < totalElements; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int find(int key) {
    while (key != parent[key]) key = parent[key];
    return key;
  }

  public boolean isConnected(int key1, int key2) {
    return find(key1) == find(key2);
  }

  public int count() {
    return count;
  }

  public void union(int key1, int key2) {
    int p1 = find(key1);
    int p2 = find(key2);

    if (p1 == p2) return;

    if (size[p1] < size[p2]) {
      parent[p1] = p2;
      size[p2] = size[p2] + size[p1];
    } else {
      parent[p2] = p1;
      size[p1] = size[p1] + size[p2];
    }

    // syso("union : " + key1 + ", " + key2);
    // syso(Arrays.toString(parent) + ", count => " + count);

    count--;
  }
}
