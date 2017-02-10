
public class Mouse {

	double x, y;
	boolean pressed;
	boolean released;
	double time;
	
	public Mouse() {
		pressed = true;
		released=false;
		time=0;
	}
	
	public void getPos(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public void pull(){
		
		time += 2;
	}
	
	public double get(){
		//linear strength
		if(time > 100)
			return 1;
		return time/100;
	}
}
