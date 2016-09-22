
public class MugTest {

	public static void main(String[] args) {
		
		//The tyoe of liquid the mug is holding
		Mug mug = new Mug();
		
		Coffee coffee = new Coffee();
		Milk milk = new Milk();
		
		mug.addLiquid(coffee);
		mug.addLiquid(milk);

	}

}
