package cn.ift8.red5;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by IFT8
 * on 2015/4/17.
 */
public class ProperUtils {
    private static Properties properties;

    static {
        properties = new Properties();
        URL url = ProperUtils.class.getClassLoader().getResource("ip.properties");
        if (url != null) {
            try {
                properties.load(new FileReader(url.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
//                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取允许IP
     *
     * @return ip的字串
     */
    public static String checkIp() {
        return properties.getProperty("ip");
    }

}
