import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Arrow extends Move {

	//TODO test
	double px, py;
	public Arrow(double px, double py,double x, double y) {
		this.x = x;
		this.y = y;
		//TODO test
		this.px = px;
		this.py = py;
		h=10;
		w=10;
		level.addCollisions(this);
	}
	
	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
		//TODO test
		gc.setFill(Color.ORANGE);
		gc.strokeLine(px + world_x, py + world_y, r_x, r_y);
	}
	
	
}
