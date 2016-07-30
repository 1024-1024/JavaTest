package binary;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaderBinary {

	public static void main(String[] args) {
		readFile();
	}

	private static void readFile() {
		File file = new File("");   
        if(file.exists()){  
            try {  
                FileInputStream in = new FileInputStream(file);  
                DataInputStream dis=new DataInputStream(in);  
                  
                byte[] itemBuf = new byte[20];  
                //市场编码  
                dis.read(itemBuf, 0, 8);  
                String marketID =new String(itemBuf,0,8);  
                  
                //市场名称  
                dis.read(itemBuf, 0, 20);//read方法读取一定长度之后，被读取的数据就从流中去掉了，所以下次读取仍然从 0开始   
                String marketName =new String(itemBuf,0,20);  
                  
                //上一交易日日期  
                dis.read(itemBuf, 0, 8);  
                String lastTradingDay = new String(itemBuf,0,8);  
                  
                //当前交易日日期  
                dis.read(itemBuf, 0, 8);  
                String curTradingDay = new String(itemBuf,0,8);  
                  
                //交易状态  
                dis.read(itemBuf, 0, 1);  
                String marketStatus = new String(itemBuf,0,1);  
  
                //交易时段数  
                short tradePeriodNum = dis.readShort();  
                  
                System.out.println("市场代码:"+ marketID);  
                System.out.println("市场名称:"+ marketName);  
                System.out.println("上一交易日日期:"+ lastTradingDay);  
                System.out.println("当前交易日日期:"+ curTradingDay);  
                System.out.println("当前交易日日期:"+ curTradingDay);  
                System.out.println("交易状态:"+ marketStatus);  
                System.out.println("交易时段数:"+ tradePeriodNum);  
  
            } catch (IOException e) {  
                e.printStackTrace();  
            }finally{  
            }  		
	}
	}
}



