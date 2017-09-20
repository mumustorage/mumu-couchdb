package com.lovecws.mumu.couchdb.database;

import com.lovecws.mumu.couchdb.CouchDBConfiguration;
import org.apache.log4j.Logger;
import org.ektorp.ActiveTask;
import org.ektorp.CouchDbInstance;

import java.util.Collection;
import java.util.List;

public class CouchDBDatabase {

    private static final Logger log = Logger.getLogger(CouchDBDatabase.class);

    /**
     * 创建数据库
     *
     * @param databaseName 数据库的名称
     * @param check        检查数据库是否存在
     */
    public void createDatabase(String databaseName, boolean check) {
        CouchDbInstance couchDbInstance = new CouchDBConfiguration().dbInstance();
        if (check) {
            boolean exists = couchDbInstance.checkIfDbExists(databaseName);
            if (exists) {
                log.info("数据库【" + databaseName + "】已存在");
            } else {
                couchDbInstance.createDatabase(databaseName);
                log.info("数据库【" + databaseName + "】创建成功");
            }
        } else {
            boolean notExists = couchDbInstance.createDatabaseIfNotExists(databaseName);
            if (notExists) {
                log.info("数据库【" + databaseName + "】创建成功");
            } else {
                log.info("数据库【" + databaseName + "】已存在");
            }
        }
    }

    /**
     * 删除
     *
     * @param databaseName 数据库名称
     */
    public void deleteDatabase(String databaseName) {
        CouchDbInstance couchDbInstance = new CouchDBConfiguration().dbInstance();
        if (couchDbInstance.checkIfDbExists(databaseName)) {
            couchDbInstance.deleteDatabase(databaseName);
            log.info("数据库【" + databaseName + "】删除成功");
        } else {
            log.info("数据库【" + databaseName + "】不存在");
        }
    }

    /**
     * 判断数据库是否存在
     *
     * @param databaseName 数据库名称
     * @return
     */
    public boolean databaseExists(String databaseName) {
        CouchDbInstance couchDbInstance = new CouchDBConfiguration().dbInstance();
        boolean exists = couchDbInstance.checkIfDbExists(databaseName);
        log.info("数据库【" + databaseName + "】 " + (exists ? "存在" : "不存在"));
        return exists;
    }

    /**
     * 列出所有的数据库
     *
     * @return
     */
    public List<String> listDatabases() {
        CouchDbInstance couchDbInstance = new CouchDBConfiguration().dbInstance();
        List<String> databases = couchDbInstance.getAllDatabases();
        log.info("数据库列表:" + databases);
        return databases;
    }

    /**
     * 列出所有的任务
     *
     * @return
     */
    public Collection<ActiveTask> listTasks() {
        CouchDbInstance couchDbInstance = new CouchDBConfiguration().dbInstance();
        Collection<ActiveTask> activeTasks = couchDbInstance.getActiveTasks();
        for (ActiveTask activeTask : activeTasks) {
            log.info("任务:" + activeTask);
        }
        return activeTasks;
    }
}
