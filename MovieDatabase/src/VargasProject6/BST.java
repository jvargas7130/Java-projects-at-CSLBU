import java.util.ArrayList;

/**The binary search tree class is used for adding , removing 
 * and searching for data. This class works with node class.
 * 
 * @author jesus vargas
 *
 */
public class BST {

	/**root variable Keeps track of node
	 * 
	 */
	private Node root;

	/**BST constructor sets the  root to null
	 * 
	 */
	public BST() {
		root = null;
	}

	/**isEmpty checks if root is empty 
	 *
	 * @return the value or root
	 */
	public boolean isEmpty(){
		return root == null;
	}

	/**FindMin is the facade of the 
	 * recursive findMin
	 * 
	 * @return the movie value
	 */
	public Movie findMin(){
		return findMin(root).getData(); 
	}

	/**findMin recursive method recurses until min value is found
	 * 
	 * @param n node value
	 * @return min value 
	 */
	private Node findMin(Node n){ 
		if(n == null){
			return null;
		}else if(n.getLeft() == null){
			return n; 
		}
		return findMin(n.getLeft()); 
	}

	/**findMax is the faceade of 
	 * the recursive findMax 
	 * 
	 * @return the value of movie
	 */
	public Movie findMax(){
		return findMax(root).getData(); 
	}

	/**findMax recursive method recurses until the 
	 * max value is found
	 * 
	 * @param n value is passed in 
	 * @return max value
	 */
	private Node findMax(Node n){ 
		if(n == null){
			return null;
		}else if(n.getRight() == null){
			return n; 
		}
		return findMax(n.getRight()); 
	}

	/**add method facade takes in word and 
	 * passes it in to recursive add method
	 * 
	 * @param d value of word is passed in
	 */
	public void add(Movie d){
		root = add(d,root);
	}

	/**add recursive value adds the word to the node
	 * 
	 * @param d word value
	 * @param tree node value
	 * @return tree the node value 
	 */
	private Node add(Movie d , Node tree){

		if(tree == null){
			return new Node(d);
		}else{

			if(d.compareTo(tree.getData()) < 0 ){
				tree.setLeft(add(d, tree.getLeft()));

			}else{
				tree.setRight(add(d, tree.getRight()));
			}
			return tree;
		}
	}

	//Search the tree for a particular value public Node search(int d) {
	/**Search method fasade passes in string to recursive search method 
	 * 
	 * @param d string value
	 * @return search value 
	 */
	public Node search(String d) {
		if (root == null) {
			System.out.println("No items to search");
			return null;
		} else {
			return search(d, root);
		} 	
	}

	/**search recursive method searches a word by comparing 
	 * the string and node data.
	 * 
	 * @param d String value
	 * @param n node value
	 * @return search value
	 */
	private Node search(String d, Node n) { 

		if (d.equalsIgnoreCase(n.getData().getTitle())) {
			return n; 
		}  

		if (d.compareToIgnoreCase(n.getData().getTitle()) < 0) {
			if (n.getLeft() == null) {
				System.out.println("Item Not Found");
				return null;
			} else {

				return search(d, n.getLeft()); 
			}
		} else {
			if (n.getRight() == null) {
				System.out.println("Item Not Found");
				return null;
			}  else {
				return search(d, n.getRight()); 
			}
		}
	}


	/**
	 * SearchRating is the facade of the 
	 * recursive searchRating
	 * 
	 * @param r	rating value
	 */
	public void searchRating(String r){
		if (isEmpty()){
			System.out.println( "No items to print" );
		}
		else {
			searchRating(root, r);
		}
	}

	/**
	 * SearchRating recursion method recurses  until rating is found.
	 * It prints out all the ratings in the movie
	 *
	 * @param r	rating value
	 */
	private void searchRating(Node n, String r)
	{
		if (n.getLeft() != null){
			// go down left tree
			searchRating( n.getLeft(), r );
		}
		if (n.getData().getRating().compareToIgnoreCase(r) == 0){
			System.out.println( n.getData() );
		}
		if (n.getRight() != null) {
			searchRating( n.getRight(), r );
		}
	}

