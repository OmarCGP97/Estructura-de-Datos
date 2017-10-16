package actividaded6;
public class Main {
	
	public static String checkForBalance(String toCheck) {
		Stack<Character> stack = new Stack<Character>();
                System.out.println(toCheck);
                char check = 0;
                String revision ="";
                toCheck.replaceAll("\\st","");
                for(int i=0; i<toCheck.length(); i++){
                    if(toCheck.charAt(i)=='('||toCheck.charAt(i)=='['||toCheck.charAt(i)=='{'){
                        stack.push(toCheck.charAt(i));
                    }
                    else if(toCheck.charAt(i)==')'||toCheck.charAt(i)==']'||toCheck.charAt(i)=='}'){
                        if(stack.empty()){
                            for(int n=0; n<i; n++)
                                revision += "";
                            revision += "^ Missing left symbol";
                            return revision;
                        }
                        check = stack.pop();
                        switch(toCheck.charAt(i)){
                        case')':
                            if(check!='('){
                                for(int n=0; n<i; n++)
                                    revision += "";
                                revision += "^ Missing left symbol";
                                return revision;
                            }
                            break;
                        case']':
                            if(check!='{'){
                                for(int n=0; n<i; n++)
                                    revision += "";
                                revision += "^ Missing left symbol";
                                return revision;
                            }
                            break;
                        case'}':
                            if(check!='{'){
                                for(int n=0; n<i; n++)
                                    revision += "";
                                revision += "^ Missing left symbol";
                                return revision;
                            }
                            break;
                        default:
                            break;
                        }
                    }
                }
                for(int n=0;n<toCheck.length();n++)
                    revision+="";
                if(stack.empty()==false){
                    revision+="^ Missing rigth symbol";
                    return revision;
                }
                
                revision+="Expression is balanced";
                return revision;
        }
	
	public static String postfixEval(String entrada) {
            Stack<Integer> expresion = new Stack<>();
            int count=0, count2=0;
            int right, left;
            String resultado;
            int nuevo=0,nuevo2=0,numeroNuevo=0;
            for(int i=0; i<entrada.length();i++){
                char symbol = entrada.charAt(i);
                if(symbol =='0'||symbol=='1'||symbol=='2'||symbol=='3'||symbol=='4'||symbol=='5'||symbol=='6'||symbol=='7'||symbol=='8'||symbol=='9'){
                    nuevo=Integer.parseInt(String.valueOf(symbol));
                    expresion.push(nuevo);
                    count++;
                }
                if(symbol=='+'||symbol=='/'||symbol=='*'||symbol=='-'){
                    count2++;
                    left=expresion.pop();
                    if(expresion.empty()==true){
                        return "The operation has too many operators";
                    }
                    right = expresion.pop();
                    numeroNuevo=GenerarOperacion(right,left,symbol);
                    expresion.push(numeroNuevo);
                    }
                }   
            if(count>count2+1){
                return "The expression has too many operands";
            }
            resultado = String.valueOf(numeroNuevo);
            return "Resultado de "+entrada+" : "+resultado+"";
	}
        
        public static int GenerarOperacion(int x, int y, char z){
            int numeroNuevo=0;
            if(z=='+'){
                numeroNuevo=x+y;
            }
            if(z=='-'){
                numeroNuevo=x-y;
            }
            if(z=='/'){
                numeroNuevo=x/y;
            }
            if(z=='*'){
                numeroNuevo=x*y;
            }
            return numeroNuevo;
        }
	
	public static void fibonacci(int n) {
            Queue<Integer> q = new Queue<Integer>();
            q.offer(1);
            q.offer(1);
            for(int i=0; i<= n-1;i++){
                int a = q.remove();
                int b = q.remove();
                System.out.print(a+" ");
                q.offer(b);
                q.offer(a+b);
            }
            System.out.println("");
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
	}
}
