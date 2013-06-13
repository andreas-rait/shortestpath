/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;



public class Vertex {
	private String name;
	private boolean shortestPathKnown;
	private int shortestDistance;
	private Vertex neighbourOnShortestPath;
	private ArrayList<Edge> neighbours;
	
	public Vertex(String name) {
		this.name = name;
		shortestPathKnown = false;
		shortestDistance = Integer.MAX_VALUE;
		neighbourOnShortestPath = null;
		neighbours = new ArrayList<Edge>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isShortestPathKnown() {
		return shortestPathKnown;
	}
	
	public void setShortestPathKnown(boolean shortestPathKnown) {
		this.shortestPathKnown = shortestPathKnown;
	}
	
	public int getShortestDistance() {
		return shortestDistance;
	}
	
	public void setShortestDistance(int shortestDistance) {
		this.shortestDistance = shortestDistance;
	}
	
	public Vertex getNeighbourOnShortestPath() {
		return neighbourOnShortestPath;
	}
	
	public void setNeighbourOnShortestPath(Vertex neighbourOnShortestPath) {
		this.neighbourOnShortestPath = neighbourOnShortestPath;
	}
	
	public ArrayList<Edge> getNeighbours() {
		return neighbours;
	}
	
	public void setNeighbours(ArrayList<Edge> neighbours) {
		this.neighbours = neighbours;
	}
	
	
}
