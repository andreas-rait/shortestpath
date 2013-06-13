
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
import impl.data.Node;
import impl.data.Path;

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

public class DijkstraStrategy implements ISearchPathStrategy {

  @Override
  public Path getShortestPath(List<Node> field, Node start, Node end) {
    start.setShortestDistance(0);
    start.setShortestPathKnown(true);   
   
    List<Node> temp = new ArrayList<Node>();
    
    temp.add(start);

    while(temp.size() != 0) {
      Node helpNode = new Node("dummy");
      for(Node tempNode : temp) {
        if(tempNode.getShortestDistance() < helpNode.getShortestDistance()) {
          helpNode = tempNode;
          //System.out.println("Help: " + helpNode.getName());
        }
      }
      
      //System.out.println("Size davor: " + temp.size());
      temp.remove(helpNode);
      //System.out.println("Size danach: " + temp.size());
      
      if(helpNode.equals(end)) {
        break;
      } else {
        helpNode.setShortestPathKnown(true);
        
        //System.out.println("Komme hier her");
        for(Edge e : helpNode.getNeighbours() ) {
          if(!e.getNeighbour().isShortestPathKnown()) {
            if((helpNode.getShortestDistance()+e.getDistance()) < e.getNeighbour().getShortestDistance()) {
              e.getNeighbour().setNeighbourOnShortestPath(helpNode);
              e.getNeighbour().setShortestDistance(helpNode.getShortestDistance()+e.getDistance());
              
              temp.add(e.getNeighbour());
            }
          }
        }
        
      }
    }
    
    
    return null;
  }

}


//---------------------------- Revision History ----------------------------
//$Log$
//
