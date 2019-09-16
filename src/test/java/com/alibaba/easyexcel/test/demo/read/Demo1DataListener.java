package com.alibaba.easyexcel.test.demo.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 模板的读取类
 *
 * @author Jiaju Zhuang
 */
public class Demo1DataListener extends AnalysisEventListener<Demo1Data> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo1DataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<Demo1Data> list = new ArrayList<>();

    @Override
    public void invoke(Demo1Data data, AnalysisContext context) {
        LOGGER.info("解析到一条数据:{},rowIndex={}", JSON.toJSONString(data), context.readRowHolder().getRowIndex());
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
    }
}
