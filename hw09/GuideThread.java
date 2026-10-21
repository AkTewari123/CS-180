public class GuideThread extends Thread {

    @Override
    public void run() {
        try {
            for(int i = 0; i < 5; i++) {
                IO.println(Math.pow(2,i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}