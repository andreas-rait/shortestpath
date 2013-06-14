/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package test.strategy;

import impl.data.Field;
import impl.data.Parser;
import impl.data.Path;
import impl.strategy.DijkstraStrategy;
import impl.strategy.ISearchPathStrategy;

import org.junit.Test;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is important, because it is
 * used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 */

public class StupidStrategyTest {


  @Test
  public void test() {
    String fieldString = "0,2,3,6\n0,8,5,7\n1,2,0,8";

    Field field = Parser.parseField(fieldString);

    ISearchPathStrategy s = new DijkstraStrategy();
    Path p = s.getShortestPath(field);
    System.out.println(p.printPath());
  }

}

//---------------------------- Revision History ----------------------------
//$Log$
//
