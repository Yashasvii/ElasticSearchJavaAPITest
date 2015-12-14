import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yashasvi on 12/12/15.
 */
public class MapIndex {
    private final Logger logger = Logger.getLogger(MapIndex.class.getName());

    public void mapIndex(String index, String type, String path) {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader fileReader = new FileReader(path);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            String jsonMap = jsonObject.toString();
            fileReader.close();
            try {
//            deleteIndex(this.index);
                if (!checkIndex(index)) {
                    logger.log(Level.INFO, jsonMap);


                    CreateIndexRequestBuilder createIndexRequestBuilder = CreateClient.getClient().admin().indices().prepareCreate(index)
                            .addMapping(type, jsonMap);
                    createIndexRequestBuilder.execute().actionGet();
//                PutMappingResponse putMappingResponse = this.getClient().admin().indices().prepareCreate(this.index)
//                        .preparePutMapping(this.index)
//                        .setType(this.type)
//                        .setSource(mapjson)
//                        .execute().actionGet();
                } else {

                    logger.log(Level.INFO, "Index present already");
                }
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Mapping cannot be done. " + ex.toString());
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.toString());
        }
    }

    public boolean checkIndex(String indexName) {
        IndicesExistsResponse res = CreateClient.getClient().admin().indices().prepareExists(indexName).execute().actionGet();
        if (res.isExists()) return true;
        return false;
    }
}
