import com.alibaba.fastjson.JSONObject;
import tool.ShellUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cheung0
 * Created on 2021/10/22
 */
public class Function {

    ShellUtil shellUtil = new ShellUtil();

    /**
     * @param: [VMID]
     * @return: java.lang.String
     * 销毁虚拟机
     */
    public String destroyVM(String VMID) {

        String[] command = {"sh /root/shell/destroy.sh " + VMID};
        for (String i : command) {
            shellUtil.shell(i);
        }
        return "Destroy VM:" + VMID + " successful!";

    }

    /**
     * @param: [VMID]
     * @return: java.lang.String
     * 开启虚拟机
     */
    public String openVM(String VMID) {

        String[] command = {"sh /root/shell/up.sh " + VMID};
        for (String i : command) {
            shellUtil.shell(i);
        }
        return "Open VM:" + VMID + " successful!";

    }

    /**
     * @param: [VMID]
     * @return: java.lang.String
     * 关闭虚拟机
     */
    public String shutVM(String VMID) {

        String[] command = {"sh /root/shell/down.sh " + VMID};
        for (String i : command) {
            shellUtil.shell(i);
        }
        return "Shut VM:" + VMID + " successful!";

    }

    /**
     * @param: [VMID]
     * @return: java.lang.String
     * 重启虚拟机
     */
    public String rebootVM(String VMID) {

        String[] command = {"sh /root/shell/reboot.sh " + VMID};
        for (String i : command) {
            shellUtil.shell(i);
        }
        return "Reboot VM:" + VMID + " successful!";

    }

    /**
     * @param: []
     * @return: com.alibaba.fastjson.JSONObject
     * 返回虚拟机有关信息
     */
    public JSONObject listVM() {

        String result = null;
        String[] command = {"sh /root/shell/list.sh"};
        JSONObject json = new JSONObject();
        for (String i : command) {

            List<Map> box = new ArrayList<>();
            result = shellUtil.shell(i);
            String[] array = result.split("\n");
            for (int j = 1; j < array.length; j++) {

                Map<String, String> map = new LinkedHashMap<>();

                char[] vmid = new char[4];
                array[j].getChars(6, 10, vmid, 0);
                map.put("VMID", String.valueOf(vmid).strip());

                char[] name = new char[4];
                array[j].getChars(11, 15, name, 0);
                map.put("NAME", String.valueOf(name).strip());

                char[] status = new char[7];
                array[j].getChars(32, 39, status, 0);
                map.put("STATUS", String.valueOf(status).strip());

                char[] men = new char[4];
                array[j].getChars(43, 47, men, 0);
                map.put("MEN", String.valueOf(men).strip());

                char[] bootdisk = new char[5];
                array[j].getChars(61, 66, bootdisk, 0);
                map.put("BOOTDISK", String.valueOf(bootdisk).strip());

                char[] pid = new char[6];
                array[j].getChars(67, 73, pid, 0);
                map.put("PID", String.valueOf(pid).strip());

                box.add(map);

            }
            json.put("Lists", box);
        }
        return json;
    }
}