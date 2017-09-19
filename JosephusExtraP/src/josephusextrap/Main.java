package josephusextrap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        LinkedList lista = new LinkedList();
        //Elements es numero de elementos que se desean empezando de 1 al deseado//
        Scanner scann = new Scanner(System.in);
        System.out.println("De cuantos elementos se desea la lista, esta empezará desde 1: ");
        int elements = scann.nextInt();
        int range = elements+1;
        for(int i=1;i<range;i++){
            lista.addLast(i);
        }
        System.out.println();
        System.out.println("Cada cuantos saltos o pasos desea eliminar un elemento: ");
        int steps = scann.nextInt();
        lista.josephus(steps);

    }
}

