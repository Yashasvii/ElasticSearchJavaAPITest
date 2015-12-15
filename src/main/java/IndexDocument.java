import org.elasticsearch.action.index.IndexResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by yashasvi on 12/12/15.
 */
public class IndexDocument {
    private final Logger logger = Logger.getLogger(IndexDocument.class.getName());

    public void indexDocument(String index, String type, String id, String fileName) {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader("src/main/resources/input/"+fileName);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            String json = jsonObject.toString();
            IndexResponse response = CreateClient.getClient().prepareIndex(index, type, id)
                    .setSource(json)
                    .execute()
                    .actionGet();
        } catch (Exception e) {
            logger.log(Level.INFO, "Failed to document index :" + e);
        }
    }
}
