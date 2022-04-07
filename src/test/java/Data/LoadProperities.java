package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities {
    // load file
    public static Properties userData = LoadProperities(System.getProperty("user.dir")+"\\src\\main\\java\\properities\\userdata.properities");

    private static Properties LoadProperities(String path){
        Properties pro = new Properties();
        //stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: "+ e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occured: "+ e.getMessage());
        }
        return pro;
    }
}
