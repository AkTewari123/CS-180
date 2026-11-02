package challengerTwo;

public class Main {
    public static void main(String[] args) {
        try {
            ThreadSafeRegister tr = new ThreadSafeRegister(1, 0, 3, 2, 0, 0, 0);
            Thread t1 = new Thread(new ThreadRegister(tr));
    
            t1.run();
    
            t1.join();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
