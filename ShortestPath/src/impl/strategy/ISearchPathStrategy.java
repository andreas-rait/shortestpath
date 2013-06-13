
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.strategy;

import java.util.List;

import impl.data.Node;
import impl.data.Path;



/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important,
 * because it is used summary in the package overview pages.<br />
 * <br />
 *
 *
 * @author  ara
 * @version $Revision$
 */

public interface ISearchPathStrategy {
  
  public Path getShortestPath(List<Node> field, Node start, Node end);  
}


//---------------------------- Revision History ----------------------------
//$Log$
//
