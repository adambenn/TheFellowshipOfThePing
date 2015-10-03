import java.util.*;
import java.awt.Point;

public class PlayerAI extends ClientAI {
	public PlayerAI() {
		//Write your initialization here
		
	}

	@Override
	public Move getMove(Gameboard gameboard, Opponent opponent, Player player) throws NoItemException, MapOutOfBoundsException {
		System.out.println(gameboard.getBullets());
		
		
		//Write your AI here
		return Move.NONE;
	}
}

public void refreshDanger(Gameboard gameboard, Opponent opponent, Player player) {
	int currentTurn = gameboard.getCurrentTurnNumber();
	for (int i = 0; i < graph.turrets.size(); i++) {
		// Turrets are points, look for a cross of size
		// 4 around turrets and mark as dangerous
		turret_x = graph.turrets[i].x;
		turret_y = graph.turrets[i].y;
		for (j = 1; j < 5; j++) {
			if (turret_x + j >= graph.width) {
				if (gameboard.isWallAtTile(j, turret_y)) {
					break;
				}
				graph.adjList[j][turret_y].node.setDangerous(currentTurn);
			}
			else {
				if (gameboard.isWallAtTile(turret_x + j, turret_y)) {
					break;
				}
				graph.adjList[turret_x + j][turret_y].node.setDangerous(currentTurn);
			}
		}
		for (j = 1; j < 5; j++) {
			if (graph.turrets.x - j < 0) {
				if (gameboard.isWallAtTile(graph.width - j, turret_y)) {
					break;
				}
				graph.adjList[graph.width - j][turret_y].node.setDangerous(currentTurn);
			}
			else {
				if (gameboard.isWallAtTile(turret_x - j, turret_y)) {
					break;
				}
				graph.adjList[turret_x - j][turret_y].node.setDangerous(currentTurn);
			}
		}
		for (j = 1; j < 5; j++) {
			if (graph.turrets.y + j >= graph.height) {
				if (gameboard.isWallAtTile(turret_x, j)) {
					break;
				}
				graph.adjList[turret_x][j].node.setDangerous(currentTurn);
			}
			else {
				if (gameboard.isWallAtTile(turret_x, turret_y + j)) {
					break;
				}
				graph.adjList[turret_x][turret_y + j].node.setDangerous(currentTurn);
			}
		}
		for (j = 1; j < 5; j++) {
			if (graph.turrets.y - j < 0) {
				if (gameboard.isWallAtTile(turret_x, graph.height - j)) {
					break;
				}
				graph.adjList[turret_x][graph.height - j].node.setDangerous(currentTurn);
			}
			else {
				if (gameboard.isWallAtTile(turret_x, turret_y - j)) {
					break;
				}
				graph.adjList[turret_x][turret_y - j].node.setDangerous(currentTurn);
			}
		}
	}
}