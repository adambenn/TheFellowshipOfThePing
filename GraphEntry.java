import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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