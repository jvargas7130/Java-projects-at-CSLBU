
import java.util.Scanner;
/**
 * Check input method checks for invalid inputs on integer values
 * 
 * @author jesus Vargas
 *
 */
public class CheckInput {
    
	/**
	 * checkInt method value checks the value of an integer 
	 * 
	 * @return validnum  returns valid number
	 */
	public static int checkInt(){
		Scanner in = new Scanner(System.in);
		int validNum = 0;
		boolean valid = false;
	
		while( !valid ) {
			if( in.hasNextInt() ) { validNum = in.nextInt(); valid = true;
			} 
			else {
			//clear buffer of junk input
				in.next();
			System.out.print("Invalid input- Retry: ");
			} 
		}
		return validNum;
	}
	
	/**
	 * checkInt method value checks the value of an integer and 
	 * checks the for invalid bounds
	 * 
	 * @param low bound value
	 * @param high bound value
	 * @return validNum valid input
	 */
	public static int checkInt( int low, int high ) {
		Scanner in = new Scanner(System.in);
		int validNum = 0;
		boolean valid = false;
		while( !valid ) {
			if(in.hasNextInt()) {
				validNum = in.nextInt();
				if( validNum >= low && validNum <= high ){
					valid = true; } else {
						System.out.print("Invalid- Retry: "); }
			} else {
		//clear buffer of junk input
		in.next();
		System.out.print("Invalid input- Retry: ");
		  } 
		}
		return validNum;
	}

}
