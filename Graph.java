import java.util.*;

import com.orbischallenge.engine.gameboard.Gameboard;
import java.awt.Point;

public class Graph {
	private GraphEntry[][] adjList;
	private int width, height;
	
	Graph(Gameboard board){
		this.adjList = new GraphEntry[board.getWidth()][board.getHeight()];
		this.width = board.getWidth();
		this.height = board.getHeight();
	}
	
	public void build(){
		
	}
	
	public void build(Gameboard board){
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < this.height; j++) {
				if (!board.isTurretAtTile(i, j) && !board.isWallAtTile(i, j)) {
					List<Point> newAdj;
					// Check the edges of the map, perform wraparound
					if (i == 0) {
						// Left border of map
						int length = this.width - 1;
						if (!board.isTurretAtTile(length, j) && !board.isWallAtTile(length, j)) {
							newAdj.add(new Point(length, j));
						}
					}
					else if (i == this.width - 1) {
						// Right border of map
						if (!board.isTurretAtTile(0, j) && !board.isWallAtTile(0, j)) {
							newAdj.add(new Point(0, j));
						}
					}
					if (j == 0) {
						// Top border of map
						int height = this.height - 1;
						if (!board.isTurretAtTile(i, height) && !board.isWallAtTile(i, height)) {
							newAdj.add(new Point(i, height));
						}
					}
					else if (j == this.height - 1) {
						// Bottom border of map
						if (!board.isTurretAtTile(i, 0) && !board.isWallAtTile(i, 0)) {
							newAdj.add(new Point(i, 0));
						}
					}
					GraphNode node = new GraphNode(new Point(i, j));
					adjList[i][j] = new GraphEntry(node, newAdj);
				}
				else {
					GraphNode node = new GraphNode(new Point(i, j));
					adjList[i][j] = new GraphEntry(node);
				}
			}
		}
	}
	
	/**
	 * Perform Breadth First Search on the graph
	 * @param x - x coordinate of the root
	 * @param y - y coordinate of the root
	 * @return Dictionary indexed by points to the respective BFSVertex
	 */
	private Map<Point, BFSVertex> runBFS(int x, int y){
		Map<Point, BFSVertex> bfs = new HashMap<Point, BFSVertex>();
		Queue<BFSVertex> queue = new LinkedList<BFSVertex>();
		
		BFSVertex start = new BFSVertex(0, null, this.adjList[x][y].node);
		bfs.put(new Point(x, y), start);
		queue.add(start);
		
		while (!queue.isEmpty()){
			BFSVertex v = queue.remove();
			
			for (Point p : adjList[v.node.point.x][v.node.point.y].adjacent){
				if (!bfs.containsKey(p)){
					BFSVertex newVert = new BFSVertex(v.distance + 1, v, adjList[p.x][p.y].node);
					bfs.put(p, newVert);
					queue.add(newVert);
				}
			}
		}
		
		return bfs;
	}
	
	/**
	 * Path from start to end
	 * @param start - Start node point
	 * @param end - End node point
	 * @return List of graph nodes in order from start to end, or an empty
	 * 		   list if there is no path between start and end
	 */
	public List<GraphNode> pathTo(Point start, Point end){
		Map<Point, BFSVertex> bfs = runBFS(start.x, start.y);
		List<GraphNode> out = new ArrayList<GraphNode>();
		
		if(bfs.containsKey(end)){
			BFSVertex pred = bfs.get(end);
			
			while (pred != null){
				out.add(adjList[pred.node.point.x][pred.node.point.y].node);
				pred = pred.predecessor;
			}
			
			Collections.reverse(out);
			return out;
		}
		return new ArrayList<GraphNode>();
	}
}
