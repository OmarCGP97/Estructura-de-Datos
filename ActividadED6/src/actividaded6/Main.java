package actividaded6;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Vector;

public class Main {

    public static String checkForBalance(String toCheck) {
        Stack<Character> stack = new Stack<Character>();
        System.out.println(toCheck);
        char check = 0;
        String revision = "";
        toCheck.replaceAll("\\st", "");
        for (int i = 0; i < toCheck.length(); i++) {
            if (toCheck.charAt(i) == '(' || toCheck.charAt(i) == '[' || toCheck.charAt(i) == '{') {
                stack.push(toCheck.charAt(i));
            } else if (toCheck.charAt(i) == ')' || toCheck.charAt(i) == ']' || toCheck.charAt(i) == '}') {
                if (stack.empty()) {
                    for (int n = 0; n < i; n++) {
                        revision += "";
                    }
                    revision += "^ Missing left symbol";
                    return revision;
                }
                check = stack.pop();
                switch (toCheck.charAt(i)) {
                    case ')':
                        if (check != '(') {
                            for (int n = 0; n < i; n++) {
                                revision += "";
                            }
                            revision += "^ Missing left symbol";
                            return revision;
                        }
                        break;
                    case ']':
                        if (check != '{') {
                            for (int n = 0; n < i; n++) {
                                revision += "";
                            }
                            revision += "^ Missing left symbol";
                            return revision;
                        }
                        break;
                    case '}':
                        if (check != '{') {
                            for (int n = 0; n < i; n++) {
                                revision += "";
                            }
                            revision += "^ Missing left symbol";
                            return revision;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        for (int n = 0; n < toCheck.length(); n++) {
            revision += "";
        }
        if (stack.empty() == false) {
            revision += "^ Missing rigth symbol";
            return revision;
        }

        revision += "Expression is balanced";
        return revision;
    }

    public static String postfixEval(String entrada) {
        Stack<Integer> expresion = new Stack<>();
        int count = 0, count2 = 0;
        int right, left;
        String resultado;
        int nuevo = 0, nuevo2 = 0, numeroNuevo = 0;
        for (int i = 0; i < entrada.length(); i++) {
            char symbol = entrada.charAt(i);
            if (symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' || symbol == '4' || symbol == '5' || symbol == '6' || symbol == '7' || symbol == '8' || symbol == '9') {
                nuevo = Integer.parseInt(String.valueOf(symbol));
                expresion.push(nuevo);
                count++;
            }
            if (symbol == '+' || symbol == '/' || symbol == '*' || symbol == '-') {
                count2++;
                left = expresion.pop();
                if (expresion.empty() == true) {
                    return "The operation has too many operators";
                }
                right = expresion.pop();
                numeroNuevo = GenerarOperacion(right, left, symbol);
                expresion.push(numeroNuevo);
            }
        }
        if (count > count2 + 1) {
            return "The expression has too many operands";
        }
        resultado = String.valueOf(numeroNuevo);
        return "Resultado de " + entrada + " : " + resultado + "";
    }

    public static int GenerarOperacion(int x, int y, char z) {
        int numeroNuevo = 0;
        if (z == '+') {
            numeroNuevo = x + y;
        }
        if (z == '-') {
            numeroNuevo = x - y;
        }
        if (z == '/') {
            numeroNuevo = x / y;
        }
        if (z == '*') {
            numeroNuevo = x * y;
        }
        return numeroNuevo;
    }

    public static void fibonacci(int n) {
        Queue<Integer> q = new Queue<Integer>();
        q.offer(1);
        q.offer(1);
        for (int i = 0; i <= n - 1; i++) {
            int a = q.remove();
            int b = q.remove();
            System.out.print(a + " ");
            q.offer(b);
            q.offer(a + b);
        }
        System.out.println("");
    }

    //Ejercicios de repaso del segundo parcial
    public static String convertInfixtoPostfix(String expr) {
        Stack<Character> cadena = new Stack<Character>();
        String resultado = new String("");

        for (int i = 0; i < expr.length(); i++) {
            char symbol = expr.charAt(i);
            if (Character.isLetterOrDigit(symbol)) {
                resultado += symbol;
            } else if (symbol == '(') {
                cadena.push(symbol);
            } else if (symbol == ')') {
                while (!cadena.empty() && cadena.peek() != '(') {
                    resultado += cadena.pop();
                }
                if (!cadena.empty() && cadena.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    cadena.pop();
                }
            } else {
                while (!cadena.empty() && hasHigherPrecedence(symbol) <= hasHigherPrecedence(cadena.peek())) {
                    resultado += cadena.pop();
                }
                cadena.push(symbol);
            }
        }
        while (!cadena.empty()) {
            resultado += cadena.pop();
        }
        return resultado;
    }

    public static int hasHigherPrecedence(Character cha) {
        switch (cha) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static public void nextGreatElement(int[] cadena) {
        int next, i, j;
        for (i = 0; i < cadena.length; i++) {
            next = -1;
            for (j = i + 1; j < cadena.length; j++) {
                if (cadena[i] < cadena[j]) {
                    next = cadena[j];
                    break;
                }
            }
            System.out.println(cadena[i] + " -> " + next);
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> data) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!data.empty()) {
            // pop out the first element
            int tmp = data.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while (!tmpStack.empty() && tmpStack.peek() > tmp) {
                // pop from temporary stack and 
                // push it to the input stack
                data.push(tmpStack.pop());
            }
            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }
    
    public static int maxLength(String str){
        int length = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < str.length(); i++){
            if (left < right){
                return -1;
            }
            if (str.charAt(i) == '('){
                left++;
            }
            else if (str.charAt(i) == ')'){
                right++;
            }
            else{
                length = Math.max(left - right, length);
            }
        }
        
        if (left == 0 && right == 0){
            return 0;
        }
        if (left != right){
            return -1;
        }
        return length;
    }
    
    public static int maxLengthStack(String str){
        int n = str.length();
        if (n == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<Character>();
        char c = '\0';
        int maxLength = 0;
        for (int i = 0; i < n; i++){
            c = str.charAt(i);
            if (c == '('){
                stack.push(c);
            }
            else if (c == ')'){
                maxLength = Math.max(maxLength, stack.size());
                stack.pop();
            }
        }
        if (stack.size() != 0){
            return -1;
        }
        return maxLength;
    }
    
    public static void reverseQueueFirstKElements(int k,Queue<Integer> queue) {
        if (queue.isEmpty() == true || k > queue.size())
            return;
        if (k <= 0)
            return;
 
        Stack<Integer> stack = new Stack<Integer>();
 
        // Push the first K elements into a Stack 
        for (int i = 0; i < k; i++) {
            stack.push(queue.element());
            queue.remove();
        }
 
         
        // Enqueue the contents of stack at the back 
        // of the queue
        while (!stack.empty()) {
            queue.offer(stack.peek());
            stack.pop();
        }
 
         
        // Remove the remaining elements and enqueue 
        // them at the end of the Queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.element());
            queue.remove();
        }
    }
 
    // Utility Function to print the Queue 
    public static void Print(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.element() + " ");
            queue.remove();
        }
    }
    
    public static void printInt(Queue<Integer> queue) {
        for (int i = 0; i < queue.size(); i++) {
            int n = queue.remove();
            System.out.print(n+" ");
            queue.offer(n);
        }
    }
    
    public static Queue<Integer> interLeave(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> s = new Stack<Integer>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            s.push(q.remove());
        }

        while (!s.empty()) {
            q.offer(s.pop());
        }

        for (int i = 0; i < size / 2; i++) {
            s.push(q.remove());
        }

        while (!s.empty()) {
            q.offer(s.pop());
            q.offer(q.remove());
        }

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.empty()) {
            q.offer(s.pop());
        }
        return q;
    }
    
