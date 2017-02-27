import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player extends Move{

	double strength = 50;
	public Player(int w, int h) {
		// TODO
		//all test
		this.h = h;
		this.w = w;
		x=200;
		y=200;
	}
	Color  color = Color.BLUE; //test
	@Override
	public void render(GraphicsContext gc) {
		// TODO
		super.render(gc);
		gc.setFill(color);//test
		gc.fillRect(x, y, w, h); //test purpose
		
	}
	
	
	@Override
	public void update() {
		//t maybe for different FPS
		// TODO
		//super.update();
		
		//TODO gravity
		//vy = vy + 0.01*t;
		
		x = (int) (x + vx*t);
		y = (int) (y + vy*t);
		
		
		//maybe after collision detection?
		//possible player tracking camera
		/*if(Main.window_w < x+w){
			//world_x = world_x -10;
			for(int i=0; i<level.sprites.size(); i++){
				level.sprites.get(i).moveCamera(10, 0); //instead of moving camerea, move every sprite
			}
		}else if(0 > x){
			//world_x = world_x +10;
			for(int i=0; i<level.sprites.size(); i++){
				level.sprites.get(i).moveCamera(-10, 0);
			}
		}*/
		
	}
	
	public void camera(){
		double d =x-Main.window_w/6;
		if(vx !=0){
			d = d - 3*vx/Math.abs(vx); //feeling of speed
		}
		for(int i=0; i<level.sprites.size(); i++){
			level.sprites.get(i).moveCamera(d , 0);
		}
		//System.out.println(d);
	}
	
	//collision?
	@Override
	public void collision(ArrayList<Sprite> sprites) {//test
		// TODO Auto-generated method stub
		//super.collision(sprites);
		color = Color.BLUE;
		for(Sprite spr:sprites){
			if(intersects(spr) && !spr.equals(this)){
				if(spr instanceof Brick){
					
					collisionBrick(spr);
					color = Color.ORANGE;
				}else if(spr instanceof PhysicsBrick){
					collisionMove((Move)spr);
					color = Color.GREEN;
				}else{
					color = Color.RED;
				}
			}
		}
	}
	
	// TODO maybe not in player class?
	//control
	public void control(ArrayList<String> input, Mouse mouse){
	
		if(mouse != null){
			if(mouse.pressed && !mouse.released){
				mouse.pull();
			}else if(mouse.pressed && mouse.released){
				double ax = mouse.x - (x+w/2);
				double ay = mouse.y - (y+h/2);
				double k = strength * mouse.get() / (Math.sqrt(ay*ay + ax*ax));
				new Arrow(x+w/2, y+h/2,ax*k, ay*k);
				mouse.pressed = false;
				mouse.released = false;
			}
		}
		
		if(input.contains("D")){
			vx=10;
		}else if(input.contains("A")){
			vx=-10;
		}else{
			vx=0;
		}
		if(input.contains("W")){
			vy=-15;
		}else if(input.contains("S")){
			vy=10;
		}else{
			vy=0;
		}
		
		if(input.contains("R")){
			x=0;y=0; vx=0; vy=0;
		}
	}
}
