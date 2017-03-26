import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * @author Nandem on 2017-03-24.
 */
public class YAMLTest
{
    public static void loadAll()
    {
        Yaml yaml = new Yaml();
        //        File f = new File(String.valueOf(YAMLTest.class.getResource("yamlLoadAll.yaml")));
        //        Map map = (Map) yaml.load(YAMLTest.class.getResourceAsStream("yamlLoadAll.yaml"));

        for(Object data : yaml.loadAll(YAMLTest.class.getResourceAsStream("yamlLoadAll.yaml")))
        {
            System.out.println(data);
        }
    }

    public static void load()
    {
        Yaml yaml = new Yaml();

        Map map = (Map)yaml.load(YAMLTest.class.getResourceAsStream("yamlLoad.yaml"));

        Map defaultYaml = (Map) map.get("first");

        System.out.println(defaultYaml);

        System.out.println(((List)defaultYaml.get("city")).get(1));
    }

    public static void main(String[] a) throws FileNotFoundException
    {
        load();
    }
}
