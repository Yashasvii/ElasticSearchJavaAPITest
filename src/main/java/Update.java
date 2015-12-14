import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by yashasvi on 12/12/15.
 */
public class Update {
    private final Logger logger = Logger.getLogger(Update.class.getName());

    public void updateValue(String index, String type, String id, String field, String value) {

        try {
            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.index(index);
            updateRequest.type(type);
            updateRequest.id(id);
            updateRequest.doc(jsonBuilder()
                    .startObject()
                    .field(field, value)
                    .endObject());
            CreateClient.getClient().update(updateRequest).get();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot Update + " + e);
        }
    }



}
