import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	
	//static double world_x, world_y; //to move inside the window
	static Level level;
	
	double x; //relative to world coordinate
	double y;
	//double r_x, r_y; //position on screen
	double w; //width
	double h; //height
	double vx, vy;
	
	Image[] im;
	double pos;
	double speed;
	
	public Sprite() {
		pos=0;
		//XML
	}
	
	public void update(/*double t*/){
		
	}
	
	static public void setLevel(Level level){
		Sprite.level = level;
	}
	
	public void render(GraphicsContext gc){
		/*
		r_x = world_x + x;
		r_y = world_y + y;
		*/
	}
	
	public Rectangle2D getBoundary(){
		return new Rectangle2D(x, y, w, h);
	}
	
	public void moveCamera(double dx, double dy){
		x = x - dx;
		y = y - dy;
	}
}
