import org.elasticsearch.action.delete.DeleteResponse;

/**
 * Created by yashasvi on 12/12/15.
 */
public class DeleteDocument {

    public void DeleteDocument(String index, String type, String id) {

        DeleteResponse response = CreateClient.getClient().prepareDelete(index, type, id)
                .execute()
                .actionGet();
    }
}
