import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends Sprite {

	public Brick(double x, double y, double w, double h) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y =y;
		this.w=w;
		this.h=h;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		//REMOVE THIS
		x++;
		
		super.render(gc);
		//test visual
		gc.setFill(Color.GREEN);
		gc.fillRect(r_x, r_y, w, h);
	}
}
