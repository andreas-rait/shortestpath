/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andreas
 */
public class Edge {
	private Vertex neighbour;
	private int distance;
	
	public Edge(Vertex neighbour, int distance) {
		this.neighbour = neighbour;
		this.distance = distance;
	}
	
	public Vertex getNeighbour() {
		return neighbour;
	}

	public int getDistance() {
		return distance;
	}

}
