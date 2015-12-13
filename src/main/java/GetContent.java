import org.elasticsearch.action.get.GetResponse;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yashasvi on 12/12/15.
 */
public class GetContent {
    private final Logger logger = Logger.getLogger(CreateIndex.class.getName());

    //GET /twitter/tweet/1
    public void getContent(String index, String type, String id, String path) {
        try {
            GetResponse response = CreateClient.getClient().prepareGet(index, type, id)
                    .execute()
                    .actionGet();

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(response.getSource().toString());
            fileWriter.close();
        } catch (Exception e) {
            logger.log(Level.INFO, e.toString());
        }
    }
//    public void getContent(String index, String type) {
//        try {
//            GetResponse response = CreateClient.getClient().prepareGet(index, type)
//                    .execute()
//                    .actionGet();
//            System.out.println(response.getSource());
//        } catch (Exception e) {
//            logger.log(Level.INFO, e.toString());
//        }
//    }
}
