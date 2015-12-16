import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;

/**
 * Created by yrpant on 12/16/15.
 */
public class CompareJSON {

    public static void compareJSON()
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode tree1 = mapper.readTree(new FileReader("/home/yrpant/Desktop/test/ElasticSearchJavaAPITest/src/main/resources/input/expectedData.json"));
            JsonNode tree2 = mapper.readTree(new FileReader("/home/yrpant/Desktop/test/ElasticSearchJavaAPITest/src/main/resources/output/Observed.json"));
            boolean areEqual = tree1.equals(tree2);
            System.out.println(areEqual);
        }

        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
