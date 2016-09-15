package spring.servise;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by spring on 27.07.2016.
 */
@Service
public class ApplicationResourceServise {
    public String loadingTextResource(String path){
        StringBuffer sb = new StringBuffer();
        try {
            Resource resource = new ClassPathResource(path);
            DataInputStream in = new DataInputStream(resource.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(" " + strLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
