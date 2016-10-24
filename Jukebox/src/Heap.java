import java.util.ArrayList;



public class Heap {
	
	
	private ArrayList<Node> heap;
	public Heap(){
		heap = new ArrayList<Node>();
	}
	
	public int getSize(){
		return heap.size();
	}
	
	public boolean isEmpty(){
		return heap.isEmpty();
	}
	
	public int getPLoc(int i){
		return (i-1)/2;
	}
	
	public int getLCLoc(int i){
		return 2*i +1;
	}
	
	public int getRCLoc(int i){
		return 2 * i + 2;
	}
	
	public Node getNodeAt(int i){
		
		

		if(heap.get(i) == null){
			System.out.println("Item does not exist");
			return null; 
		}else{
			return heap.get(i);
		}
	}
	
	public void addNode(Node n){
		heap.add(null);
		int index = heap.size() - 1;
		while(index > 0 &&  getNodeAt(getPLoc(index)).getData() > n.getData()){
			heap.set(index, getNodeAt(getPLoc(index)));
		}
		heap.set(index, n);
	}
	
	public Node removeMin(){
		Node min = heap.get(0);
		int index = heap.size()-1;
		Node last = heap.remove(index);
		if(index > 0){
			heap.set(index, last);
			Node root = heap.get(0);
			int end = heap.size() - 1;
		boolean done = false;
		while(!done){
			if(getLCLoc(index) <= end){//left exist
				Node child = getNodeAt(getLCLoc(index));
				int childLoc = getLCLoc(index);
				if(getRCLoc(index)<=end){//rt exist
					if(getNodeAt(getRCLoc(index)).getData()<child.getData()){
						child = getNodeAt(getRCLoc(index));
						
						childLoc = getRCLoc(index);
					}
					
				}
				if(child.getData()<root.getData()){
					heap.set(index, child);
					index = childLoc;
				}else{
					done = true;
				}
				
			}else{//no children
				done = true;
			}
		}
		
		heap.set(index, root);
		}
	return min;
	}
	
	public void PrintHeap(){
		for(int i=0; i<heap.size(); i++){
			System.out.print(heap.get(i).getData()+ " ");
		}
		System.out.println();
		
	}
	

}
