import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yrpant on 12/15/15.
 */
public class SearchAPI {
    private final Logger logger = Logger.getLogger(SearchAPI.class.getName());

    public void searchFilters(String index, String field, String value) {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch(index)
                .setQuery(QueryBuilders.matchAllQuery())
                .setPostFilter(FilterBuilders.termFilter(field, value))
                .execute().actionGet();


        // System.out.println(searchResponse.toString());
        while (true) {
            if (searchResponse.getHits().getHits().length == 0)
                System.out.println("Search hit is zero");
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                // handle the hits from the search response
                System.out.println(hit.getSource());
                System.out.println("id is: "+hit.getId());

            }
            break;
        }
//        System.out.println(params[0]+", "+params[1]);
    }

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
