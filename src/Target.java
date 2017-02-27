import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Target extends Sprite {

	int r;
	boolean hit;
	public Target(int x, int y, int r) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.r=r;
	}
	
	@Override
	public Rectangle2D getBoundary() {
		// TODO Auto-generated method stub
		return new Rectangle2D(x-r, y-r, 2*r, 2*r);
	}
	
	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		super.render(gc);
		gc.setFill(Color.ORANGERED);
		gc.fillOval(x-r, y-r, 2*r, 2*r);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}
	
	
}
