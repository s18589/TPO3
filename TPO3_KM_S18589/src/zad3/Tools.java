/**
 * @author Kępka Mateusz S18589
 */

package zad3;


import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.util.Map;

public class Tools {
    static Options createOptionsFromYaml(String path) {
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = (Map)yaml.load(inputStream);
        return new Options(
                (String) map.get("host"),
                (int) map.get("port"),
                (boolean) map.get("concurMode"),
                (boolean) map.get("showSendRes"),
                (Map) map.get("clientsMap")
        );
    }
}
