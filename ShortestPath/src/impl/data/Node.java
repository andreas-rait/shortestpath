
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
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  ara
 * @version $Revision$
 */

public class Node {
  private final String identifier;
  private List<Edge> neighbours;
  private boolean shortestPathKnown;
  private int shortestDistance;
  private Node neighbourOnShortestPath;
  
  public Node(String identifier, List<Edge> neighbours){
    this.identifier = identifier;
    this.neighbours = neighbours;
  }

  public Node(String identifier) {
    this.identifier = identifier;
    this.neighbours =  new ArrayList<>();
  }

  public Integer getWeight() {
    // TODO Auto-generated method stub
    return null;
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

  public String getIdentifier() {
    return identifier;
  }

  public List<Edge> getNeighbours() {
    return neighbours;
  }
}


//---------------------------- Revision History ----------------------------
//$Log$
//
