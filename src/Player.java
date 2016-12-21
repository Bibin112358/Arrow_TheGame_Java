import java.util.ArrayList;

public class Player extends Move{

	//gravity
	
	//control
	public void control(ArrayList<String> input){
	
		if(input.contains("RIGHT")){
			vx=1;
		}else if(input.contains("LEFT")){
			vx=-1;
		}else{
			vx=0;
		}
		if(input.contains("UP")){
			vy=-1.5;
		}else{
			vy=0;
		}
		
		if(input.contains("R")){
			x=0;y=0; vx=0; vy=0;
		}
	}
}
