import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends Sprite {

	public Brick(double x, double y, double w, double h) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y =y;
		this.w=w;
		this.h=h;
		//REVOME THIS
		vx=0.1;
		vy=0;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		//REMOVE THIS
		x+=vx*10;
		
		super.render(gc);
		//test visual
		gc.setFill(Color.GREEN);
		gc.fillRect(x, y, w, h);
	}
}
