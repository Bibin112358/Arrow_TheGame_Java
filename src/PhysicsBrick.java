import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PhysicsBrick extends Move {

	Color color = Color.FIREBRICK;
	
	public PhysicsBrick(double x, double y) {
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
		
		x = x + vx*t;
		y = y + vy*t;
	}
}
