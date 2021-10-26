/**
 * @author Cheung0
 * Created on 2021/10/22
 */
package tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class  CommandUtil {

    static Process process = null;

    /**
     * @param: [command]
     * @return: java.lang.String
     */
    public static String run(String[] command) throws IOException {

        Scanner input = null;
        String result = "";

        try {
            process = Runtime.getRuntime().exec(command);
            try {
                //等待命令执行完成
                process.waitFor(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            InputStream is = process.getInputStream();
            input = new Scanner(is);
            while (input.hasNextLine()) {
                result += input.nextLine() + "\n";
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (process !=null) {
                process.destroy();
            }
        }
        return result;
    }
}