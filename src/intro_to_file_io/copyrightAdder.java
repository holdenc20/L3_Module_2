package intro_to_file_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class copyrightAdder {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	JFileChooser jfc=new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	File fileName = null;
	for(int i = 0;i==0;) {
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsoluteFile();
			System.out.println(fileName);
		}
		try {
			FileReader fr=new FileReader(fileName);
			BufferedReader br=new BufferedReader(fr);
			ArrayList<String> text=new ArrayList<String>();
			String line=br.readLine();
			while(line != null){
				text.add(line);
				System.out.println(line);
				line = br.readLine();
			}
			FileWriter fw=new FileWriter(fileName,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("//Copyright © 2017 by Casey Holden");
			for(int x=0;x<text.size();x++) {
				bw.write(text.get(x));
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Any more files to copyright? type n if no");
		if(s.nextLine().equals("n")) {
			i++;
		}
		
	}
}	
}
	//BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/encrypted.txt"));
	//FileWriter fw=new FileWriter("src/intro_to_file_io/decryptedFile.txt");
	//BufferedWriter bw=new BufferedWriter(fw);


