package dars_49;

public class Task3 {
    public void result(){
        int[] list = {1, 3, 6, 8, 10, 18, 36};
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            result += list[i];
            System.out.println(result);
        }
    }
}
