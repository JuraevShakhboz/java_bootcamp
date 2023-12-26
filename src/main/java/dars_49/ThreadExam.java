package dars_49;

public class ThreadExam extends Thread{
    private volatile int counter = 0;

    public void count(){
        counter++;
    }

    public static void main(String[] args) {
        TestExam obj = new TestExam();
        for (int i = 0; i < 10; i++) {
        }
    }
}
