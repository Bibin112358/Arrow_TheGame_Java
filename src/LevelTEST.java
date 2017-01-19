
public class LevelTEST extends Level {

	public LevelTEST() {
		// TODO Auto-generated constructor stub
		//instancing and intit
		player = new Player(100,100);
		Brick brick = new Brick(400, 400, 600, 100);
		//Collisions
		collisions = new Move[1];
		collisions[0] = player;
		//Sprites
		sprites = new Sprite[2];
		sprites[0] = player;
		sprites[1] = brick;
	}
}