    public static Queue<String> generatePrintBinary(int n) {
        // Create an empty queue of strings
        Queue<String> q = new Queue<String>();

        // Enqueue the first binary number
        q.offer("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while (n-- > 0) {
            // print the front of queue
            String s1 = q.element();
            q.remove();
            System.out.print(s1 + " ");

            // Store s1 before changing it
            String s2 = s1;

            // Append "0" to s1 and enqueue it
            q.offer(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains
            // the previous front
            q.offer(s2 + "1");
        }
        return q;
    }

    public static LinkedList<Integer> mergeLinkedSorted(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            // System.out.println(a.head.data + " " + b.head.data);
            if (a.getFirst() < b.getFirst()) {
                result.addLast(a.getFirst());
                a.removeFirst();
            } else {
                result.addLast(b.getFirst());
                b.removeFirst();
            }
        }
        while (!a.isEmpty()) {
            result.addLast(a.getFirst());
            a.removeFirst();
        }
        while (!b.isEmpty()) {
            result.addLast(b.getFirst());
            b.removeFirst();
        }
        return result;
    }
    
    public static String reverseParentheses(String expresion){
        Stack<Character> sentence = new Stack<>();
        String resultado = new String("");
        
        for (int i = 0; i < expresion.length(); i++) {
            resultado += expresion.charAt(i);
            if (expresion.charAt(i) == '(' ) {
                if(expresion.charAt(i)!=')'){
                    sentence.push(expresion.charAt(i+2));
                }
            resultado+= sentence.pop();
            } 
        }
        return resultado;
    }
    
