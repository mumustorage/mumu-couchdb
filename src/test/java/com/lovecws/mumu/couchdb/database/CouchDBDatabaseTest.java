package com.lovecws.mumu.couchdb.database;

import org.junit.Test;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: 数据库测试
 * @date 2017-09-20 12:09
 */
public class CouchDBDatabaseTest {

    private CouchDBDatabase couchDBDatabase = new CouchDBDatabase();

    @Test
    public void createDatabase() {
        couchDBDatabase.createDatabase("babymm", true);
        couchDBDatabase.createDatabase("babymm", true);
        couchDBDatabase.createDatabase("babymm123", false);
        couchDBDatabase.createDatabase("babymm123", false);
    }

    @Test
    public void deleteDatabase() {
        couchDBDatabase.createDatabase("lol", true);
        couchDBDatabase.deleteDatabase("lol");
        couchDBDatabase.deleteDatabase("lol");
    }

    @Test
    public void databaseExists() {
        boolean exists = couchDBDatabase.databaseExists("lol");
    }

    @Test
    public void listDatabases() {
        couchDBDatabase.listDatabases();
    }

    @Test
    public void listTasks() {
        couchDBDatabase.listTasks();
    }
}
