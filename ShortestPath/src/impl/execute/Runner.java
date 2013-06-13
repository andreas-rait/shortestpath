/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.execute;

import java.util.List;

import impl.data.Node;
import impl.strategy.DijkstraStrategy;
import impl.strategy.ISearchPathStrategy;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 */

public class Runner {
  public static void main(String[] args) {
    String fieldString = "0,2,3,6\n0,8,5,7\n1,2,0,8";
    
    
    List<Node> nodes;
    
    ISearchPathStrategy s = new DijkstraStrategy();
    s.getShortestPath(field, start, end)
  }

  private List<Node> parseField(String fieldString) {
    String[] lines = fieldString.split("\n");
    for (String line : lines) {
      String[] numbers = line.split(",");
      for (String number : numbers) {
        int x = Integer.parseInt(number);
        new Node()
      }
    }
    return null;
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
