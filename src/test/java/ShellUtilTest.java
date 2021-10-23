import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ShellUtilTest {

    ShellUtil shellUtil = new ShellUtil();

    @Test
    public void test() {

        String[] command = {"sh /home/mint03/test/shell/test.sh"};
        for (String i : command
        ) {
            shellUtil.shell(i);
        }

    }

}