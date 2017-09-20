package com.lovecws.mumu.couchdb.simple;

import org.apache.log4j.Logger;
import org.ektorp.ViewQuery;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author babymm
 * @version 1.0-SNAPSHOT
 * @Description: 数据库的基本操作测试
 * @date 2017-09-20 12:53
 */
public class CouchDBSimpleTest {

    private static final Logger log = Logger.getLogger(CouchDBSimpleTest.class);
    private CouchDBSimple couchDBSimple = new CouchDBSimple();

    @Test
    public void getAllDocIds() {
        couchDBSimple.getAllDocIds();
    }

    @Test
    public void dbInfo() {
        couchDBSimple.dbInfo();
    }

    @Test
    public void create() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        map.put("name", "ganliang");
        map.put("sex", "男");
        map.put("age", 27);
        map.put("company", "武汉小墨科技有限公司");
        couchDBSimple.create(null, map);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", "1");
        map2.put("name", "ganliang");
        map2.put("sex", "男");
        map2.put("age", 27);
        map2.put("company", "武汉小墨科技有限公司");
        couchDBSimple.create("babymm", map2);
    }

    @Test
    public void get() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        couchDBSimple.create("babymmTest", map);
        couchDBSimple.get("babymmTest");
    }

    @Test
    public void find() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        couchDBSimple.create("babymmFind", map);
        couchDBSimple.find("babymmFind");
    }

    @Test
    public void update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        couchDBSimple.create("babymmUpdate", map);
        map = couchDBSimple.get("babymmUpdate");
        map.put("id", "1");
        map.put("name", "lovercws");
        map.put("sex", "男");
        map.put("age", 27);
        map.put("company", "武汉小墨科技有限公司");
        couchDBSimple.update(map);
        couchDBSimple.get("babymmUpdate");
        log.info("更新成功");
    }

    @Test
    public void delete() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        couchDBSimple.create("babymmDelete", map);
        map = couchDBSimple.get("babymmDelete");
        couchDBSimple.delete(map);
        log.info("删除成功");
    }

    @Test
    public void deleteWithKey() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        couchDBSimple.create("babymmDeleteWithKey", map);
        map = couchDBSimple.get("babymmDeleteWithKey");
        couchDBSimple.delete(map.get("_id").toString(), map.get("_rev").toString());
        log.info("删除成功");
    }

    @Test
    public void deleteAttachment() {
        couchDBSimple.deleteAttachment("babmm", "1-feb6f90727ce3b9744249fcf41e043da", "attach");
    }

    @Test
    public void createAttachment() {
        couchDBSimple.createAttachment("babmm", "1", "attach");
    }

    @Test
    public void query() {
        couchDBSimple.query();
    }
}
