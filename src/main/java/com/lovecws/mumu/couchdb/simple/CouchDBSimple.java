package com.lovecws.mumu.couchdb.simple;

import com.alibaba.fastjson.JSON;
import com.lovecws.mumu.couchdb.CouchDBConfiguration;
import org.apache.log4j.Logger;
import org.ektorp.CouchDbConnector;
import org.ektorp.DbInfo;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;

import java.util.List;
import java.util.Map;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: 基本的增删改查功能
 * @date 2017-09-20 12:32
 */
public class CouchDBSimple {

    private static final Logger log = Logger.getLogger(CouchDBSimple.class);
    private static final CouchDbConnector couchDbConnector = new CouchDBConfiguration().dbConnector();

    /**
     * 获取数据库的所有文档id
     *
     * @return
     */
    public List<String> getAllDocIds() {
        List<String> docIds = couchDbConnector.getAllDocIds();
        log.info("文档ID集合:" + docIds);
        return docIds;
    }

    /**
     * 获取数据库详情
     *
     * @return
     */
    public DbInfo dbInfo() {
        DbInfo dbInfo = couchDbConnector.getDbInfo();
        log.info("数据库详情:" + JSON.toJSON(dbInfo));
        return dbInfo;
    }

    /**
     * 创建文档
     *
     * @param key
     * @param jsonObject
     */
    public void create(String key, Object jsonObject) {
        if (key == null) {
            couchDbConnector.create(jsonObject);
        } else {
            couchDbConnector.create(key, jsonObject);
        }
    }

    /**
     * 获取文档
     *
     * @param key 文档关键字
     * @return
     */
    public Map get(String key) {
        Map map = couchDbConnector.get(Map.class, key);
        log.info("文档:" + map);
        return map;
    }

    /**
     * 获取文档
     *
     * @param key 文档关键字
     * @return
     */
    public Map find(String key) {
        Map map = couchDbConnector.find(Map.class, key);
        log.info("文档:" + map);
        return map;
    }

    /**
     * 更新文档 如果文档不存在 就保存，存在就报错
     *
     * @param jsonObj 更新的文档
     * @return
     */
    public void update(Object jsonObj) {
        couchDbConnector.update(jsonObj);
    }

    /**
     * 删除文档
     *
     * @param jsonObj 更新的文档
     * @return
     */
    public void delete(Object jsonObj) {
        couchDbConnector.delete(jsonObj);
    }

    /**
     * 删除文档
     *
     * @param key 文档关键字
     * @param id  文档主键
     */
    public void delete(String key, String id) {
        String delete = couchDbConnector.delete(key, id);
        log.info("删除结果:" + delete);
    }

    /**
     * 删除文档附件
     *
     * @param key        文档关键字
     * @param id         文档主键
     * @param attachment 文档附件名称
     */
    public void deleteAttachment(String key, String id, String attachment) {
        String delete = couchDbConnector.deleteAttachment(key, id, attachment);
        log.info("删除文档附件结果:" + delete);
    }

    /**
     * 删除文档附件
     *
     * @param key        文档关键字
     * @param id         文档主键
     * @param attachment 文档附件名称
     */
    public void createAttachment(String key, String id, String attachment) {
        String attachment1 = couchDbConnector.createAttachment(key, id, null);
        log.info("添加文档附件:" + attachment1);
    }

    /**
     * 查询
     */
    public void query() {
        ViewQuery query = new ViewQuery()
                .designDocId("_design/Sofa")
                .viewName("by_color")
                .key("babymm");
        ViewResult viewResult = couchDbConnector.queryView(query);
        log.info("查询结果:" + viewResult);
    }
}
