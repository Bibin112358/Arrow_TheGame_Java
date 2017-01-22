import java.util.ArrayList;

public class Level {

	Player player;
	//enemy
	ArrayList<Move> collisions;
	ArrayList<Sprite> sprites;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCollisions(Move m){
		collisions.add(m);
		sprites.add(m);
	}
}