    public static void quickSort(int values[], int start, int end){
        //If the list has no more than one element, its already sorted
        if(start >= end){
            return;
        }
        //Use the first item as the dividing item
        int divider = values[start];
        //Move items < divisor to the front of the array and
        //items >= divider to the end of the array
        Stack<Integer> before = new Stack<Integer>();
        Stack<Integer> after = new Stack<Integer>();
        for(int i=start+1; i<= end; i++){
            if(values[i]<divider){
                before.push(values[i]);
            }else{
                after.push(values[i]);
            }
        }
        int i = start;
        while(!before.empty()){
            values[i++]= before.pop();
        }
        int middle = i++;
        values[middle]=divider;
        while(!after.empty()){
            values[i++]= after.pop();
        }
        //Recursively sort the two halves
        quickSort(values,start,middle-1);
        quickSort(values,middle+1,end);
    }
    
    public static void mergeSort(int[] values, int[] scratch, int start, int end){
        if(start>=end){
            return;
        }
        int midpoint = (start + end)/2;
        mergeSort(values, scratch, start, midpoint);
        mergeSort(values, scratch, midpoint+1, end);
        
        int leftIndex = start;
        int rigthIndex = midpoint+1;
        int scratchIndex = leftIndex;
        
        while(leftIndex <= midpoint && rigthIndex <= end){
            if(values[leftIndex]<=values[rigthIndex]){
                scratch[scratchIndex]=values[leftIndex];
                leftIndex = leftIndex+1;
            }
            else{
                scratch[scratchIndex]=values[rigthIndex];
                rigthIndex = rigthIndex+1;
            }
            scratchIndex+=1;
            }
        for(int i = leftIndex; i <= midpoint; i++){
            scratch[scratchIndex]= values[i];
            scratchIndex++;
        }
        for(int i = rigthIndex; i<= end; i++){
            scratch[scratchIndex]= values[i];
            scratchIndex++;
        }
        for(int i = start; i<= end; i++){
            values[i]=scratch[i];
        }
    }
    
    // Recursive function to return gcd of a and b
    public static int GCD(int a, int b){
        // Everything divides 0 
        if (a == 0 || b == 0)
           return 0;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return GCD(a-b, b);
        return GCD(a, b-a);
    }
    
    /* Function to calculate x raised to the power y */
    public static int pow(int x, int y){
    if (y == 0){
        return 1;
    }
    else if (y%2 == 0){
        return pow(x, y/2)*pow(x, y/2);
    }
    else{
        return x*pow(x, y/2)*pow(x, y/2);
    }
    }
    
    public static void toBinary(int n){
    String resultado = "";
        /* step 1 */
    if (n > 1)
        toBinary(n/2);
 
    /* step 2 */
    System.out.printf("%d", n%2);
    }
    
    public static int count(String s, char c)
    {
        int res = 0;
 
        for (int i=0; i<s.length(); i++)
        {
            // checking character in string
            if (s.charAt(i) == c)
            res++;
        } 
        return res;
    }
    
    public static int count(LinkedList<Integer> a, int x){
        int res = 0;
 
        for (int i=0; i<a.size(); i++)
        {
            // checking character in string
            if (a.get(i)== x){
                res++;
            }
        } 
        return res;
    }
 
    public static int consecutiveAddition(int value){
        if (value > 0)
        {
          return value + consecutiveAddition(value - 1);
        }
        else
        {
            return 0;
        }
    }
    
    public static Queue<Integer> mergeQueueSorted(Queue<Integer> a, Queue<Integer> b) {
        Queue<Integer> result = new Queue<Integer>();
        while (!a.isEmpty() && !b.isEmpty()) {
            // System.out.println(a.head.data + " " + b.head.data);
            if (a.element() < b.element()) {
                result.offer(a.element());
                a.remove();
            } else {
                result.offer(b.element());
                b.remove();
            }
        }
        while (!a.isEmpty()) {
            result.offer(a.element());
            a.remove();
        }
        while (!b.isEmpty()) {
            result.offer(b.element());
            b.remove();
        }
        return result;
    }
    
