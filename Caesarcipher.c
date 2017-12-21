#include<iostream>
#include <cmath>
#include<string.h>
using namespace std;
std::string encrypt(char word[], int key){
	char encryptWord[10];
	cout<<"Text: ";
	for (int i=0; i<strlen(word); ++i)
    		cout << word[i];
    	cout<<endl;
    	cout<<"Encrypted Text: ";
	for (int i=0; i<strlen(word); ++i){
		if(word[i]>=65 && word[i]<=90)
			encryptWord[i] = (word[i]-65 + key)%26 + 65;
		else if(word[i]>=97 && word[i]<=122)
			encryptWord[i] = (word[i]-97 + key)%26 + 97;
	}
   	for (int i=0; i<strlen(word); ++i)
    		cout << encryptWord[i];
    	cout<<endl;
    	return encryptWord;	
}
std::string decrypt(char cipher[], int key){
	char decryptWord[10];
	cout<<"Text: ";
	for (int i=0; i<strlen(cipher); ++i)
    		cout << cipher[i];
    	cout<<endl;
   	key = 26*ceil((double)key/26)-key;
    	cout<<"Decrypted Text: ";
	for (int i=0; i<strlen(cipher); ++i){
		if(cipher[i]>=65 && cipher[i]<=90)
			decryptWord[i] = (cipher[i]-65 + key)%26 + 65;
		else if(cipher[i]>=97 && cipher[i]<=122)
			decryptWord[i] = (cipher[i]-97 + key)%26 + 97;
	}
   	for (int i=0; i<strlen(cipher); ++i)
    		cout << decryptWord[i];
    	cout<<endl;
    	return decryptWord;
}
int main(){
	char word[10];
	int key=1;
	cout<<"Enter a String: ";
	cin>>word;
	cout<<"Enter a Key: ";
	cin>>key;
	std::string encryptWord = encrypt(word, key);
	
	char *encryptW = new char[encryptWord.length() + 1];
	strcpy(encryptW, encryptWord.c_str());
	
	decrypt(encryptW, key);
  	return 0;
}


Enter a String: abcdef
Enter a Key: 1302
Text: abcdef
Encrypted Text: cdefgh
Text: cdefgh
Decrypted Text: abcdef