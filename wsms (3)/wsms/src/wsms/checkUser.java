package wsms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class checkUser {
	boolean Flag=false;
	checkUser(File file,String name,String pass) throws IOException{
		String passLine=name+" "+pass;
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			String userline;
			while((userline=br.readLine())!=null)
			{
				if(passLine.equals(userline))
				{
					Flag=true;
					break;
				}
				else{
					this.Flag=false;
				}
			}
			
		}
	}
	boolean allowOrNot() {
		return Flag;
	}

}
