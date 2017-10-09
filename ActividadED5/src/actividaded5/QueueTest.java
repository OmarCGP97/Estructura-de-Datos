package actividaded5;

import java.util.*;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();

        // Adds elements {0, 1, 2, 3, 4} to queue
        for (int i = 0; i < 5; i++) {
            q.offer(i);
        }
        // Display contents of the queue.
        System.out.print("Elements of queue: ");
        Object[] objects = q.toArray();
        String retu = "[";
        for (Object obj : objects) {
            retu += obj + " ";
        }
        retu += "]";
        System.out.print(retu);
        System.out.println("");
        int ini = q.size();
        // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("Initial size of queue: " + ini);
        System.out.println("Removed element: " + removedele);

        System.out.print("Remaining elements after removal: ");
        Object[] objects1 = q.toArray();
        String retu1 = "[";
        for (Object obj : objects1) {
            retu1 += obj + " ";
        }
        retu1 += "]";
        System.out.print(retu1);

        System.out.println("");
        // To view the head of queue
        int head = q.element();
        System.out.println("Head of queue: " + head);

        // Rest all methods of collection interface,
        // Like size and contains can be used with this
        // implementation.
        int size = q.size();
        System.out.println("Size of queue after removal: " + size);

        q.clear();
        System.out.println("The queue is now clear");
        System.out.println("Trying is empty: " + q.isEmpty());
        
         System.out.println("");
        
        System.out.println("Linear Search Try: ");
        int[]test={1,2,4,6,8,9,12};
        System.out.println("Elemento esta en la posición: "+linearSearch(test,8));
        System.out.println("Binary Search Try: ");
        int[]test1={3,6,9,12,15,18,22};
        System.out.println("Elemento esta en la posición: "+binarySearch(test1,18));
        
        System.out.println("");
        
        System.out.println("Array Sort try: ");
        int[]arr1={88,34,21,22,76,3,2,12,666};
        System.out.println("Arreglo Original: ");
        for(int i:arr1){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Bubble type: ");
        int[]arr2=insertionSortB(arr1);
        System.out.println("Arreglo despues de ordenamiento ascendente: ");
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Insertion Sort: ");
        int[]arr3=insertionSort(arr1);
        System.out.println("Arreglo despues de ordenamiento ascendente: ");
        for(int i:arr3){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Selection Sort: ");
        int[]arr4=selectionSort(arr1);
        System.out.println("Arreglo despues de ordenamiento ascendente: ");
        for(int i:arr4){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println("");
    }
    
    public static int linearSearch(int[] arreglo, int objetivo){
        for(int i=0;i<arreglo.length;i++){
            if(arreglo[i]==objetivo){
                return i;
            }
            else if(arreglo[i]>objetivo){
                return -1;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] arreglo, int objetivo){
        int i=0;
        int min = 0;
        int max = arreglo.length;
        while(min<=max){
            int mid = (min+max)/2;
            
            if(objetivo < arreglo[mid]){
                max=mid-1;
            }
            else if(objetivo>arreglo[mid]){
                min =mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    
    public static int[] insertionSortB(int[] arreglo){
         
        int temp;
        for (int i = 1; i < arreglo.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arreglo[j] < arreglo[j-1]){
                    temp = arreglo[j];
                    arreglo[j] = arreglo[j-1];
                    arreglo[j-1] = temp;
                }
            }
        }
        return arreglo;
    }
    
    public static int[] insertionSort(int[]arreglo){
       for(int i=1; i<arreglo.length;i++){
           int Key=arreglo[i];
           int j = i-1;
           while(j>=0 && Key < arreglo[j]){
               int temp = arreglo[j];
               arreglo[j]=arreglo[j+1];
               arreglo[j+1]=temp;
               j--;
           }
       }
       return arreglo;
    }
    
    public static int[] selectionSort(int[]arreglo){
       int i,j,minValue,minIndex,temp=0;
        for(i=0; i<arreglo.length;i++){
           minValue = arreglo[i];
           minIndex = i;
           for(j=i; j<arreglo.length;j++){
               if(arreglo[j]< minValue){
                   minValue = arreglo[j];
                   minIndex = j;
               }
           }
           if(minValue < arreglo[i]){
               temp=arreglo[i];
               arreglo[i]=arreglo[minIndex];
               arreglo[minIndex]=temp;
           }
        }
        return arreglo;
    }
}
