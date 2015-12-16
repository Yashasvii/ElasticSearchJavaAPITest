
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogram;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.metrics.min.Min;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

    public void averageAggregation(String fieldName, int expectedValue) {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch().setQuery(QueryBuilders.matchAllQuery())
                .setSize(0).addAggregation(AggregationBuilders.avg("Average" + fieldName).field(fieldName)).execute().actionGet();
        System.out.println(searchResponse.toString());

        Avg agg= searchResponse.getAggregations().get("Minimum_"+ fieldName);
        double actualValue= agg.getValue();
        AssertionClass.test(actualValue,expectedValue);



    }

    public void minimumAggregation(String fieldName,int expectedValue)
    {
        SearchResponse searchResponse= CreateClient.getClient().prepareSearch().setSize(0)
                .addAggregation(AggregationBuilders.min("Minimum_"+ fieldName).field(fieldName)).execute().actionGet();

      //  System.out.println(searchResponse.toString());
//        for (Aggregation aggregation : searchResponse.getAggregations()) {
//            Min min = (Min) aggregation;
//            System.out.println("min.getName() = " + min.getName());
//            System.out.println("min.getValue() = " + min.getValue());

        System.out.println(searchResponse.toString());
//        }

               Min agg= searchResponse.getAggregations().get("Minimum_"+ fieldName);
               double actualValue= agg.getValue();

//        try {
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(searchResponse.toString());
//            JSONObject jsonObject1 = (JSONObject) jsonObject.get("aggregations");
//            JSONObject jsonObject2= (JSONObject)jsonObject1.get("min_age");
//            System.out.println(Double.parseDouble(jsonObject2.get("value").toString()));
//
//
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.toString());
//        }

        AssertionClass.test(actualValue,expectedValue);
    }


    public void maximumAggregation(String fieldName, int expectedValue)
    {

        SearchResponse searchResponse= CreateClient.getClient().prepareSearch().setSize(0).
                addAggregation(AggregationBuilders.max("Maximum_"+fieldName).field(fieldName)).execute().actionGet();

        System.out.println(searchResponse.toString());
        Max agg= searchResponse.getAggregations().get("Maximum_"+fieldName);
        double actualValue=  agg.getValue();

        AssertionClass.test(actualValue,expectedValue);

    }



}
