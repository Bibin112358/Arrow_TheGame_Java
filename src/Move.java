import java.util.ArrayList;

public class Move extends Sprite{

	double g=0.3; //gravity
	
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
