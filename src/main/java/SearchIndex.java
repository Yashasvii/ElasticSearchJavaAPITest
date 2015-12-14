import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yrpant on 12/14/15.
 */
public class SearchIndex {
    private final Logger logger = Logger.getLogger(SearchIndex.class.getName());

    public void searchIndex(String index) {
        try {
//        logger.log(Level.INFO, this.createClient().toString());
            SearchResponse searchResponse = CreateClient.getClient().prepareSearch(index)
                    .setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();

            for (SearchHit searchHit : searchResponse.getHits()) {
                logger.log(Level.INFO, searchHit.getSourceAsString());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Index not found \n" + e);
        }
    }
}
