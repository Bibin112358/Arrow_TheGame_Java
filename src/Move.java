
public class Move extends Sprite{

	int type;
	double vx;
	double vy;
	
	Move(int type){
		type = this.type;
	}
	
	public void update(){
		//type
		//x
		//y
	}
	
	public boolean intersects(Sprite s){
		return s.getBoundary().intersects(this.getBoundary());
	}
}
