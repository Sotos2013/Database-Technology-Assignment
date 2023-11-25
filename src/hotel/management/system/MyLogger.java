
package hotel.management.system;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class MyLogger {
    private static Logger logger= Logger.getLogger("LogFile");
    public static void init(){
        FileHandler fh;
        try{
            fh=new FileHandler("mylogfile.log",true);
            logger.addHandler(fh);
            SimpleFormatter formatter=new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("Logger started");
            
        }catch (Exception e){
            logger.log(Level.WARNING,"Exception ::",e);
            
        }
    }
    
    
}


