import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.fluttercode.datafactory.impl.DataFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yrpant on 12/14/15.
 */
public class RandomDataGenerator {
    /* Class object definition */
    DataFactory dataFactory = new DataFactory();
    Date minDate = dataFactory.getDate(2013, 1, 1);

    Date maxDate = dataFactory.getDate(2017, 1, 1);
    int type;

    RandomDataGenerator() {
        this.type = this.generateNumber();
    }

    public String generateUserName() {
        return dataFactory.getFirstName() + dataFactory.getLastName();
    }

    public String generateDate() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(dataFactory.getDateBetween(minDate, maxDate));
    }

    public String generateMessage() {
        return dataFactory.getRandomText(20);

    }

    public int generateNumber() {
        return dataFactory.getNumberUpTo(100);
    }

    public JSONObject jsonData() throws IOException {

        XContentBuilder jsonBuilt = null;
       /* jsonBuilt = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("name")
                .field("first_name", dataFactory.getFirstName())
                .field("last_name", dataFactory.getLastName())
                .endObject()
                .field("age", generateNumber())
                .field("message", generateMessage())
                .endObject();*/

        if (type >50) {
            jsonBuilt = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("memberType")
                    .field("memId", dataFactory.getNumberUpTo(100))
                    .field("Name", dataFactory.getFirstName())
                    .startObject("location")
                    .field("City", dataFactory.getCity())
                    .field("ZipCode", dataFactory.getNumberBetween(100, 10000))
                    .field("Country", dataFactory.getCity() + "_country")
                    .field("Date", dataFactory.getDateBetween(minDate, maxDate))
                    .endObject()
                    .endObject()
                    .endObject();
        } else {
            jsonBuilt = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("location")
                    .field("City", dataFactory.getCity())
                    .field("ZipCode", dataFactory.getNumberBetween(100, 10000))
                    .field("Country", dataFactory.getCity() + "_country")
                    .field("Date", dataFactory.getDateBetween(minDate, maxDate))
                    .field("memId", dataFactory.getNumberBetween(1, 200))
                    .endObject()
                    .endObject();
        }
        JSONObject jsonObject= new JSONObject();
        try {
            JSONParser jsonParser = new JSONParser();
             jsonObject = (JSONObject) jsonParser.parse(jsonBuilt.string());

        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return  jsonObject;
    }

}