    //Examen del Tercer Registro
    
    public static String allStar(String str) {
        if (str.equals("") || str.length() == 1){
            return str;
        }else{
            return str.charAt(0) + "*" + allStar(str.substring(1));
        }
    }
    
    public static int maxDepth(String str){
        int n = str.length();
        if (n == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<Character>();
        char c = '\0';
        int maxLength = 0;
        for (int i = 0; i < n; i++){
            c = str.charAt(i);
            if (c == '('){
                stack.push(c);
            }
            else if (c == ')'){
                maxLength = Math.max(maxLength, stack.size());
                stack.pop();
            }
        }
        if (stack.size() != 0){
            return -1;
        }
        return maxLength;
    }
    
    public static String endX(String str) {
        if (str.equals("")){
            return str;
        }
        if (str.charAt(0) == 'x'){
            return endX(str.substring(1)) + 'x';
        }else{
            return str.charAt(0) + endX(str.substring(1));
        }
    }
    
    public static int shapeArea(int n){
        if ( n == 1){
            return 1;
        }
       return 4*(n-1)+shapeArea(n-1); 
    }
    
    public static void executeIA(){ 
        System.out.println("Voy a adivinar el animal en el que piensas\n"); 
        BinaryNodeS root=new BinaryNodeS("Este respira aire?"); 
        root.LeftChild=new BinaryNodeS("Perro");root.RigthChild=new BinaryNodeS("Pescado"); 
        Scanner in=new Scanner(System.in); 
        boolean condition=true; 
        while(condition){ 
            root.Pensar(); 
            System.out.println("¿Desea volver a intentarlo?"); 
            String r=in.nextLine(); 
            if(r.equalsIgnoreCase("N")||r.equalsIgnoreCase("No")) 
                condition=false; 
        } 
        System.out.println("Gracias por participar"); 
    }
    
    public static int treeSize(BinaryNode node){
        int count = 1;
        if(node.LeftChild != null){
            count += treeSize(node.LeftChild);
        }
        if(node.RigthChild != null){
            count += treeSize(node.RigthChild);
        }
        return count;
    }
    
    public static int countOneChild(BinaryNode node){
        if(node.LeftChild!=null){
            if(node.RigthChild!=null){
                return countOneChild(node.LeftChild)+countOneChild(node.RigthChild);
            }else{
                return countOneChild(node.LeftChild)+1;
            }
        }
        if(node.RigthChild!=null){
            if(node.LeftChild!=null){
                return countOneChild(node.LeftChild)+countOneChild(node.RigthChild);
            }else{
                return countOneChild(node.RigthChild)+1;
            }
        }else{
            return 0;
        }
    }
    
    public static String allStar1(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return str.substring(0, 1) + "*" + allStar(str.substring(1));

    }

    public static String endX1(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.substring(0, 1).equals("x")) {
            return endX(str.substring(1)) + "x";
        } else {
            return str.substring(0, 1) + endX(str.substring(1));
        }
    }

