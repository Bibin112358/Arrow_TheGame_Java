
public class Mouse {

	double x, y;
	boolean pressed;
	boolean released;
	double time;
	
	public Mouse() {
		pressed = true;
		released=false;
		//strength=0;
	}
	
	public void getPos(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public void pull(){
		time = time +  0.1;
	}
	
	public double get(){
		return 1.0 - 1.0/Math.pow(2, time);
	}
}
