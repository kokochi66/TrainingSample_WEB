#include <stdio.h>
#include <string.h>
//�迭���� -1��ġ�� ������ �������� ũ�� ������ �����ϴ� �Լ� 
char * reverseInParentheses(char * inputString);
char* passParentheses(char* input, int left, int right);
int main() {
	char str[100] = "foo(bar(baz))blim";
	printf("%s",reverseInParentheses(str));
}

char* passParentheses(char* input, int left, int right){
	
}

char* reverseInParentheses(char * inputString){
	int left[20], right[20];
	int num=0,var=0,i,j;
	for(i=0;i<strlen(inputString);i++){
		if(inputString[i]=='('){
			left[num]=i;
			num++;
			var++;
		}
		else if(inputString[i]==')'){
			var--;
			if(var==0) right[0]=i;
		}
	}
	
}
