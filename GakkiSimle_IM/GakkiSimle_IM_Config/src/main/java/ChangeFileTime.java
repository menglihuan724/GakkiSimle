import java.io.File;
import java.util.Date;

public class ChangeFileTime {
    public static void main(String[] args) {
        Date now=new Date();
        String temp=System.getProperty("java.io.tmpdir");
        File data=new File(temp+"/ehcache/test/test1.data");
        File index=new File(temp+"/ehcache/test/test1.index");
        data.setLastModified(now.getTime());
        index.setLastModified(now.getTime());
        System.out.println(data.lastModified()==index.lastModified());
    }
}