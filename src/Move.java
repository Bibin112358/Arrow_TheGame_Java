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
	
	
	
	//collision with immovable Sprites
	public void collisionBrick(Sprite spr){
		double player_x, player_y, brick_x, brick_y;
		
		double rvx = vx - spr.vx;
		double rvy = vy - spr.vy;
		
		if(rvx>0){
			player_x = this.x + this.w;
			brick_x = spr.x;
		}else{
			player_x = this.x;
			brick_x = spr.x + spr.w;
		}
		
		if(rvy>0){
			player_y = this.y + this.h;
			brick_y = spr.y;
		}else{
			player_y = this.y;
			brick_y = spr.y + spr.h;
		}
		
		if(rvx!=0 && ( rvy==0 || (player_x - brick_x)/rvx < (player_y-brick_y)/rvy )){
			//move x direction
			this.x = (int) (this.x - (player_x - brick_x));
			this.vx = 0;
		}else{
			//move y direction
			this.y = (int) (this.y - (player_y - brick_y));
			this.vy = 0;
		}
	}
	
	//collision with Move
	public void collisionMove(Move m){
		double player_x, player_y, brick_x, brick_y;
		
		double rvx = vx - m.vx;
		double rvy = vy - m.vy;
		
		if(rvx>0){
			player_x = this.x + this.w;
			brick_x = m.x;
		}else{
			player_x = this.x;
			brick_x = m.x + m.w;
		}
		
		if(rvy>0){
			player_y = this.y + this.h;
			brick_y = m.y;
		}else{
			player_y = this.y;
			brick_y = m.y + m.h;
		}
		
		if(rvx!=0 && ( rvy==0 || (player_x - brick_x)/rvx < (player_y-brick_y)/rvy )){
			//move x direction
			this.x = (int) (this.x - 1.0/2*(player_x - brick_x));
			m.x = (int) (m.x + 1.0/2*(player_x - brick_x));
			/*this.vx = 0;
			m.vx = 0;*/
		}else{
			//move y direction
			this.y = (int) (this.y - 1.0/2*(player_y - brick_y));
			m.y = (int) (m.y + 1.0/2*(player_y - brick_y));
			/*this.vy = 0;
			m.vy = 0;*/
		}
		
	}
}
