import java.util.ArrayList;
public class Mug {
	private ArrayList<Liquid> liquid = new ArrayList<Liquid>();
	public void addLiquid( Liquid l){
		liquid.add(l);
		l.stir();
		
	}
}
