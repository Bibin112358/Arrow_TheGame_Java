
public class MouseTrigger extends TriggerBrick {

	public MouseTrigger(int x, int y, int w, int h, int duration, int vx, int vy) {
		super(x, y, w, h, duration, vx, vy);
		// TODO Auto-generated constructor stub
	}

	@Override
	void trigger(Level level) {
		// TODO Auto-generated method stub
		super.trigger(level);
		if(Main.mouse!=null && Main.mouse.pressed){
			triggered = true;
		}
	}
}
