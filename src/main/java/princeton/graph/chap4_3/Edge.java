package princeton.graph.chap4_3;

public class Edge implements Comparable<Edge> {

  private int v, w;
  private double weight;

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int either() {
    return v;
  }

  public int other(int key) {
    if (key == v) return w;
    else if (key == w) return v;
    else return Integer.MIN_VALUE;
  }

  public double weight() {
    return weight;
  }

  @Override
  public int compareTo(Edge other) {
    return Double.compare(weight, other.weight);
  }

  @Override
  public String toString() {
    return String.format("[%-2d : %-2d - %-4.02f]", v, w, weight);
  }
}
