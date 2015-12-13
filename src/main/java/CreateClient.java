import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yashasvi on 12/12/15.
 */
public class CreateClient {
    private static TransportClient client = null;
    private final static Logger logger = Logger.getLogger(CreateClient.class.getName());

    public static Client createClient() {
        try {


            Settings settings = ImmutableSettings.settingsBuilder()
                    .put("cluster.name", "es_yrpant").build();
            client = new TransportClient(settings);
            client.addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
            System.out.println("connected");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error creating client");

        }
        return  client;

    }

    protected static Client getClient() {
        if (client == null)
            return createClient();
        return client;
    }
}
