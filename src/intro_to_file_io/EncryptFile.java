package intro_to_file_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptFile {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/filetoEncrypt.txt"));
			FileWriter fw=new FileWriter("src/intro_to_file_io/encrypted.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			String line = br.readLine();
			while(line != null){
				line=line.substring(line.length()/2,line.length())+line.substring(0,line.length()/2);
				bw.write(line);
				System.out.println(line);
				line = br.readLine();
				bw.write("\n");
			}
			br.close();
			bw.close();
			fw.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
