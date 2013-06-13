/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Andreas
 */
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
		Graph g = new Graph();
		
		g.generateGraph("test.txt");
		
		g.printShortestPath("A", "F");
	}
}
