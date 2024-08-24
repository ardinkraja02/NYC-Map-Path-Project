import java.util.PriorityQueue;

public class main {

	public static void main(String[] args) {

		Node met = new Node("The Met");
		Node nat = new Node("Mueseum Of Natural History");
		Node time = new Node("Times Square");
		Node grand = new Node("Grand Central Station");
		Node chry = new Node("Chrysler Building");
		Node penn = new Node("Penn Station");
		Node empire = new Node("Empire State Building");
		Node flat = new Node("Flat Iron Building");
		Node pace = new Node("1 Pace Plaza");
		Node bridge = new Node("Brooklyn Bridge");
		Node will = new Node("163 Williams Street");

		met.addNeighbor(10, 30, 10, grand);

		nat.addNeighbor(8, 20, 8, time);

		time.addNeighbor(8, 20, 8, nat);
		time.addNeighbor(1, 4, 2, penn);
		time.addNeighbor(1, 4, 2, empire);
		time.addNeighbor(2, 2, 2, grand);

		grand.addNeighbor(2, 2, 2, time);
		grand.addNeighbor(10, 30, 10, met);
		grand.addNeighbor(1, 1, 1, chry);
		grand.addNeighbor(7, 5, 2, pace);

		chry.addNeighbor(1, 1, 1, grand);

		penn.addNeighbor(1, 4, 2, time);
		penn.addNeighbor(1, 3, 1, empire);

		empire.addNeighbor(1, 4, 2, time);
		empire.addNeighbor(1, 3, 1, penn);
		empire.addNeighbor(2, 3, 2, flat);

		flat.addNeighbor(2, 3, 2, empire);
		flat.addNeighbor(3, 5, 3, will);

		pace.addNeighbor(7, 5, 2, grand);
		pace.addNeighbor(1, 1, 1, will);
		pace.addNeighbor(1, 1, 1, bridge);

		will.addNeighbor(3, 5, 3, flat);
		will.addNeighbor(1, 1, 1, pace);
		will.addNeighbor(1, 2, 1, bridge);

		bridge.addNeighbor(1, 1, 1, pace);
		bridge.addNeighbor(1, 2, 1, will);

		path(met, bridge, 0);
	}

	public static void path(Node start, Node end, int pathType) {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		start.cost = 0;
		pq.add(start);
		int cost;

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (current == end)
				break;

			for (Edge e : current.neighbors) {

				if (pathType == 0) {
					cost = current.cost + e.distance;
				}
				if (pathType == 1) {
					cost = current.cost + e.time;
				}
				if (pathType == 2) {
					cost = current.cost + e.money;
				} else {
					break;
				}

				Node n = e.n;
				if (cost > n.cost)
					continue;
				n.cost = cost;
				n.prev = current;

				pq.remove(n);
				pq.add(n);
			}

		}
		printPath(end);
	}

	public static void printPath(Node n) {
		if (n == null)
			return;
		printPath(n.prev);
		System.out.println(n.name);
	}
}
