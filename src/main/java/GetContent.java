import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yashasvi on 12/12/15.
 */
public class GetContent {
    private final Logger logger = Logger.getLogger(CreateIndex.class.getName());

    //GET /twitter/tweet/1
    public void getContent(String index, String type, String id) {
        try {

            GetResponse response = CreateClient.getClient().prepareGet(index, type, id)
                    .execute()
                    .actionGet();




            FileWriter fileWriter = new FileWriter("src/main/resources/output/"+index+"-"+type+"-"+id+".json");
            ObjectMapper objectMapper = new ObjectMapper();
            Object json = objectMapper.readValue(response.getSourceAsString(), Object.class);


            String output = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

            logger.log(Level.INFO, output);

            fileWriter.write(output);
            fileWriter.close();
        } catch (Exception e) {
            logger.log(Level.INFO, e.toString());
        }
    }
//    public void getContent(String index, String indicator) {
//        try {
//            GetResponse response = CreateClient.getClient().prepareGet(index, indicator)
//                    .execute()
//                    .actionGet();
//            System.out.println(response.getSource());
//        } catch (Exception e) {
//            logger.log(Level.INFO, e.toString());
//        }
//    }
}
