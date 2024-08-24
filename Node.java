
import java.util.ArrayList;

public class Node implements Comparable<Node>{

	String name;
	ArrayList<Edge> neighbors;
	
	int cost;
	Node prev;
	
	public Node (String name) {
		this.name = name;
		this.neighbors = new ArrayList<Edge>();
		this.cost = Integer.MAX_VALUE;
		this.prev = null;
	}
	
	public void addNeighbor(int distance,int time, int money, Node n) {
		Edge e = new Edge(distance, time, money, n);
		neighbors.add(e);
	}
	
	public int compareTo(Node other) {
			return Integer.compare(cost, other.cost);
	
	}
}
