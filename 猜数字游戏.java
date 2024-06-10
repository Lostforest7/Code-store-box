import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random r=new Random();
        System.out.println("请输入一个1-100的数字(第15次保底)");
        int number2= r.nextInt(100)+1;
        int count=0;
        while (true){
            int number1= scanner.nextInt();
            if (number1>number2){
                System.out.println("大了");
            } else if (number1<number2) {
                System.out.println("小了");
            }else {
                System.out.println("恭喜你猜对了😎");
                break;
            }
            count++;
            if (count==15){
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }
}
