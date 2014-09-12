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

	public Vector2D mult(Vector2D other){
		return new Vector2D(x*other.x,y*other.y);
	}

	public int x(){
		return x;
	}

	public int y(){
		return y;
	}

}
