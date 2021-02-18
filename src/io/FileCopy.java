package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String rea[]){
		//FileInputStream input=null;
		//FileOutputStream output = null;
		/*try {
			 File f=new File("E://copy.txt");  
			 f.createNewFile();
			 input = new FileInputStream("E://xxxxxxxxxxxxxxx.txt");
			 output = new FileOutputStream("E://copy.txt");
			 byte[] buffer = new byte[512];
			 int num = 0;
			 while( (num =input.read(buffer) )!=-1){
				 output.write(buffer, 0, num);
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		try(FileInputStream input = new FileInputStream("E://xxxxxxxxxxxxxxx.txt");
			FileOutputStream output =new FileOutputStream("E://copy.txt")){
			 File f=new File("E://copy.txt");  
			 f.createNewFile();
			 
			 byte[] buffer = new byte[512];
			 int num = 0;
			 while( (num =input.read(buffer) )!=-1){
				 output.write(buffer, 0, num);
			 }
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
