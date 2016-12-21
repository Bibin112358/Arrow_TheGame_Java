import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
	
	static int world_x, world_y; //to move inside the window
	
	double x; //relative to world coordinate
	double y;
	double w; //width
	double h; //height
	
	Image[] im;
	double pos;
	double speed;
	
	public Sprite() {
		pos=0;
		//XML
	}
	
	public void update(double t){
		x = x+ vx*t;
		y = y+ vy*t;
	}
	
	public void render(GraphicsContext gc){
		if(pos >= im.length){
			pos=0;
		}
		gc.drawImage(im[(int)pos], x, y);
		pos = pos + speed;
	}
	
	public Rectangle2D getBoundary(){
		return new Rectangle2D(x, y, w, h);
	}
	
	
}
