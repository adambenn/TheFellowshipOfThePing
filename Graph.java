import java.util.ArrayList;
import java.util.List;
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
					GraphNode node = new GraphNode();
					adjList[i][j] = GraphEntry(node, newAdj);
				}
				else {
					GraphNode node = new GraphNode();
					adjList[i][j] = GraphEntry(node);
				}
			}
		}
	}
}
