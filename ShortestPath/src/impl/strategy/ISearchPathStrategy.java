
/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.strategy;

import impl.data.Field;
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
  
  public Path getShortestPath(Field field);  
}


//---------------------------- Revision History ----------------------------
//$Log$
//
