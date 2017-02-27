import java.util.ArrayList;

public class Level {

	Player player;
	//TEST REMOVE
	ArrayList<TriggerBrick> triggers;
	
	//enemy
	ArrayList<Sprite> sprites;
	ArrayList<Move> collisions;
	
	public Level() {
		// TODO Auto-generated constructor stub
	}
	
	public void addCollisions(Move m){
		sprites.add(m);
		collisions.add(m);
	}
}
