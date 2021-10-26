/**
 * @author Cheung0
 * Created on 2021/10/25
 */
package tool;

import java.io.IOException;

public class ShellUtil {
    /**
     * @param: [command]
     * @return: void
     */
    public String shell(String command) {

        try {
            String result = CommandUtil.run(new String[]{"/bin/sh", "-c", command});
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error!";

    }

}
