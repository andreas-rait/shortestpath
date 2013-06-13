/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

	private HashMap<String, Vertex> verteces = new HashMap<String, Vertex>();
	
	public void generateGraph(String filename) {
		String fileRow;
		String checkedString;
		BufferedReader file;
		
		try {
			file = new BufferedReader(new FileReader (filename));
			while ((fileRow = file.readLine()) != null) {
				fileRow = fileRow.trim();
				
				try {
					switch (fileRow.toUpperCase().charAt(0)) {
						case '#':
							//System.out.println("-- Kommentar: " + fileRow.substring(1));			
						break;
						
						case 'V':
							checkedString = checkString(fileRow);
							
							if (!checkedString.equals("")) {
								createVerteces(checkedString);
							} else {
								System.out.println("-- Fehler im Syntax, kann nicht gelesen werden!");
							}
							
							
						break;
						
						case 'E':
							checkedString = checkString(fileRow);
							
							if (!checkedString.equals("")) {
								createEdge(checkedString);
							} else {
								System.out.println("-- Fehler im Syntax, kann nicht gelesen werden!");
							}
							
							
						break;
						
						default:
							System.out.println("-- Unbekannter Typ: " + fileRow);
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("-- Leerzeile");
				}
			}	
			file.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Einlesen der Datei!");
		}
	}
	
	private void createEdge(String checkedString) {		
		String[] edgeInformation = checkedString.substring(1, checkedString.length()-1).split(",");
		
		verteces.get(edgeInformation[0]).getNeighbours().add(new Edge(verteces.get(edgeInformation[1]), Integer.parseInt(edgeInformation[2])));
		verteces.get(edgeInformation[1]).getNeighbours().add(new Edge(verteces.get(edgeInformation[0]), Integer.parseInt(edgeInformation[2])));
	}

	private void createVerteces(String checkedString) {
		String[] vertecesArray = checkedString.split(",");
		for(int i = 0; i < vertecesArray.length; i++) {
			Vertex v = new Vertex(vertecesArray[i]);
			verteces.put(v.getName(), v);
		}
	}

	private String checkString(String filerow) {
		
		String checkedString = filerow.substring(1);
		checkedString = checkedString.trim();
		
		if (((filerow.toUpperCase().charAt(0)=='V') || (filerow.toUpperCase().charAt(0)=='E'))  && (checkedString.charAt(0)==':')) {
			checkedString = checkedString.substring(1);
			checkedString = checkedString.trim();
			return checkedString;
		}  else {
			return "";
		}
	}
	
	public void printShortestPath(String from, String to) {
		findShortestPath(from, to);
		System.out.println("Die kuerzeste Distanz ist " + verteces.get(to).getShortestDistance());
		
	}
	
	private void findShortestPath(String from, String to) {
		verteces.get(from).setShortestDistance(0);
		verteces.get(from).setShortestPathKnown(true);
		
		ArrayList<Vertex> temp = new ArrayList<Vertex>();
		
		temp.add(verteces.get(from));
		
		
		
		while(temp.size() != 0) {
			Vertex helpVertex = new Vertex("");
			for(Vertex tempVertex : temp) {
				if(tempVertex.getShortestDistance() < helpVertex.getShortestDistance()) {
					helpVertex = tempVertex;
					//System.out.println("Help: " + helpVertex.getName());
				}
			}
			
			//System.out.println("Size davor: " + temp.size());
			temp.remove(helpVertex);
			//System.out.println("Size danach: " + temp.size());
			
			if(helpVertex.getName().equals(to)) {
				break;
			} else {
				helpVertex.setShortestPathKnown(true);
				
				//System.out.println("Komme hier her");
				for(Edge e : helpVertex.getNeighbours() ) {
					if(!e.getNeighbour().isShortestPathKnown()) {
						if((helpVertex.getShortestDistance()+e.getDistance()) < e.getNeighbour().getShortestDistance()) {
							e.getNeighbour().setNeighbourOnShortestPath(helpVertex);
							e.getNeighbour().setShortestDistance(helpVertex.getShortestDistance()+e.getDistance());
							
							temp.add(e.getNeighbour());
						}
					}
				}
				
			}
		}
		
		
	}
}

