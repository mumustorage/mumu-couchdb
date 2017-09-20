package com.lovecws.mumu.couchdb;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.DbInfo;
import org.ektorp.DocumentNotFoundException;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: couchdb 配置信息
 * @date 2017-09-20 11:48
 */
public class CouchDBConfiguration {

    private static final Logger log = Logger.getLogger(CouchDBConfiguration.class);

    private static String COUCHDB_HOST = "http://192.168.11.25:5984";
    private static String COUCHDB_USERNAME = "babymm";
    private static String COUCHDB_PASSWORD = "lovecws";
    private CouchDbConnector dbConnector;
    private CouchDbInstance dbInstance;

    private String databaseName;//数据库名称

    public CouchDBConfiguration() {
        this.databaseName = "babymumu";
    }

    public CouchDBConfiguration(final String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * 获取到数据库
     *
     * @return
     */
    public synchronized CouchDbInstance dbInstance() {
        if (dbInstance == null) {
            try {
                String couchdb_host = System.getenv("COUCHDB_HOST");
                if (couchdb_host != null) {
                    COUCHDB_HOST = couchdb_host;
                }
                HttpClient httpClient = new StdHttpClient.Builder()
                        .url(COUCHDB_HOST)
                        //.username(COUCHDB_USERNAME)
                        //.password(COUCHDB_PASSWORD)
                        .build();
                dbInstance = new StdCouchDbInstance(httpClient);
            } catch (MalformedURLException e) {
                log.error(e);
            }
        }
        return dbInstance;
    }

    /**
     * 获取到链接
     *
     * @return
     */
    public synchronized CouchDbConnector dbConnector() {
        if (dbConnector == null) {
            dbInstance();
            dbConnector = new StdCouchDbConnector(databaseName, dbInstance);
            try {
                DbInfo dbInfo = dbConnector.getDbInfo();
                log.info("数据库详情:" + JSON.toJSON(dbInfo));
            } catch (DocumentNotFoundException e) {
                //TODO 数据库不存在 则创建
                dbInstance.createDatabaseIfNotExists(databaseName);
                dbConnector = new StdCouchDbConnector(databaseName, dbInstance);
            }
        }
        return dbConnector;
    }
}
