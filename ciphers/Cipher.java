package ciphers;

public abstract class Cipher {
	protected String msg;
	
	public abstract String encrypt();
	public abstract String decrypt();
	public String getMsg() {return msg;}
}
