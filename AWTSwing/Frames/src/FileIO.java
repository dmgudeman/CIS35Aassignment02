
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.io.IOException;

public class FileIO 
{
	File inFile;
	File outFile;
	
	public long ReadFile(JTextPane tp, String sfile) throws IOException 
	{
		Font font = new Font("Arial",Font.PLAIN,20);
		tp.setFont(font);
		inFile  = new File(sfile);
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        String sline = null;
        while ((sline=reader.readLine()) != null) 
        	tp.setText(tp.getText()+sline+"\n");
        reader.close();
        return inFile.length();
    }
	
	public long WriteFile(String sinfile,String soutfile) throws IOException 
	{
		File inFile  = new File(sinfile);
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
		File toFile  = new File(soutfile);
		BufferedWriter writer = new BufferedWriter(new FileWriter(toFile));
		String line = null;
		while ((line=reader.readLine()) != null) 
		{
			writer.write(line);
			writer.newLine();
		}
		reader.close();
		writer.close();
		return toFile.length();
	}
}
