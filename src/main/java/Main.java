import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.logging.Logger;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by yrpant on 12/11/15.
 */
public class Main {
    protected final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
//       CreateIndex createIndex= new CreateIndex();
//        createIndex.createIndex("me");

//       MapIndex mapIndex= new MapIndex();
//        mapIndex.mapIndex("zz1","location","src/main/resources/input/mapping.json");
//
        GetContent getContent = new GetContent();
       getContent.getContent("bank", "account", "1", "src/main/resources/output/output.json");

//        IndexDocument indexDocument= new IndexDocument();
//        indexDocument.indexDocument("tt","aa","5","src/main/resources/input/indexdocument.json");

        // DeleteDocument deleteDocument= new DeleteDocument();
        //  deleteDocument.DeleteDocument("twitter","tweet","1");

        //   UpdateValue updateValue= new UpdateValue();
        //   updateValue.updateValue("contactmanager","people","1","fname","rabii");

//        DeleteIndex deleteIndex= new DeleteIndex();
//        deleteIndex.deleteIndex("2100");


//        SearchIndex searchIndex= new SearchIndex();
//        searchIndex.searchIndex("2000");

//        SearchFilters searchFilters= new SearchFilters();
//        searchFilters.searchFilters("contactmanager","fname","shyam");

//        GetCount getCount= new GetCount();
//        getCount.getCount("contactmanager","people");

    }

}


