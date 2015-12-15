import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * Created by yrpant on 12/14/15.
 */
public class Delete {
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

    public void deleteByQueryResponse(String index, String type)
    {

    DeleteByQueryResponse response = CreateClient.getClient().prepareDeleteByQuery(index)
            .setQuery(termQuery("_type", type))
            .execute()
            .actionGet();
    System.out.println(response.status());

}

    public void DeleteDocument(String index, String type, String id) {

        DeleteResponse response = CreateClient.getClient().prepareDelete(index, type, id)
                .execute()
                .actionGet();
    }


    private boolean checkIndex(String indexName) {
        IndicesExistsResponse res = CreateClient.getClient().admin().indices().prepareExists(indexName).execute().actionGet();
        if (res.isExists()) return true;
        return false;
    }



}
