import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogram;

/**
 * Created by yrpant on 12/14/15.
 */
public class Aggregations {

    public void aggregationsImplementation() {
        SearchResponse sr = CreateClient.getClient().prepareSearch().setSize(0).addAggregation(
                AggregationBuilders.terms("age_count").field("age").subAggregation(AggregationBuilders.
                        terms("first_name").field("fname"))
        )

                .execute().actionGet();

        System.out.println(sr.toString());

    }

    public void averageAggregation() {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch().setQuery(QueryBuilders.matchAllQuery())
                .setSize(0).addAggregation(AggregationBuilders.avg("average_age").field("age")).execute().actionGet();
        System.out.println(searchResponse.toString());


    }

    public void minimumAggregation()
    {
        SearchResponse searchResponse= CreateClient.getClient().prepareSearch().setSize(0)
                .addAggregation(AggregationBuilders.min("min_age").field("age")).execute().actionGet();
        System.out.println(searchResponse.toString());
    }



}
