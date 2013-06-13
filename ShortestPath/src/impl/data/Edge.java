package impl.data;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ara
 */
public class Edge {
	private Node neighbour;
	private int distance;
	
	public Edge(Node neighbour, int distance) {
		this.neighbour = neighbour;
		this.distance = distance;
	}
	
	public Node getNeighbour() {
		return neighbour;
	}

	public int getDistance() {
		return distance;
	}

}
