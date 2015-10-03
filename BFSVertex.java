import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSVertex{
	public int distance;
	public BFSVertex predecessor;
	public GraphNode node;
	
	BFSVertex(int distance, BFSVertex predecessor, GraphNode node){
		this.distance = distance;
		this.predecessor = predecessor;
		this.node = node;
	}
}