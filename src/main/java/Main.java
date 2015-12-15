
import java.util.logging.Logger;


/**
 * Created by yrpant on 12/11/15.
 */
public class Main {
    protected final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
//       CreateIndex createIndex= new CreateIndex();
//        createIndex.createIndex("me");

//       MapIndex mapIndex= new MapIndex();
//        mapIndex.mapIndex("zz1","location","mapping.json");
//
//        GetContent getContent = new GetContent();
//       getContent.getContent("bank", "account", "1");

//        IndexDocument indexDocument= new IndexDocument();
//        indexDocument.indexDocument("tt","aa","5","indexdocument.json");

        // Delete deleteDocument= new DeleteDocument();
        //  deleteDocument.DeleteDocument("twitter","tweet","1");

        //   UpdateValue updateValue= new UpdateValue();
        //   updateValue.updateValue("contactmanager","people","1","fname","rabii");

//        Delete deleteIndex= new DeleteIndex();
//        deleteIndex.deleteIndex("2100");


//        SearchAPI searchIndex= new SearchAPI();
//        searchIndex.searchIndex("2000");


//        SearchAPI searchFilters= new SearchAPI();
//        searchFilters.searchFilters("contactmanager","fname","shyam");

//        GetCount getCount= new GetCount();
//        getCount.getCount("contactmanager","people");

//            BulkProcessing bulkProcessing= new BulkProcessing();
//        bulkProcessing.bulkRandomDataInsertion("zzz","aa",50);

//
//            Aggregations aggregations= new Aggregations();
//            aggregations.aggregationsImplementation();

//       Delete delete= new Delete();
//        delete.deleteByQueryResponse("contactmanager","people");
//    }

        Aggregations aggregations = new Aggregations();
//       // aggregations.aggregationsImplementation();
//        //aggregations.averageAggregation();
        aggregations.minimumAggregation("age",20);


//        BulkProcessing bulkProcessing= new BulkProcessing();
//        bulkProcessing.loadBulk("ban","account","accounts.json");


        // get a number in the first argument
//       AssertionClass assertionClass= new AssertionClass();
//       assertionClass.test();

    }
}


