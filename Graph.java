import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Graph {
	GraphEntry[][] adjList;
	
	Graph(Gameboard board){
		this.adjList = new GraphEntry[board.getWidth()][board.getHeight()];
	}
}

class GraphEntry{
	GraphNode node;
	List<Point> adjacent;
	
	GraphEntry(GraphNode node){
		this.node = node;
		this.adjacent = new ArrayList<Point>();
	}
	
	GraphEntry(GraphNode node, List<Point> adjacent){
		this.node = node;
		this.adjacent = adjacent;
	}
}