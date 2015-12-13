import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yashasvi on 12/12/15.
 */
public class CreateIndex {
    private final Logger logger = Logger.getLogger(CreateIndex.class.getName());


    public void createIndex(String indexName) {
        try {
            CreateIndexRequestBuilder createIndexRequestBuilder = CreateClient.getClient().admin().indices().prepareCreate(indexName);
            CreateIndexResponse response = createIndexRequestBuilder.execute().actionGet();
            System.out.println("index creation is "+response.isAcknowledged());
        } catch (Exception ex) {
            logger.log(Level.INFO, "Index " + indexName + " already exists. Hence cannot be created.");
        }
    }
}
