package princeton.graph.chap4_4;

public class DirectedEdge implements Comparable<DirectedEdge> {
  private int s, d;
  private double weight;

  public DirectedEdge(int s, int d, double weight) {
    this.s = s;
    this.d = d;
    this.weight = weight;
  }

  public int from() {
    return this.s;
  }

  public int to() {
    return this.d;
  }

  public double weight() {
    return this.weight;
  }

  @Override
  public int compareTo(DirectedEdge other) {
    return Double.compare(this.weight, other.weight);
  }

  @Override
  public String toString() {
    return String.format("[%-2d : %-2d - %-4.02f]", s, d, weight);
  }
}
