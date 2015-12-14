import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by yrpant on 12/14/15.
 */
public class BulkProcessing {
    private void bulkOperationIndexing(String index, String type,List<JSONObject> jsonList) {

        BulkRequestBuilder bulkRequestBuilder = CreateClient.getClient().prepareBulk();
        int i = 0;
        for (JSONObject jsonData : jsonList) {
            bulkRequestBuilder.add(CreateClient.getClient().prepareIndex(index, type, i++ + "")
                            .setSource(jsonData)
            );
            System.out.println(jsonData.toString());
        }
        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
        if (bulkResponse.hasFailures()) {

            System.out.println("Failure in bulk indexing");
        } else {
            System.out.println("Success in bulk indexing");
        }
    }

    public void bulkDataInsertion(String index,String type, int maxSize)
    {

        /* Bulk API test */

        try {
            RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
            List<JSONObject> data = new ArrayList<JSONObject>();
            for (int i = 0; i < maxSize; i++) {
                data.add(i, randomDataGenerator.jsonData());
            }
            BulkProcessing bulkProcessing= new BulkProcessing();

            bulkProcessing.bulkOperationIndexing(index,type,data);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
