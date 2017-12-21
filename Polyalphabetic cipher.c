#include <iostream>
#include <stdlib.h> 
#include <string.h>
#include<cmath>
using namespace std;
int main(){
	char text[]="Ankur";
	int key[strlen(text)];
	int i,num;
	cout<<"\nText :"<<text;
	//Cipehered Text
	for(i=0;i<strlen(text);i++){
		key[i]=rand()%26;
		if(text[i]>=65 && text[i]<=90)
			text[i] = (text[i]-65 + key[i])%26 + 65;
		else if(text[i]>=97 && text[i]<=122)
			text[i] = (text[i]-97 + key[i])%26 + 97;
	}
	cout<<"\nCiphered Text :"<<text;
	//Unciphered Text;
	for (int i=0; i<strlen(text); ++i){
		key[i] = 26*ceil((double)key[i]/26)-key[i];
		if(text[i]>=65 && text[i]<=90)
			text[i] = (text[i]-65 + key[i])%26 + 65;
		else if(text[i]>=97 && text[i]<=122)
			text[i] = (text[i]-97 + key[i])%26 + 97;
	}
	cout<<"\nUnciphered Text :"<<text;
}

/*
	Text :Ankur
	Ciphered Text :Puaay
	Unciphered Text :Ankur
*/