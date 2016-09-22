/*Node class for search tree keeps track of a nodes that is used with binary tree.
 * Left and right nodes begin set as null and then store a movie.
 * 
 * @author Jesus Vargas
 */
public class Node {
	/** Movie data holds the value of movie.
	 * 
	 */
	private Movie data;

	/**Left node keeps track of the value of
	 * left node
	 * 
	 */
	private Node left;

	/**Right node keeps track of the value of 
	 * right node
	 * 
	 */
	private Node right;

	/**Node constructor reads in Movie and 
	 * sets left and right to null
	 * 
	 * @param d word value
	 */
	public Node(Movie d) {
		data = d;
		left = null;
		right = null;
	}

	/**setData method sets the data 
	 * 
	 * @param d word values
	 * @return word value
	 */
	public Movie setData(Movie d) {
		return data = d;
	}

	/** getData method is used as an 
	 * accessor to access the data of the word
	 * 
	 * @return data value of data 
	 */
	public Movie getData() {
		return data;
	}
	
	/**setLeft method sets the left node
	 * 
	 * @param l value of left node
	 */
	public void setLeft(Node l) {
		left = l; 
	}

	/**getLeft method accesses the value of 
	 * left node
	 * 
	 * @return left  value of left Node
	 */
	public Node getLeft() {
		return left;
	}

	/**setRight method accesses the value of right node 
	 * 
	 * @param r value of right node
	 */
	public void setRight(Node r) {
		right = r; 
	}

	/**getRight gets the value of right node.
	 * 
	 * @return right  value of right node
	 */
	public Node getRight() {
		return right;
	}
}
