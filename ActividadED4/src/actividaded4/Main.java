import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Testing array reversing");
		int[] inputArray = {1, 2, 3, 4, 5};
		
		Stack<Integer> stack = new Stack<Integer>();
                for (int i=0;i<inputArray.length;i++){
                    stack.push(inputArray[i]);
                }
		
		int[] outputArray = new int[inputArray.length];
		for (int i=0;i<inputArray.length;i++){
                    outputArray[i]=stack.pop();
                }
                
		System.out.println("Input: " + Arrays.toString(inputArray));
		System.out.println("Output: " + Arrays.toString(outputArray));
		System.out.println();
		
		System.out.println("Testing train ordering");
		Stack<Integer> train = new Stack<Integer>();
		train.push(3);
		train.push(2);
		train.push(1);
		train.push(3);
		train.push(2);
		
		System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));
                
                train.pop();
                train.pop();
                train.pop();
                train.pop();
                train.push(3);
                train.push(2);
                train.push(2);
                train.push(1);
		
		System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
		System.out.println();
		
		Stack<Integer> towerOne = new Stack<Integer>();
		Stack<Integer> towerTwo = new Stack<Integer>();
		Stack<Integer> towerThree = new Stack<Integer>();
		
		towerOne.push(3);
		towerOne.push(2);
		towerOne.push(1);
		
		System.out.println("At the beginning");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		
		towerOne.pop();
		towerTwo.push(3);
                towerOne.pop();
		towerTwo.push(2);
                towerOne.pop();
		towerTwo.push(1);
                
		System.out.println("At the end");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		System.out.println();
	}
}
