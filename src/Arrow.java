import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Arrow extends Move {

	//TODO test
	double sx, sy; //coordinates in heavy point, middle of arrow
	//x and y are tip of the arrow
	double l=20; //length
	public Arrow(double x, double y,double vx, double vy) {
		this.sx = x;
		this.sy = y;
		this.vx = vx;
		this.vy = vy;
		//TODO test
		h=0;
		w=0;
		level.addCollisions(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//super.update();
		double t=10; //different FPS?
		vy = vy + 0.01*t;
		
		sx = sx + vx;
		sy = sy + vy;
		
		double k = (Math.sqrt(vy*vy +vx*vx))/l;
		
		x = sx + vx/k;
		y = sy + vy/k;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
		//TODO test
		gc.setFill(Color.ORANGE);
		gc.strokeLine(r_x - 2*(x-sx), r_y - 2*(y-sy), r_x, r_y);
		//lazy incorrect: (heavy point at front)
		//gc.strokeLine(sx+world_x -2*(x-sx), sy+world_y-2*(y-sy), sx + world_x, sy + world_y);
	}
	
	
}
