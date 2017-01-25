import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Player extends Move{

	public Player(double w, double h) {
		// TODO
		//all test
		this.h = h;
		this.w = w;
	}
	Color  color = Color.BLUE; //test
	@Override
	public void render(GraphicsContext gc) {
		// TODO
		super.render(gc);
		gc.setFill(color);//test
		gc.fillRect(r_x, r_y, w, h); //test purpose
		
	}
	
	
	@Override
	public void update() {
		double t=10; //maybe for different FPS
		// TODO
		//super.update();
		
		//TODO gravity
		//vy = vy + 0.01*t;
		
		x = x + vx*t;
		y = y + vy*t;
		
		
		//possible player tracking camera
		if(Main.window_w < r_x+w){
			world_x = world_x -10;
		}else if(0 > r_x){
			world_x = world_x +10;
		}
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
					
					double player_x, player_y, brick_x, brick_y;
					
					if(vx>0){
						player_x = this.x + this.w;
						brick_x = spr.x;
					}else{
						player_x = this.x;
						brick_x = spr.x + spr.w;
					}
					
					if(vy>0){
						player_y = this.y + this.h;
						brick_y = spr.y;
					}else{
						player_y = this.y;
						brick_y = spr.y + spr.h;
					}
					
					if(vx!=0 && ( vy==0 || (player_x - brick_x)/vx < (player_y-brick_y)/vy )){
						//move x direction
						this.x = this.x - (player_x - brick_x);
					}else{
						//move y direction
						this.y = this.y - (player_y - brick_y);
					}
					
				}
				color = Color.RED;
			}
		}
	}
	
	// TODO maybe not in player class?
	//control
	public void control(ArrayList<String> input, Mouse mouse){
	
		if(mouse != null && mouse.b){
			double ax = mouse.x - (x+w/2);
			double ay = mouse.y - (y+h/2);
			double k = 5 / (Math.sqrt(ay*ay + ax*ax));
			Arrow arrow = new Arrow(x+w/2, y+h/2,ax*k, ay*k);
			mouse.b = false;
		}
		
		if(input.contains("D")){
			vx=1;
		}else if(input.contains("A")){
			vx=-1;
		}else{
			vx=0;
		}
		if(input.contains("W")){
			vy=-1.5;
		}else if(input.contains("S")){
			vy=1;
		}else{
			vy=0;
		}
		
		if(input.contains("R")){
			x=0;y=0; vx=0; vy=0;
		}
	}
}
