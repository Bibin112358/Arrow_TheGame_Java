import java.util.ArrayList;

public class LevelTEST extends Level {

	public LevelTEST() {
		// TODO test
		//instancing and intit
		player = new Player(100,100);
		Brick brick = new Brick(400, 400, 3000, 100, 0, 0);
		Target t = new Target(400, 400, 10);
		
		TriggerBrick triggered = new MouseTrigger(600, -100, 50, 500, 100, 0, -2);
		//triggers
		triggers = new ArrayList<TriggerBrick>();
		triggers.add(triggered);
		
		//Collisions
		collisions = new ArrayList<Move>();
		collisions.add(player);
		
		//Sprites
		sprites = new ArrayList<Sprite>();
		sprites.add(brick);
		sprites.add(player);
		sprites.add(t);
		sprites.add(triggered);
		
	}
}
