import java.util.Scanner;
 
public class MonoalphabeticCipher{
	public static char substitute[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
        	'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            	'V', 'B', 'N', 'M' };
 
 	public static String doEncryption(String s){
        	char cipherText[] = new char[(s.length())];
	        for (int i = 0; i < s.length(); i++)
        		cipherText[i] = substitute[s.charAt(i)-'a'];
        
        	return (new String(cipherText));
 	}
 
    	public static String doDecryption(String s){
        	char plainText[] = new char[(s.length())];
	        for (int i = 0; i < s.length(); i++){
        		for (int j = 0; j < 26; j++){
		                if (substitute[j] == s.charAt(i)){
                			plainText[i] = (char)('a' + j);
			                break;
                		}
            		}
        	}
        	return (new String(plainText));
    	}
 
    	public static void main(String args[]){
        	Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the message: ");
        	String en = doEncryption(sc.next().toLowerCase());
        	System.out.println("Encrypted message: " + en);
	        System.out.println("Decrypted message: " + doDecryption(en));
        	sc.close();
    	}
}	


/*	Enter the message: Ankur
	Encrypted message: QFAXK
	Decrypted message: ankur
*/