
import java.util.*;

public class Graph<T> {

  private HashMap<Long, Vertex<T>> vertices;
  private ArrayList<Edge<T>> edges;
  private boolean isDirected;

  Graph(boolean isDirected) {
    this.vertices = new HashMap<Long, Vertex<T>>();
    this.edges = new ArrayList<Edge<T>>();
    this.isDirected = isDirected;
  }

  public HashMap<Long, Vertex<T>> getVertices() {
    return this.vertices;
  }

  public ArrayList<Edge<T>> getEdges() {
    return this.edges;
  }

  public Vertex<T> getVertex(long id) {
    return this.vertices.get(id);
  }

  public void addVertex(long id) {
    if(this.vertices.containsKey(id)) {
      return;
    }
    Vertex<T> temp = new Vertex<T>(id);
    this.vertices.put(id, temp);
  }

  public void addEdge(long id1, long id2) {
    addEdge(id1, id2, 0);
  }

  public void addEdge(long id1, long id2, int weight) {
    Vertex<T> v1 = null;
    if(this.vertices.containsKey(id1)){
      v1 = this.vertices.get(id1);
    }else{
      v1 = new Vertex<T>(id1);
      this.vertices.put(id1, v1);
    }
    Vertex<T> v2 = null;
    if(this.vertices.containsKey(id2)){
      v2 = this.vertices.get(id2);
    }else{
      v2 = new Vertex<T>(id2);
      this.vertices.put(id2, v2);
    }

    Edge<T> e = new Edge<T>(v1, v2, weight, this.isDirected);
    this.edges.add(e);
    v1.addAdjacentVertex(e, v2);
    if(!isDirected){
      v2.addAdjacentVertex(e, v1);
    }
  }

  public void setVertexData(long id, T data){
        if(this.vertices.containsKey(id)){
            Vertex<T> v = this.vertices.get(id);
            v.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> e : getEdges()){
            buffer.append(e.getV1() + " " + e.getV2() + " " + e.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }

  public static void main(String[] args) {
    Graph<Integer> g = new Graph<Integer>(false);

    g.addVertex(111);
    g.setVertexData(111, 1);
    g.addVertex(222);
    g.setVertexData(222, 2);
    g.addVertex(333);
    g.setVertexData(333, 3);
    g.addVertex(444);
    g.setVertexData(444, 4);
    g.addVertex(555);
    g.setVertexData(555, 5);
    g.addVertex(666);
    g.setVertexData(666, 6);

    g.addEdge(111,222);
    g.addEdge(111,333);
    g.addEdge(111,555);
    g.addEdge(222,444);
    g.addEdge(222,555);
    g.addEdge(333,444);
    g.addEdge(444,555);
    g.addEdge(555,666);

    System.out.println(g.toString());

  }

}

class Edge<T> {

  int weight;
  Vertex<T> v1;
  Vertex<T> v2;
  boolean isDirected;

  Edge(Vertex v1, Vertex v2) {
    this.v1 = v1;
    this.v2 = v2;
  }

  Edge(Vertex v1, Vertex v2, boolean isDirected) {
    this.v1 = v1;
    this.v2 = v2;
    this.isDirected = isDirected;
  }

  Edge(Vertex v1, Vertex v2, int weight, boolean isDirected) {
    this.v1 = v1;
    this.v2 = v2;
    this.weight = weight;
    this.isDirected = isDirected;
  }

  public int getWeight() {
    return this.weight;
  }

  public Vertex<T> getV1() {
    return this.v1;
  }

  public Vertex<T> getV2() {
    return this.v2;
  }

  public boolean isDirected() {
    return this.isDirected;
  }

  public String toString() {
    return "Edge (isDirected: " + this.isDirected + ", Vertex1: " + this.v1
      + ", Vertex2: " + this.v2 + ", weight: " + this.weight + ")";
  }

  @Override
  public boolean equals(Object o) {
    if(this == o)
      return true;
    else if(o == null)
      return false;
    else if(this.getClass() != o.getClass())
      return false;
    Edge temp = (Edge) o;
    if(this.v1 == temp.v1 && this.v2 == temp.v2) {
      return true;
    }
    return false;
  }

}

class Vertex<T> {

    long id;
    private T data;
    private ArrayList<Edge<T>> edges = new ArrayList<Edge<T>>();
    private ArrayList<Vertex<T>> adjacent = new ArrayList<Vertex<T>>();

    Vertex(long id) {
      this.id = id;
    }

    public long getId() {
      return this.id;
    }

    public T getData() {
      return this.data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public ArrayList<Edge<T>> getEdges() {
      return this.edges;
    }

    public ArrayList<Vertex<T>> getAdjacent() {
      return this.adjacent;
    }

    public void addAdjacentVertex(Edge e, Vertex v) {
      edges.add(e);
      adjacent.add(v);
    }

    public String toString() {
      return "" + this.data;
    }

    @Override
    public boolean equals(Object o) {
      if(this == o)
        return true;
      else if (o == null)
        return false;
      else if (this.getClass() != o.getClass())
        return false;
      Vertex temp = (Vertex) o;
      if(this.id == temp.id)
        return true;
      return false;
    }

}
