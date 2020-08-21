package main;

import java.io.IOException;

import ciphers.CeaserCipher;
import file_parser.Parser;

public class Driver {

	public static void main(String[] args){
		Parser parser = new Parser();
		CeaserCipher c1 = new CeaserCipher("henlo", 3);
		c1.encrypt();
		try {
			parser.write(c1.getMsg());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c1.getMsg());
		System.out.println(c1.decrypt());
		



	}

}
