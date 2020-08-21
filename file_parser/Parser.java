package file_parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Parser {

	String defaultPath, defaultName;
	

	public Parser() {
		JFileChooser fr = new JFileChooser();
		FileSystemView fw = fr.getFileSystemView();
		defaultPath = fw.getDefaultDirectory().getAbsolutePath();
		defaultName = "myMsg.txt";
	}

	public void write(String msg) throws IOException {
		System.out.println("Writing by default to: " + defaultPath);
		File msgFile = new File(defaultPath + "\\"+ defaultName);
		if (msgFile.exists())
		{
			System.out.println("File already exists");
			System.exit(0);
		}
		else
		{
			FileWriter fw = new FileWriter(msgFile);
			fw.write(msg);
			fw.flush();
			fw.close();
		}
		
	}

}
