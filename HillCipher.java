import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	
	public static String encrypt(String text, int key[][]){
		
		char textArray[] = text.toCharArray();
		char encryptText[] = new char[textArray.length];
		
		for(int i=0;i<textArray.length; i+=2){
			encryptText[i] = (char)((key[0][0]*(textArray[i]-65) + key[0][1]*(textArray[i+1]-65))%26+65);
			encryptText[i+1] = (char)((key[1][0]*(textArray[i]-65) + key[1][1]*(textArray[i+1]-65))%26+65);
		}
		
		return new String(encryptText);
	}
	
	public static String decrypt(String cipher, int key[][]){
		char encryptText[] = cipher.toCharArray();
		
		int b[][] = new int[2][2];
		b[0][0] = key[1][1];
		b[1][1] = key[0][0];
		b[0][1] = -key[0][1];
		b[1][0] = -key[1][0];
		
		int determinanat = b[0][0]*b[1][1] - b[0][1]*b[1][0];
		
		int modInv = BigInteger.valueOf(determinanat).modInverse(new BigInteger("26")).intValue();
	
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++)
				b[i][j] = b[i][j]>0?(b[i][j]*modInv)%26:(26*(int)Math.ceil(-(double)b[i][j]/26) + b[i][j])*modInv%26;
		}
		
		char decryptText[] = new char[encryptText.length];
		for(int i=0;i<encryptText.length; i+=2){
			decryptText[i] = (char)((b[0][0]*(encryptText[i]-65) + b[0][1]*(encryptText[i+1]-65))%26+65);
			decryptText[i+1] = (char)((b[1][0]*(encryptText[i]-65) + b[1][1]*(encryptText[i+1]-65))%26+65);
		}
		
		return new String(decryptText);
	}
	
	public static void main(String[] args) {
		int key[][] = {{3,3},{2,5}};
		String txt;
		System.out.println("Enter the text for encryption: ");
		Scanner scan=new Scanner(System.in);
		System.out.println("Encryption of "+( txt=scan.next() )+": "+ ( txt=encrypt(txt, key) ) );
		System.out.println("Decryption of "+txt+": "+decrypt(txt, key));
   }
}

/*    	Enter the text for encryption: HATS
	Encryption of HATS: VOHY
	Decryption of VOHY: HATS
*/