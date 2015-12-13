import org.elasticsearch.action.update.UpdateRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by yashasvi on 12/12/15.
 */
public class UpdateValue {
    private final Logger logger = Logger.getLogger(UpdateValue.class.getName());

    public void updateValue(String index, String type, String id, String field, String value)
    {

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
        }

        catch (Exception e)
        {
            logger.log(Level.SEVERE,"Cannot Update + "+e);
        }
    }
}
