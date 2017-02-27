
public class TriggerBrick extends Brick {
	
	int nvx, nvy;
	boolean triggered = false;
	int duration = 100;
	public TriggerBrick(int x, int y, int w, int h, int duration, int vx, int vy) {
		super(x, y, w, h);
		nvx = vx;
		nvy = vy;
		this.duration = duration;
		this.vx = 0;
		this.vy = 0;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(triggered){
			vy = nvy;
			vx = nvx;
			duration--;
		}
		if(duration < 0){
			vy = 0;
			vx = 0;
		}
		super.update();
	}
	
	void trigger(Level level){
		
	}

}
