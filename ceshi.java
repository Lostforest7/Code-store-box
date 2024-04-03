import java.util.Scanner;

public class ceshi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数");
        int a= scanner.nextInt();
        boolean b=true;
        for (int c=2;Math.sqrt(a)>c;c++){
            if (a%c==0){
                b=false;
                break;
            }
        }
        if (b){
            System.out.println("此数字为质数");
        }else {
            System.out.println("此数字为合数");
        }
    }
}