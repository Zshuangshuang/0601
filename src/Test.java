import java.util.Scanner;

public class Test {
    public static int fab(int n){
        if (n == 1 || n == 2) {
            return 1;
        }
        return fab(n-1)+fab(n-2);
    }
    public static  void move(char pos1,char pos3){

    }
    public static void hanoi(int n,char pos1,char pos3){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = fab(n);
        System.out.println(ret);
    }
}
