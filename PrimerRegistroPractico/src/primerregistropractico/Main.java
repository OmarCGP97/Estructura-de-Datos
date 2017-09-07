
public class Main {
	
	public static void main(String[] args) {		
		ArrayList<Integer> iList = new ArrayList<Integer>();

		System.out.println("Testing toString");
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing addFirst(i | 0 <= i < 10) + toString");
		for(int i=0; i<10; i++) {
			iList.addFirst(i);
			System.out.println(iList);
		}
		System.out.println();
		
		System.out.println("Testing add(0, 10) + toString");
		iList.add(0, 10);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(size(), -1) + toString");
		iList.add(iList.size(), -1);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(3, 20) + toString");
		iList.add(3, 20);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(5, 15) + toString");
		iList.add(5, 15);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(7, 13) + toString");
		iList.add(7, 13);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing add(9, 11) + toString");
		iList.add(9, 11);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing getFirst");
		System.out.println("First element: " + iList.getFirst());
		System.out.println();
		
		System.out.println("Testing getLast + toString");
		System.out.println("Last element: " + iList.getLast());
		System.out.println();
		
		System.out.println("Testing get(5) + toString");
		System.out.println("Element at index 5: " + iList.get(5));
		System.out.println();
		
		System.out.println("Testing set(8, 33) + toString");
		System.out.println("Element at index 8 before inserting 33: " + iList.set(8, 33));
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing clear + toString");
		iList.clear();
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing addLast(i | 0 <= i < 10) + toString");
		for(int i=0; i<10; i++) {
			iList.addLast(i);
			System.out.println(iList);
		}
		System.out.println();
	}
}
