/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is
 * important, because it is used summary in the package overview pages.<br />
 * <br />
 * 
 * 
 * @author ara
 * @version $Revision$
 */

public class Node {
	private List<Edge> neighbours;
	private boolean shortestPathKnown;
	private int shortestDistance;
	private Node neighbourOnShortestPath;
	private final Integer weight;

	public Node(Integer weight) {
		this.weight = weight;
		this.neighbours = new ArrayList<>();
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

	public Node getNeighbourOnShortestPath() {
		return neighbourOnShortestPath;
	}

	public void setNeighbourOnShortestPath(Node neighbourOnShortestPath) {
		this.neighbourOnShortestPath = neighbourOnShortestPath;
	}

	public List<Edge> getNeighbours() {
		return neighbours;
	}

	public Integer getWeight() {
		return weight;
	}

	public void addNeighbour(Node neighbour) {
		neighbours.add(new Edge(neighbour, neighbour.getWeight()));
	}

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
