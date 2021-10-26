import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import tool.ShellUtil;

import java.util.*;

class ShellUtilTest {

    Function func = new Function();

    @Test
    public void test() {

        JSONObject json = new JSONObject();
        func.shutVM("3001");
        json = func.listVM();
        System.out.println(json);



    }

}