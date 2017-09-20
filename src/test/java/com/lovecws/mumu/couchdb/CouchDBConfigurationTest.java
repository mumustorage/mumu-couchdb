package com.lovecws.mumu.couchdb;

import org.ektorp.CouchDbInstance;
import org.junit.Test;

import java.net.MalformedURLException;

public class CouchDBConfigurationTest {

    @Test
    public void dbInstance() throws MalformedURLException {
        CouchDbInstance couchDbInstance = new CouchDBConfiguration().dbInstance();
        System.out.println(couchDbInstance);
    }

    @Test
    public void dbConnector() throws MalformedURLException {
        new CouchDBConfiguration().dbConnector();
        new CouchDBConfiguration("testDatabase").dbConnector();
    }
}
