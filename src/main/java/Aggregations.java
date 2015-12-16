
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogram;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.metrics.min.Min;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.util.logging.Level;

/**
 * Created by yrpant on 12/14/15.
 */
public class Aggregations {

    private String jsonBuilder;
    JSONParser jsonParser = new JSONParser();

    Aggregations() {
        jsonBuilder = "{\n" +
                "  \"comparison\": {\n" +
                "    \"default\": {\n" +
                "    }\n" +
                "  },\n" +
                "  \"reporting\": {\n" +
                "    \"default\": {\n" +
                "    }\n" +
                "  },\n" +
                "  \"percentageChange\": {\n" +
                "    \"default\": {\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }
        private void builderJSON(String fieldTerm, String fieldName, double actualValue, String outputFile)

    {
        try {

            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonBuilder);

            JSONObject jsonObject1 = (JSONObject) jsonObject.get("comparison");
            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("default");
            jsonObject2.put(fieldTerm + fieldName, actualValue);


            JSONObject jsonObject3 = (JSONObject) jsonObject.get("reporting");
            JSONObject jsonObject4 = (JSONObject) jsonObject3.get("default");
            jsonObject4.put(fieldTerm + fieldName, actualValue);

            JSONObject jsonObject5 = (JSONObject) jsonObject.get("percentageChange");
            JSONObject jsonObject6 = (JSONObject) jsonObject5.get("default");
            jsonObject6.put(fieldTerm+ fieldName, 0);

            System.out.println(jsonObject);

            FileWriter fileWriter = new FileWriter("src/main/resources/output/" + outputFile);

            ObjectMapper objectMapper = new ObjectMapper();


            String output = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);


            fileWriter.write(output);
            fileWriter.close();


        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }


    public void aggregationsImplementation() {
        SearchResponse sr = CreateClient.getClient().prepareSearch().setSize(0).addAggregation(
                AggregationBuilders.terms("age_count").field("age").subAggregation(AggregationBuilders.
                        terms("first_name").field("fname"))
        )

                .execute().actionGet();

        System.out.println(sr.toString());

    }

    public void averageAggregation(String fieldTerm, String fieldName, String outputFile) {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch().setQuery(QueryBuilders.matchAllQuery())
                .setSize(0).addAggregation(AggregationBuilders.avg(fieldTerm + fieldName).field(fieldName)).execute().actionGet();
        System.out.println(searchResponse.toString());

        Avg agg = searchResponse.getAggregations().get(fieldTerm + fieldName);

        double actualValue = agg.getValue();

        //AssertionClass.test(actualValue,expectedValue);
        this.builderJSON(fieldTerm, fieldName,actualValue, outputFile);


    }

    public void averageAggregation(String index, String fieldName, int expectedValue, String outputFile) {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch(index).setSize(0)
                .addAggregation(AggregationBuilders.avg("Average_" + fieldName).field(fieldName)).execute().actionGet();

        System.out.println(searchResponse.toString());
        Avg agg = searchResponse.getAggregations().get("Average_" + fieldName);
        double actualValue = agg.getValue();
        AssertionClass.test(actualValue, expectedValue);


    }

//    public void averageAggregation(String index, String type, String field, int expectedValue)
//    {
//        SearchResponse searchResponse= CreateClient.getClient().prepareSearch(index,type).setSize(0).addAggregation()
//    }

    public void minimumAggregation(String fieldName, int expectedValue, String outputFile) {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch().setSize(0)
                .addAggregation(AggregationBuilders.min("Minimum_" + fieldName).field(fieldName)).execute().actionGet();


        System.out.println(searchResponse.toString());
//        }

        Min agg = searchResponse.getAggregations().get("Minimum_" + fieldName);
        double actualValue = agg.getValue();





        this.builderJSON(fieldName,actualValue, outputFile);

    }


    public void maximumAggregation(String fieldName, int expectedValue) {

        SearchResponse searchResponse = CreateClient.getClient().prepareSearch().setSize(0).
                addAggregation(AggregationBuilders.max("Maximum_" + fieldName).field(fieldName)).execute().actionGet();

        System.out.println(searchResponse.toString());
        Max agg = searchResponse.getAggregations().get("Maximum_" + fieldName);
        double actualValue = agg.getValue();

        AssertionClass.test(actualValue, expectedValue);

    }

    public void sumAggregation(String fieldName, int expectedValue) {
        SearchResponse searchResponse = CreateClient.getClient().prepareSearch().setSize(0).
                addAggregation(AggregationBuilders.sum("Sum_" + fieldName).field(fieldName)).execute().actionGet();
        System.out.println(searchResponse.toString());
        Sum agg = searchResponse.getAggregations().get("Sum_" + fieldName);
        double actualValue = agg.getValue();
        AssertionClass.test(actualValue, expectedValue);
    }


}
