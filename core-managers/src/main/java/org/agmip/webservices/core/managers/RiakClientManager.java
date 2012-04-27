package org.agmip.data.webservices.managers;

import com.yammer.dropwizard.lifecycle.Managed;
import com.yammer.dropwizard.logging.Log;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.RiakFactory;
import com.basho.riak.client.RiakException;

public class RiakClientManager implements Managed {
    private final IRiakClient riakClient;
    private static Log LOG = Log.forClass(RiakClientManager.class);

    public RiakClientManager(IRiakClient client) {
        riakClient = client;
    }

    public IRiakClient getClient() {
        return riakClient;
    }

    public void start() throws RiakException {
        LOG.info("Verifying connection to the Riak Cluster"); 
        LOG.info("Riak ClientID: "+riakClient.getClientId());
    }

    public void stop() {
        LOG.info("Shutting down the Riak Client");
        riakClient.shutdown();
    }
        
}
