package actividaded6;

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
            System.out.println(n);
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
        
        System.out.println("Testing Reversing Parentheses");
        String evaluacion = "!Mi examen de estructura de datos!";
        System.out.println("Tested: "+reverseParentheses(evaluacion));
        String evaluacion2 = "a(bc)de";
        System.out.println("Tested: "+reverseParentheses(evaluacion2));
        String evaluacion3 = "(ab)(cd)(ef)";
        System.out.println("Tested: "+reverseParentheses(evaluacion3));
        
    }
}
