
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.data;

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

public class Path {

  private final List<Node> nodes;

  
  public Path(List<Node> nodes){
    this.nodes = nodes;
  }
  
  public Integer getWeight(){
    Integer sum = 0;
    for(Node n :  nodes){
      sum += n.getWeight();
    }
    
    return sum;
  }
  
}


//---------------------------- Revision History ----------------------------
//$Log$
//
