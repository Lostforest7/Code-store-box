#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
	srand(time(NULL));
	int random = rand() % 100 + 1;
	int count = 0;
	printf("请输入一个1-100的数字\n");
	
	while (1)
	{
		int number;
		scanf("%d",&number);
		count++;
		if (count == 15)
		{
			printf("恭喜你保底了，你真是个小聪明蛋");
			break;
		}
		if (number > random)
		{
			printf("大了\n");
		}
		else if (number < random)
		{
			printf("小了\n");
		}
		else {
			printf("恭喜你猜中了ヾ(≧▽≦*)o");
			break;
		}
	}
}
