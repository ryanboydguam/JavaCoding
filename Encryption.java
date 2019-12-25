import java.util.Arrays;

/**
 * 
 * @author Ryan discord ryan#8929
 * This program encrypts messages then decrypts them by calling the method. You can change the return statement to return encrypted method
 */
/*
 * This program assums that you are giving the password to the client like a login. this is not asymmetric encryption.
 */
public class Encryption {
	//this is the users key they use to encrypt the message
	private String UserKey="random Word";
	//this is the message being encrypted
	private String message = "Hello World!";
	//this holds the value of the byte data of the UserKey
	private byte[] key;
	//this holds the byte data of the encrypted data
	private byte[] enc;
	//this holds the byte data of the decrypted data
	private byte[] dec;
	//this counter is used for the UserKey so you can have what ever size user key you want and the program adjusts to it
	private int userKeyCounter=0;
public static void main(String[] args) {
	Encryption object = new Encryption();
	object.getKey();
	object.encryptMessage();
	object.decryptMessage();
}
/*
 * gets the userkey length and makes the byte key array the size of the UserKey length
 * then converts the UserKey to a string if you wanted to have an int value saved as the key
 * then saves the byte data
 * If you dont know byte data then look here https://docs.oracle.com/javase/8/docs/api/java/lang/Byte.html
 */
public void getKey() {
	key = new byte[UserKey.length()];
	String UserKeyToString = String.valueOf(UserKey);
	key = UserKeyToString.getBytes();
}
/*
 * this encrypts the message
 * first set the key counter to 0 this means you start at the first digit of the key. 
 * If you want to change the security settings you can always change the key counter to what ever you want
 * the enc byte array gets the size of the message and sets the array size
 * enc byte array is set to the current byte array of the message
 * then it gets the first array value and adds it with the first array  value of the key
 * then it continues on
 * when it gets to the last value of the key the key starts back at the beginning but the byte array keeps on going
 */
public void encryptMessage() {
	userKeyCounter=0;
	enc = new byte[message.length()];
	enc = message.getBytes();
	for(int i= 0; i < message.length(); i++) {
		enc[i]=(byte) (enc[i]+key[userKeyCounter]);
		
		userKeyCounter=userKeyCounter+1;
		if(userKeyCounter>(UserKey.length())-1) {
			userKeyCounter=0;
		}
	}
	String string = new String(enc);
	System.out.println(string);
	System.out.println(Arrays.toString(enc));
	
}
/*
 * this is the same concept as the encrypted part but removes the key out of the value to decrypts it
 */
public void decryptMessage() {
	userKeyCounter=0;
	dec = new byte[message.length()];
	
	dec = enc;
		for(int i= 0; i < message.length(); i++) {
			//System.out.println(dec[i]+" "+key[userKeyCounter]);
			dec[i]=(byte) (dec[i]-key[userKeyCounter]);
			
			userKeyCounter=userKeyCounter+1;
			if(userKeyCounter>(UserKey.length())-1) {
				userKeyCounter=0;
			}
		}
		String string = new String(dec);
		System.out.println(string);
		System.out.println(Arrays.toString(dec));
		
	
}
}
