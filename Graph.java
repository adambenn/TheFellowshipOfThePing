import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Graph {
	GraphEntry[][] adjList;
	
	Graph(int width, int height){
		this.adjList = new GraphEntry[width][height];
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