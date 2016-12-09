package sort;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) {
		
//		FileUtils.delAllFile("/Users/weilongzhang/Downloads/1");
		try {
			FileUtils.copyDirectory("/Users/weilongzhang/Downloads/1","/Users/weilongzhang/Downloads/2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
