package actividaded6;
public class Printer {
	private Queue<String> printerSpool;
	
	public Printer() {
		printerSpool = new Queue<String>();
	}
	
	public void printDocument(String name) {
		printerSpool.offer(name);
	}
	
	public void runPrinter() throws InterruptedException {
            boolean state = false;
            while(!printerSpool.isEmpty()){
                if(!state){
                    System.out.println("Printing "+printerSpool.remove());
                    state=true;
                    Thread.sleep(100);
                }
                else{
                    throw new InterruptedException();
                }
                state = false;
            }
            System.out.println("Finished printing documents");
	}
}
