import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends Sprite {

	public Brick(int x, int y, int w, int h) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y =y;
		this.w=w;
		this.h=h;
		//REVOME THIS
		vx=0;
		vy=0;
	}
	
	public Brick(int x, int y, int w, int h, double vx, double vy) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y =y;
		this.w=w;
		this.h=h;
		this.vx=vx;
		this.vy=vy;
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		x+=vx*t;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		super.render(gc);
		//test visual
		gc.setFill(Color.GREEN);
		gc.fillRect(x, y, w, h);
	}
}
