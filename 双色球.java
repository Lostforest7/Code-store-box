import java.util.Random;
import java.util.Scanner;

public class DoubleColorBall {
    public static void main(String[] args) {
        int[] machineArr = rng();  // 生成随机中奖号码
        int[] userArr = userInputLottery();  // 获取用户输入的号码
        int[] result = NumberOfWinners(machineArr, userArr);  // 计算中奖情况
        int redNumber = result[0];  // 中奖红球数
        int blueNumber = result[1];  // 中奖蓝球数

        // 判断中奖情况并打印对应信息
        if (redNumber == 6 && blueNumber == 1) {
            System.out.println("恭喜你中奖1000万");
        } else if (redNumber == 6 && blueNumber == 0) {
            System.out.println("恭喜你中奖500万");
        } else if (redNumber == 5 && blueNumber == 1) {
            System.out.println("恭喜你中奖3000元");
        } else if ((redNumber == 5 && blueNumber == 0) || (redNumber == 4 && blueNumber == 1)) {
            System.out.println("恭喜你中奖200元");
        } else if ((redNumber == 4 && blueNumber == 0) || (redNumber == 3 && blueNumber == 1)) {
            System.out.println("恭喜你中奖10元");
        } else if ((redNumber == 2 && blueNumber == 1) || (redNumber == 1 && blueNumber == 1) || (redNumber == 0 && blueNumber == 1)) {
            System.out.println("恭喜你中奖5元");
        } else {
            System.out.println("谢谢惠顾");
        }
    }

    // 用户输入号码
    public static int[] userInputLottery() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];  // 用户输入的号码数组
        // 输入红球号码
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("请输入第" + (i + 1) + "个红球");
            while (true) {
                int store = sc.nextInt();
                if (store >= 1 && store <= 33) {  // 检查红球号码范围
                    arr[i] = store;
                    break;
                } else {
                    System.out.println("数字超过可选范围");
                }
            }
        }
        // 输入蓝球号码
        System.out.println("请输入蓝球");
        while (true) {
            int store = sc.nextInt();
            if (store >= 1 && store <= 16) {  // 检查蓝球号码范围
                arr[arr.length - 1] = store;
                break;
            } else {
                System.out.println("数字超过可选范围");
            }
        }
        return arr;
    }

    // 随机生成中奖号码
    public static int[] rng() {
        Random r = new Random();
        int[] arr = new int[7];  // 中奖号码数组
        // 生成红球号码
        for (int i = 0; i < arr.length - 1;) {
            int store = r.nextInt(33) + 1;
            boolean flag = removeDuplication(arr, store);
            if (!flag) {  // 检查重复号码
                arr[i] = store;
                i++;
            }
        }
        // 生成蓝球号码
        arr[arr.length - 1] = r.nextInt(16) + 1;
        return arr;
    }

    // 检查是否有重复号码
    public static boolean removeDuplication(int[] arr, int store) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (store == arr[i]) {
                return true;
            }
        }
        return false;
    }

    // 判断用户中奖情况
    public static int[] NumberOfWinners(int[] machineArr, int[] userArr) {
        int redNumber = 0;  // 中奖红球数
        int blueNumber = 0;  // 中奖蓝球数
        // 计算中奖红球数
        for (int i = 0; i < machineArr.length - 1; i++) {
            for (int j = 0; j < userArr.length - 1; j++) {
                if (machineArr[i] == userArr[j]) {
                    redNumber++;
                }
            }
        }
        // 计算中奖蓝球数
        if (machineArr[machineArr.length - 1] == userArr[userArr.length - 1]) {
            blueNumber++;
        }
        int[] totaling = {redNumber, blueNumber};
        return totaling;
    }
}
