package file_parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Parser {

	String defaultPath, defaultName;
	int fileId = 1;
	

	public Parser() {
		JFileChooser fr = new JFileChooser();
		FileSystemView fw = fr.getFileSystemView();
		defaultPath = fw.getDefaultDirectory().getAbsolutePath();
		defaultName = "myMsg" + fileId + ".txt";
	}

	public void write(String msg) throws IOException {
		System.out.println("Writing by default to: " + defaultPath);
		FileWriter fw = new FileWriter(createFile());
		fw.write(msg);
		fw.flush();
		fw.close();
	}
	
	public File createFile()
	{
		String fileName = defaultName;
		File msgFile = new File(defaultPath + "\\"+ fileName);
		while (msgFile.exists())
		{
			fileId++;
			fileName = "myMsg" + fileId + ".txt";
			msgFile = new File(defaultPath + "\\"+ fileName);
		}
		return msgFile;
	}

}