    public static int maxDepth1(String exp) {
        int depth = 0;
        int open = 0;
        int close = 0;
        Stack<String> comparing = new Stack<String>();
        depth = comparing.size();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                comparing.push("(");
                open++;
                if (comparing.size() > depth) {
                    depth = comparing.size();
                }

            }
            if (exp.charAt(i) == ')') {
                comparing.pop();
                close++;
            }
        }
        if (comparing.empty() && open == close) {
            return depth;
        } else {
            return -1;
        }
    }
    
    public static String primeFactors(int n){
        String result = "";
        while (n%2==0)
        {
            result += (2 + ",");
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                result += (i + ",");
                n /= i;
            }
        }
        if (n > 2){
            result += n;
        }
        return result;
    }
    
    //Problema 5
    public static String cleanString(String str){
        String resultado = str.replaceAll("[^a-zA-Z]", "");
        return resultado.toUpperCase();
    }
    
    //Problema 6
    public static int mystery(int m, int n){
        if(m == 0){
            return n + 1;
          }else if(m > 0 && n == 0){
              return mystery(m - 1, 1);
            }else if(m > 0 && n > 0){
              return mystery(m - 1, mystery(m, n-1));
            }else{
                return mystery(m , n);
            }
    }
    
    //Problema 8
    public static LinkedList<Integer> union(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> intersection = new LinkedList<Integer> ();
            while(!list1.isEmpty()){
                intersection.addLast(list1.removeFirst());
            }
            while(!list2.isEmpty()){
                intersection.addLast(list2.removeFirst());
            }
        return intersection;
    }
    
    //Problema 11
    public static void moveToBeginning(LinkedList<Integer> lista, int i){
        if (i < 0 || i >= lista.size()){
            throw new IndexOutOfBoundsException();
       }
        lista.addFirst(lista.remove(i));
    }
    
    //Problema 15
    public static void superSort(String arr[]) {
        if (arr.length == 0) {
            return;
        }
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            if (m < arr[i].length()) {
                m = arr[i].length();
            }
        }
        int bucketC = 10;
        HashMap<Character, Vector<String>> buckets = new HashMap<Character, Vector<String>>(bucketC);
        char a = '0';
        for (int i = 0; i <= bucketC; i++, a++) {
            buckets.put(a, new Vector<String>());
        }
        for (int i = 0; i < arr.length; i++) {
            String now = arr[i];
            char character = now.charAt(0);
            buckets.get(character).add(arr[i]);
        }
        int index = 0;
        for (char clave = '0'; clave <= '9'; clave++) {
            Vector<String> bucket = buckets.get(clave);
            for (int i = 1; i < bucket.size(); i++) {
                String result = bucket.get(i);
                bucket.remove(i);
                int j;
                for (j = i - 1; j >= 0 && bucket.get(j).compareToIgnoreCase(result) > 0; j--) {
                    bucket.add(j + 1, bucket.get(j));
                    bucket.remove(j);
                }
                bucket.add(j + 1, result);
            }
            for (int j = 0; j < bucket.size(); j++) {
                arr[index++] = bucket.get(j);
            }
        }
    }
    
    public static void moveToTop(Stack<Integer> stack, int i){
        Stack<Integer> temp = new Stack<Integer>();
        while(stack.peek() != i){
            int quitar = stack.peek();
            stack.pop();
            temp.push(quitar);
        }stack.pop();
        while(!temp.empty()){
            int value = temp.peek();
            temp.pop();
            stack.push(value);
        }
        stack.push(i);
    }
    
    public static void main(String[] args) {
        System.out.println("Testing balanced symbols");
        System.out.println(checkForBalance("t = arr[3] + a) - 4"));
        System.out.println(checkForBalance("if (arr(3] < 4)"));
        System.out.println(checkForBalance("System.out.println(std.charAt(3);"));
        System.out.println(checkForBalance("while (i > 100) { sum += i; i++; }"));
        System.out.println();

        System.out.println("Testing postfix evaluation");
        System.out.println("4 3 5 * + => " + postfixEval("4 3 5 * +"));
        System.out.println("1 2 * 3  4 / - => " + postfixEval("1 2 * 3 4 / -"));
        System.out.println("1 2 * 3 * 4 * 5 * 6 * => " + postfixEval("1 2 * 3 * 4 * 5 * 6 *"));
        System.out.println("1 2 3 * 4 + 5 / + => " + postfixEval("1 2 3 * 4 + 5 / +"));
        System.out.println("2 2 * 4 1 * 3 * - 2 1 * / => " + postfixEval("2 2 * 4 1 * 3 * - 2 1 * /"));
        System.out.println("3 8 + * 9 => " + postfixEval("3 8 + * 9"));
        System.out.println("9 8 + 7 => " + postfixEval("9 8 + 7"));
        System.out.println();

        System.out.println("Testing Fibonacci sequence");
        fibonacci(20);
        System.out.println();

        System.out.println("Testing the Printer class");
        Printer printer = new Printer();
        printer.printDocument("gato.jpg");
        printer.printDocument("tarea.docx");
        printer.printDocument("meme.png");
        try {
            printer.runPrinter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Testing InfixToPostfix");
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(convertInfixtoPostfix(exp));
        System.out.println("");
        System.out.println("Testing Next Greater Element");
        int arr[] = {11, 13, 21, 3};
        nextGreatElement(arr);

        System.out.println("");
        System.out.println("Testing SortingStack");
        Stack<Integer> input = new Stack<Integer>();
        input.push(34);
        input.push(3);
        input.push(31);
        input.push(98);
        input.push(92);
        input.push(23);

        // This is the temporary stack
        Stack<Integer> tmpStack = sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty()) {
            System.out.print(tmpStack.pop() + " ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Nested parentesis deepness");
        String s = "( ((X)) (((Y))) )";
        System.out.println("String: "+s);
        System.out.println("Maximum Deepness: "+maxLengthStack(s));
        System.out.println("Maximum Deepness: "+maxLength(s));
        
        System.out.println("");
        System.out.println("Testing Reversing N elements in Queue");
        Queue<Integer> queue = new Queue<Integer>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70);
        queue.offer(80);
        queue.offer(90);
        queue.offer(100);
        
        System.out.println("Original Queue: ");
        System.out.println("[10,20,30,40,50,60,70,80,90,100]");
        int k = 5;
        reverseQueueFirstKElements(k,queue);
        Print(queue);
        
        System.out.println("");
        System.out.println("");
        System.out.println("Testing Interleave elements in Queue");
        Queue<Integer> q = new Queue<Integer>();
        q.offer(11);
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.offer(15);
        q.offer(16);
        q.offer(17);
        q.offer(18);
        q.offer(19);
        q.offer(20);
        
        System.out.print("Original Queue: ");
        System.out.println("[11,12,13,14,15,16,17,18,19,20]");
        System.out.print("Interleave: ");
        Print(interLeave(q));
        System.out.println("");
        System.out.println("");
        
        System.out.println("Testing Binary Generator Queue: ");
        generatePrintBinary(10);
        System.out.println("");
        
        System.out.println("");
        System.out.println("Testing mergin two sorted Linked Lists");
        LinkedList<Integer> a = new LinkedList<Integer>();
        LinkedList<Integer> b = new LinkedList<Integer>();
        a.addFirst(19);
        a.addFirst(12);
        a.addFirst(5);
        System.out.println("List a: "+a);
        b.addFirst(20);
        b.addFirst(9);
        b.addFirst(2);
        System.out.println("List b: "+b);
        System.out.println("Merged: "+mergeLinkedSorted(a,b));
        
        //System.out.println("Testing Reversing Parentheses");
        //String evaluacion = "!Mi examen de estructura de datos!";
        //System.out.println("Tested: "+reverseParentheses(evaluacion));
        //String evaluacion2 = "a(bc)de";
        //System.out.println("Tested: "+reverseParentheses(evaluacion2));
        //String evaluacion3 = "(ab)(cd)(ef)";
        //System.out.println("Tested: "+reverseParentheses(evaluacion3));
        
        int[] arr6 = {23,1224,56321,121,11,233,123,56,78};
        System.out.println("Before QuickSort: "+ Arrays.toString(arr6));
        quickSort(arr6,0,arr6.length-1);
        System.out.println("After QuickSort: "+Arrays.toString(arr6));
        System.out.println("");
        int[] uArray = {231,1200,5600,12,11,233,121,56,738};
        int[] scratch = new int[uArray.length];
        System.out.println("Before MergeSort: "+ Arrays.toString(uArray));
        mergeSort(uArray,scratch,0,uArray.length-1);
        System.out.println("After MergeSort: "+Arrays.toString(uArray));
        
        System.out.println("");
        int uno = 98, dos = 56;
        System.out.println("GCD of " + uno +" and " + dos + " is " + GCD(uno, dos));
        System.out.println("");
        
        int x = 2;
        int y = 3;
        System.out.print("Number "+x+", elevated to "+y+" is: ");
        System.out.println(pow(x, y));
        
        System.out.println("");
        System.out.print("Binary representation of 7 is: ");
        toBinary(7);
        System.out.println("");
        System.out.print("Binary representation of 4 is: ");
        toBinary(4);
        System.out.println("");
        System.out.println("");
        
        LinkedList<Integer> c = new LinkedList<Integer>();
        c.addFirst(5);
        c.addFirst(12);
        c.addFirst(5);
        c.addFirst(10);
        c.addFirst(5);
        int z = 5;
        System.out.println("Times of "+z+" in the list: "+count(c,z));
        System.out.println("");
        
        LinkedList<Integer> d = new LinkedList<Integer>();
        d.addFirst(9);
        d.addFirst(5);
        d.addFirst(5);
        d.addFirst(10);
        d.addFirst(21);
        int g = 5;
        System.out.println("The last index of "+g+" is:");
        System.out.println(d.lastIndexOf(g));
        
        System.out.println("");
        Queue<Integer> q1 = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();
        q1.offer(10);
        q1.offer(20);
        q1.offer(30);
        q1.offer(40);
        q2.offer(15);
        q2.offer(25);
        q2.offer(50);
        q2.offer(80);
        
        System.out.println("Testing MergeQueueSort with: ");
        printInt(q1);
        System.out.println("");
        printInt(q2);
        System.out.println("");
        System.out.print("Both Queues Sorted: ");
        Print(mergeQueueSorted(q1,q2));
        System.out.println("");
        System.out.println("");
        
        LinkedList<Integer> u = new LinkedList<Integer>();
        u.addFirst(9);
        u.addFirst(5);
        u.addFirst(5);
        u.addFirst(10);
        u.addFirst(21);
        System.out.println("The maximum value is: "+u.max(u));
        System.out.println("");
        //System.out.println("RemoveFirstOcurrence: "+removeFirstOcurrence(u,5));
        
        System.out.println("Consecutive Addition of 9: "+consecutiveAddition(9));
        System.out.println("");
        System.out.println("Examen del tercer registro: ");
        System.out.println("");
        System.out.println("Trying allStar with Hello: "+allStar("Hello"));
        System.out.println("Trying allStar with abc: "+allStar("abc"));
        System.out.println("");
        System.out.println("Trying MaxDepth with \"(p((q))((s)t))\": "+maxDepth("(p((q))((s)t))"));
        System.out.println("Trying MaxDepth with (\"\"): "+maxDepth(""));
        
        System.out.println("");
        System.out.println("Trying endX with rexx: "+endX("rexx"));
        System.out.println("Trying endX with xxhixx: "+endX("xxhixx"));
        
        System.out.println("");
        System.out.println("Trying intersect with: ");
        System.out.println("List a: [0,1,2,3,4,5,6,7,8,9]");
        System.out.println("List b: [5,6,7,8,9,10,11,12,13,14,15]");
        LinkedList<Integer> w = new LinkedList<Integer>();
        w.addFirst(9);
        w.addFirst(8);
        w.addFirst(7);
        w.addFirst(6);
        w.addFirst(5);
        w.addFirst(4);
        w.addFirst(3);
        w.addFirst(2);
        w.addFirst(1);
        w.addFirst(0);
        LinkedList<Integer> p = new LinkedList<Integer>();
        p.addFirst(15);
        p.addFirst(14);
        p.addFirst(13);
        p.addFirst(12);
        p.addFirst(11);
        p.addFirst(10);
        p.addFirst(9);
        p.addFirst(8);
        p.addFirst(7);
        p.addFirst(6);
        p.addFirst(5);
        LinkedList<Integer> v = new LinkedList<Integer>();
        System.out.println("Intersection is: "+v.intersect(w,p));
        
        System.out.println("");
        System.out.println("Trying difference with: ");
        System.out.println("List a: [0,1,2,3,4,5,6,7,8,9]");
        System.out.println("List b: [5,6,7,8,9,10,11,12,13,14,15]");
        LinkedList<Integer> f = new LinkedList<Integer>();
        System.out.println("Difference is: "+f.difference(w,p));
        
        System.out.println("");
        System.out.println("Trying shapeArea with: ");
        System.out.println("Area of 3: "+shapeArea(3));
        System.out.println("Area of 4: "+shapeArea(4));
        System.out.println("Area of 5: "+shapeArea(5));
        
        System.out.println("");
        System.out.println("Trying addNode: ");
        BinaryNode root=new BinaryNode(0);
        System.out.println("Empty Tree");
        root.preorderTraversal();
        for (int i=0;i<22;i++){
            root.addNode(i);
            System.out.println();
            root.inorderTraversal();
        }
        System.out.println();
        System.out.println();
        System.out.println("Find Node");
        System.out.println(root.findNode(7).value);
        System.out.println();
        System.out.println("inOrder Traversal");
        root.inorderTraversal();
        System.out.println();
        System.out.println();
        System.out.println("postOrder Traversal");
        root.postorderTraversal();
        System.out.println();
        
        System.out.println();
        System.out.println("Tree Size");
        System.out.println(treeSize(root));
        
        BinaryNode root2=new BinaryNode(0);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);
        BinaryNode node7 = new BinaryNode(7);
        
        root2.LeftChild=node2;
        root2.RigthChild=node6;
        node2.LeftChild=node3;
        node3.LeftChild=node4;
        node3.RigthChild=node5;
        root2.RigthChild=node6;
        node6.LeftChild=node7;
        
        System.out.println();
        System.out.println("Count One Child");
        System.out.println(countOneChild(root2));
        
        System.out.println();
        System.out.println("Probando Inteligencia Artificial: No");
        System.out.println();
        //executeIA();
        
        //Ejercicios previos al examen//
        System.out.println("Testing Prime Factors of 60: ");
        System.out.println(primeFactors(60));
        System.out.println();
        
        System.out.println("Trying reverseOrder");
        System.out.println("List a: [0,1,2,3,4,5,6,7,8,9]");
        LinkedList<Integer> r = new LinkedList<Integer>();
        r.addFirst(9);
        r.addFirst(8);
        r.addFirst(7);
        r.addFirst(6);
        r.addFirst(5);
        r.addFirst(4);
        r.addFirst(3);
        r.addFirst(2);
        r.addFirst(1);
        r.addFirst(0);
        r.reverseOrder(1,7);
        System.out.println("reversedOrder: "+r);
        System.out.println("");
        
        System.out.println("Trying countValue and countDuplicates");
        System.out.println("List a: [3,2,2,2,2,2,6,7,8,2]");
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.addFirst(2);
        l.addFirst(8);
        l.addFirst(7);
        l.addFirst(6);
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(2);
        l.addFirst(3);
        System.out.println("countDuplicates of 2: "+l.countDuplicates());
        System.out.println("CountValue of 2: "+l.countValue2(l,2));
        
        System.out.println("");
        System.out.println("Trying remove from Stack");
        Stack<Integer> pila = new Stack<>();
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(2);
        pila.push(5);
        System.out.println("Removed Element: "+pila.remove(1));
        System.out.println("Stack new size: "+pila.size());
        System.out.println("");
        
        //Examen Final Estructura de Datos
        //Codigos de Prueba
        //Omar Alejandro Castañeda Gomez A01373707
        
        System.out.println("Examen Final Pruebas");
        System.out.println("");
        System.out.println("Testing moveToBeginning: ");
        System.out.println("List a: [1,2,3,4,5,6]");
        LinkedList<Integer> e = new LinkedList<Integer>();
        e.addFirst(6);
        e.addFirst(5);
        e.addFirst(4);
        e.addFirst(3);
        e.addFirst(2);
        e.addFirst(1);
        moveToBeginning(e,3);
        System.out.println("Resultado"+e);
        System.out.println("");
        System.out.println("Testing Union");
        LinkedList<Integer> i = new LinkedList<Integer>();
        i.addFirst(5);
        i.addFirst(4);
        i.addFirst(3);
        i.addFirst(2);
        i.addFirst(1);
        i.addFirst(0);
        System.out.println("List a: [0,1,2,3,4,5]");
        System.out.println("List b: [5,6,7,8]");
        LinkedList<Integer> t = new LinkedList<Integer>();
        t.addFirst(8);
        t.addFirst(7);
        t.addFirst(6);
        t.addFirst(5);
        System.out.println("Resultado"+union(i,t));
        System.out.println("");
        System.out.println("Testing CleanString");
        System.out.println(cleanString("Omar234Ale*#4jandro"));
        System.out.println(cleanString("H*o*l+a"));
        System.out.println(cleanString("B´i-e*n"));
        System.out.println("");
        System.out.println("Testing Get");
        Stack<Integer> Pila = new Stack<>();
        Pila.push(2);
        Pila.push(3);
        Pila.push(4);
        Pila.push(2);
        Pila.push(5);
        System.out.println("Stack: [5,2,4,3,2]");
        System.out.print("Get value of position 4: ");
        System.out.println(Pila.get(4));
        System.out.println("");
        System.out.println("Testing Mystery");
        System.out.println("For 0 and 1: "+mystery(0,1));
        System.out.println("For 2 and 4: "+mystery(2,4));
        System.out.println("For 1 and 4: "+mystery(1,4));
        System.out.println("For 3 and 2: "+mystery(3,2));
        //System.out.println("For 3 and 2: "+mystery(4,1));
        System.out.println("");
        System.out.println("Testing superSort");
        System.out.println("Original Array: [\"123\",\"398\",\"210\",\"019\",\"528\",\"003\",\"513\",\"129\",\"220\",\"294\"]");
        String [] arr1 = {"123","398","210","019","528","003","513","129","220","294"};
        System.out.print("Changed Array: ");
        superSort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("");
        System.out.println("Testing MoveToTop");
        Stack<Integer> Pila2 = new Stack<Integer>();
        Pila2.push(9);
        Pila2.push(6);
        Pila2.push(5);
        Pila2.push(3);
        System.out.println("Original Stack: [3,5,6,9]");
        moveToTop(Pila2,9);
        System.out.println("Stack Changed: "+Arrays.toString(Pila2.toArray()));
        System.out.println("");
        System.out.println("Fin de Examen Final Pruebas");
        
    }
}
