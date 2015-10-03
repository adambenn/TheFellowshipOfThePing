import java.awt.Point;

public class GraphNode {
	public Point point;
	private int lastSet = 0; // Turn that dangerous was last set
	
	public void setDangerous(int currentTurn){
		lastSet = currentTurn;
	}
	
	public boolean isDangerous(int currentTurn){
		if(currentTurn == lastSet){
			return true;
		}else{
			return false;
		}
	}
	
	GraphNode(Point p) {
		point = p;
	}
	
}
