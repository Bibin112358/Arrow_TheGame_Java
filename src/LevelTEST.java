import java.util.ArrayList;

public class LevelTEST extends Level {

	public LevelTEST() {
		// TODO test
		//instancing and intit
		player = new Player(100,100);
		Brick brick = new Brick(400, 400, 3000, 100, 0, 0);
		PhysicsBrick box1 = new PhysicsBrick(500, -100);
		//Collisions
		collisions = new ArrayList<Move>();
		collisions.add(player);
		collisions.add(box1);
		//Sprites
		sprites = new ArrayList<Sprite>();
		sprites.add(box1);
		sprites.add(brick);
		sprites.add(player);
		
	}
}
