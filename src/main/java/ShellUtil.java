import java.io.File;
import java.io.IOException;

public class ShellUtil {

    public void shell(String command) {

        try {
            String result = CommandUtil.run(new String[]{"/bin/sh", "-c", command},null,null);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
