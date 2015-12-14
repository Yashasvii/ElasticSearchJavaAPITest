import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yrpant on 12/14/15.
 */
public class DeleteIndex {
    private final Logger logger = Logger.getLogger(CreateIndex.class.getName());

    public void deleteIndex(String indexName) {
        System.out.println(indexName);
        if (checkIndex(indexName)) {
            System.out.println("Inside if condition");
            DeleteIndexResponse delIdx = CreateClient.getClient().admin().indices().prepareDelete(indexName).execute().actionGet();

            logger.log(Level.INFO, "Index " + indexName + " deleted.");
        } else {
            System.out.println("outside if condition");
            logger.log(Level.INFO, "Index " + indexName + " doesn't exist.");
        }
    }

    public boolean checkIndex(String indexName) {
        IndicesExistsResponse res = CreateClient.getClient().admin().indices().prepareExists(indexName).execute().actionGet();
        if (res.isExists()) return true;
        return false;
    }

}
