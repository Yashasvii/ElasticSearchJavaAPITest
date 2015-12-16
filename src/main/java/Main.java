
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.hppc.cursors.ObjectObjectCursor;

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
//  GetContent getContent = new GetContent();
//     getContent.getContent("bank", "account", "2");

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

//BulkProcessing bulkProcessing= new BulkProcessing();
// bulkProcessing.bulkRandomDataInsertion("contactmanager","aa",50);
//
////
 Aggregations aggregations= new Aggregations();
 //aggregations.aggregationsImplementation();
////
//       Delete delete= new Delete();
//        delete.deleteByQueryResponse("contactmanager","people");
//    }


  //  aggregations.aggregationsImplementation();

   aggregations.averageAggregation("ageaverage","age","testoutput1.json");
// //aggregations.averageAggregation("contactmanager","age",20);


     //aggregations.minimumAggregation("age",25,"observer1.json");


     //  aggregations.maximumAggregation("age",70);




//        BulkProcessing bulkProcessing= new BulkProcessing();
//        bulkProcessing.loadBulk("banl1","account","accounts.json");

//        CompareJSON.compareJSON();




    }
}


