
public class Rectangle {
	
	private int length;
	private int width;
	
	
	public Rectangle(int l ,int w){
		length = l;
		width = w;
	}
	
	public int getlength(){
		return length;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getArea(){
		return length *width;
	}
}
