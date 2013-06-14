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
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 */

public class Path {

  private final List<Node> nodes;

  public Path(List<Node> nodes) {
    this.nodes = nodes;
  }

  public static String mkString(List<Node> list, String start, String delimiter, String end) {
    StringBuffer sb = new StringBuffer(list.get(list.size() - 1).toString());
    for (int i = list.size() - 2; i >= 0; i--) {
      sb.append(delimiter + list.get(i));
    }
    return start + sb.toString() + end;
  }

  public String printPath() {

    return mkString(nodes, "Path: ", " -> ", " found!");
  }
}

//---------------------------- Revision History ----------------------------
//$Log$
//
