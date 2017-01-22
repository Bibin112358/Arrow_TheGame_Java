import java.util.ArrayList;

public class Move extends Sprite{

	double vx;
	double vy;
	
	public void update(){
		//type?
		//x
		//y
	}
	
	public boolean intersects(Sprite s){
		return s.getBoundary().intersects(this.getBoundary());
	}
	
	public void collision(ArrayList<Sprite> sprites){
		
	}
}
