
public class LevelTEST extends Level {

	public LevelTEST() {
		// TODO Auto-generated constructor stub
		//instancing and intit
		player = new Player();
		//Collisions
		collisions = new Move[1];
		collisions[0] = player;
		//Sprites
		sprites = new Sprite[1];
		sprites[0] = player;
	}
}
