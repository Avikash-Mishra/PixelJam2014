package tools;

public class Vector2D {

	private int x;
	private int y;

	public Vector2D(int x_, int y_){
		x = x_;
		y = y_;
	}

	public Vector2D add(Vector2D other){
		return new Vector2D(x+other.x,y+other.y);
	}

	public Vector2D sub(Vector2D other){
		return new Vector2D(x-other.x,y-other.y);
	}

	public void setX(int x_){
		x = x_;
	}

	public void setY(int y_){
		y = y_;
	}

	public int x(){
		return x;
	}

	public int y(){
		return y;
	}

}