	/**
	 * searchDecade is the facade of the 
	 * recursive searchDecade
	 * 
	 * @param r	decade value
	 */
	public void searchDecade(String r){
		if (isEmpty()){
			System.out.println( "No items to print" );
		}
		else {
			searchDecade( root, r );
		}
	}
	/**
	 *searchDecade recursive methdo recurses until it
	 *finds all the movies in that decade.
	 * 
	 * @param n	node value 
	 * @param r year value-
	 */
	private void searchDecade(Node n, String r){
		if (n.getLeft() != null){
			// go down left tree
			searchDecade(n.getLeft(), r);
		}
		if (n.getData().getYear().compareTo(r) == 0){
			System.out.println( n.getData() );
		}
		if (n.getRight() != null) {
			searchDecade( n.getRight(), r );
		}
	}

	/**
	 * searchStars is the facade of searchStars 
	 * recursive 
	 * 
	 * @param r stars value
	 */
	public void searchStars(String r) 
	{
		if (isEmpty()){
			System.out.println( "No items to print" );
		}

		else{
			searchStars(root, r);
		}
	}
	/**
	 * Prints the Binary Search Tree recursively
	 * 
	 * @param n	node value
	 * @param r stars value
	 */
	private void searchStars(Node n, String r){
		if ( n.getLeft() != null ){
			// go down left tree
			searchStars(n.getLeft(), r);
		}
		if (n.getData().getaudianceRating().compareToIgnoreCase(r) == 0){
			System.out.println( n.getData() );
		}
		if ( n.getRight() != null ) {
			searchStars( n.getRight(), r );
		}
	}

	/**
	 *searchActors is the facade of the 
	 *searchActors recursive 
	 * 
	 * @param r	value of rating
	 */
	public void searchActors( String r ) 
	{
		if ( isEmpty() ){
			System.out.println( "No items to print" );
		}
		else {
			searchActors( root, r );
		}

	}

	/**
	 * searchActors is the facade o recursive searchActors 
	 * 
	 * @param n	node value
	 * @param r actors value
	 */
	private void searchActors( Node n, String r )
	{
		if ( n.getLeft() != null ){
			// go down left tree
			searchActors( n.getLeft(), r );
		}
		ArrayList<String> names = n.getData().getNames();
		for(int i = 0; i < names.size(); i++){
			if ( n.getData().getNames().get(i).compareToIgnoreCase(r) == 0 ){
				System.out.println( n.getData() );
			}
		}
		if ( n.getRight() != null ) {
			searchActors( n.getRight(), r );
		}
	}


	//print the tree in order
	/**printBST facade
	 * 
	 */
	public void printBST(){
		if(isEmpty()){
			System.out.println("No items to print");
		}else{
			printBST(root);
		}
	}

	/**printBST recursive method prints out the values 
	 * in the tree 
	 * 
	 * @param n passes in node value
	 */
	private void printBST(Node n){
		//go down the left tree
		if (n.getLeft() != null) {
			printBST(n.getLeft());
		}
		//go down right tree
		System.out.println(n.getData() + " ");
		if (n.getRight() != null){
			printBST(n.getRight());
		}
	}

	/**
	 * remove is the facade of the recursive remove method
	 * 
	 * @param d movie value
	 */
	public void remove(Movie d) {
		if (root == null) {
			System.out.println("No items to remove");
		} else {
			root = remove(d, root);
		}
	}

	/**
	 * remove method recurses until the movie is removed
	 * 
	 * @param d movie value
	 * @param n node value
	 * @return n node value removed
	 */
	private Node remove(Movie d, Node n) {
		if(n == null){
			return n;
		} //traverse to node to be removed 
		if(d.compareTo(n.getData()) < 0){
			n.setLeft(remove(d, n.getLeft())); 
		}else if(d.compareTo(n.getData()) > 0){
			n.setRight(remove(d, n.getRight())); } 
		//two children
		else if(n.getLeft() !=null && n.getRight() != null){ 
			if((int)(Math.random()*2) == 0){
				n.setData(findMin(n.getRight()).getData());
				n.setRight(remove(n.getData(),n.getRight())); 
			}else{
				n.setData(findMax(n.getLeft()).getData());
				n.setLeft(remove(n.getData(), n.getLeft())); 
			}
		}else{ //one child 
			if(n.getLeft() != null){
				n = n.getLeft();
			}else{
				n = n.getRight();
			}
		}
		return n; 
	}
}
