import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PhysicsBrick extends Move {

	Color color = Color.FIREBRICK;
	
	public PhysicsBrick(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		h=100;
		w=100;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		super.render(gc);
		gc.setFill(color);
		gc.fillRect(x, y, w, h);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		vy = vy + g*t;
		
		x = (int) (x + vx*t);
		y = (int) (y + vy*t);
	}
	
	@Override
	public void collision(ArrayList<Sprite> sprites) {
		// TODO Auto-generated method stub
		super.collision(sprites);
		for(Sprite spr: sprites){
			if(intersects(spr) && !spr.equals(this)){
				if(spr instanceof Brick){
					collisionBrick(spr);
				}else if(spr instanceof Move){
					collisionMove((Move) spr);
				}
			}
		}
	}
}
