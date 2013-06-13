package impl.data;

import java.util.List;


public class Field {

	private final Node start;
	private final Node end;
	private final List<Node> nodes;

	
	public Field(List<Node> nodes, Node start, Node end){
		this.start = start;
		this.end = end;
		this.nodes = nodes;
	}


	public Node getStart() {
		return start;
	}


	public Node getEnd() {
		return end;
	}


	public List<Node> getNodes() {
		return nodes;
	}
	
}
