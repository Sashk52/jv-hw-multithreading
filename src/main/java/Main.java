public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThreadClass myThreadClass = new MyThreadClass(counter);
        Thread thread = new Thread(new MyRunnableClass(counter));
        myThreadClass.start();
        thread.start();
    }
}
