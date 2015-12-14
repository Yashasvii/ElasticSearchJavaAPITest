import org.elasticsearch.action.count.CountResponse;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * Created by yrpant on 12/14/15.
 */
public class GetCount {
    public void getCount(String index, String type) {
        CountResponse response = CreateClient.getClient().prepareCount(index)
                .setQuery(QueryBuilders.termQuery("_type", type))
                .execute()
                .actionGet();
        System.out.println(response.getCount());
    }
}

