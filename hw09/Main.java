public class Main {
    public static void main(String[] args) {
        try {
            GuideThread g1 = new GuideThread();
    
            IO.println("Thread Started");
            g1.start();
    
            g1.join();
    
    
            IO.println("Thread Finished");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
