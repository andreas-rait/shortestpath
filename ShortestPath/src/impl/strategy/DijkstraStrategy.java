/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.strategy;

import impl.data.Edge;
import impl.data.Field;
import impl.data.Node;
import impl.data.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 */

public class DijkstraStrategy implements ISearchPathStrategy {

  @Override
  public Path getShortestPath(Field field) {
    field.getStart().setShortestDistance(0);
    field.getStart().setShortestPathKnown(true);

    List<Node> temp = new ArrayList<Node>();

    temp.add(field.getStart());

    while (temp.size() != 0) {
      Node helpNode = new Node(-1, -1, 0);
      helpNode.setShortestDistance(Integer.MAX_VALUE);
      for (Node tempNode : temp) {
        if (tempNode.getShortestDistance() < helpNode.getShortestDistance()) {
          helpNode = tempNode;
          // System.out.println("Help: " + helpNode.getName());
        }
      }

      // System.out.println("Size davor: " + temp.size());
      temp.remove(helpNode);
      // System.out.println("Size danach: " + temp.size());

      if (helpNode.equals(field.getEnd())) {
        break;
      } else {
        helpNode.setShortestPathKnown(true);

        System.out.println("Komme hier her" + helpNode.toString());
        for (Edge e : helpNode.getNeighbours()) {
          if (!e.getNeighbour().isShortestPathKnown()) {
            if ((helpNode.getShortestDistance() + e.getDistance()) < e.getNeighbour().getShortestDistance()) {
              e.getNeighbour().setNeighbourOnShortestPath(helpNode);
              e.getNeighbour().setShortestDistance(helpNode.getShortestDistance() + e.getDistance());

              temp.add(e.getNeighbour());
            }
          }
        }

      }
    }

    List<Node> nodes = new ArrayList<>();
    createPath(nodes, field.getEnd(), field.getStart());
    return new Path(nodes);
  }

  public void createPath(List<Node> pathNodes, Node n, Node end) {
    if (n.toString().equals(end.toString())) {
      pathNodes.add(n);
      return;
    }
    pathNodes.add(n);
    createPath(pathNodes, n.getNeighbourOnShortestPath(), end);
  }

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
