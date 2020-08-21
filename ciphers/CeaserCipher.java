package ciphers;

public class CeaserCipher extends Cipher {
	private final String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz12345" + 
			"67890 !?.";
	
	private int key;
	public CeaserCipher(String msg, int key)
	{
		this.msg = msg;
		this.key = key > SYMBOLS.length() ? key % SYMBOLS.length() : key; // handle keys > symbol set size
	}
	
	public String encrypt() 
	{
		String encryptedMsg = "";
		for (int i = 0; i < msg.length(); i++) {
			if (SYMBOLS.indexOf(msg.charAt(i)) != -1)
			{
				int translatedIndex = (SYMBOLS.indexOf(msg.charAt(i)) + key) % SYMBOLS.length();
				encryptedMsg += SYMBOLS.charAt(translatedIndex);
			}
			else
				encryptedMsg += msg.charAt(i);
		}
		
		msg = encryptedMsg;
		return encryptedMsg;
	}

	public String decrypt() 
	{
		String decryptedMsg = "";
		for (int i = 0; i < msg.length(); i++) {
			if (SYMBOLS.indexOf(msg.charAt(i)) != -1)
			{
				int translatedIndex = SYMBOLS.indexOf(msg.charAt(i)) - key;
				if (translatedIndex < 0)
					translatedIndex += SYMBOLS.length();
				decryptedMsg += SYMBOLS.charAt(translatedIndex);
			}
			else
				decryptedMsg += msg.charAt(i);
		}
		
		return decryptedMsg;
	}
}
