/** 
 * Copyright 2013 SSI Schaefer PEEM GmbH. All Rights reserved. 
 * <br /> <br />
 * 
 * $Id$
 * <br /> <br />
 *
 */

package impl.execute;

import impl.data.Field;
import impl.data.Node;
import impl.data.Path;
import impl.strategy.DijkstraStrategy;
import impl.strategy.ISearchPathStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is the class header. The first sentence (ending with "."+SPACE) is
 * important, because it is used summary in the package overview pages.<br />
 * <br />
 * 
 * @author ara
 * @version $Revision$
 */

public class Runner {
	public static void main(String[] args) {
    String fieldString = "0,2,3,6\n0,8,5,7\n1,2,0,8";
    
    
    Field field = parseField(fieldString);
    
    ISearchPathStrategy s = new DijkstraStrategy();
    Path p = s.getShortestPath(field);
  }

	private static Field parseField(String fieldString) {
		String[] lines = fieldString.split("\n");
		List<List<Node>> nodeLineList = new ArrayList<>();
		List<Node> result = new ArrayList<>();
		for (String line : lines) {
			List<Node> tmp = parseLine(line);
			nodeLineList.add(tmp);			
			result.addAll(tmp);
		}
		
		Node start = nodeLineList.get(0).get(0);
		List<Node> lastLine = nodeLineList.get(nodeLineList.size() - 1);
		Node end = lastLine.get(lastLine.size() - 1);

		// link lines
		for (List<Node> nodeList : nodeLineList) {
			Iterator<Node> it = nodeList.iterator();
			if (it.hasNext()) {
				Node previous = it.next();
				while (it.hasNext()) {
					Node current = it.next();
					previous.addNeighbour(current);
					current.addNeighbour(previous);
				}
			}
		}

		// link columns
		for (int i = 0; i < nodeLineList.size(); i++) {
			Iterator<List<Node>> it = nodeLineList.iterator();
			if (it.hasNext()) {
				List<Node> previousRow = it.next();
				Node previous = previousRow.get(i);
				while (it.hasNext()) {
					List<Node> currentRow = it.next();
					Node current = currentRow.get(i);
					previous.addNeighbour(current);
					current.addNeighbour(previous);
				}
			}
		}

		return new Field(result, start, end);
	}

	private static List<Node> parseLine(String lineString) {
		List<Node> result = new ArrayList<>();

		String[] numbers = lineString.split(",");
		for (String number : numbers) {
			int x = Integer.parseInt(number);
			result.add(new Node(x));
		}

		return result;
	}

}

// ---------------------------- Revision History ----------------------------
// $Log$
//
