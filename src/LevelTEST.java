import java.util.ArrayList;

public class LevelTEST extends Level {

	public LevelTEST() {
		// TODO test
		//instancing and intit
		player = new Player(100,100);
		Brick brick = new Brick(400, 400, 600, 100);
		//Collisions
		collisions = new ArrayList<Move>();
		collisions.add(player);
		//Sprites
		sprites = new ArrayList<Sprite>();
		sprites.add(player);
		sprites.add(brick);
	}
}
