package com.alibaba.excel.read.metadata.holder;

import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.Holder;

import java.util.HashSet;
import java.util.Set;

/**
 * sheet holder
 *
 * @author Jiaju Zhuang
 */
public class ReadRowHolder implements Holder {
    /**
     * Returns row index of a row in the sheet that contains this cell.Start form 0.
     */
    private Integer rowIndex;
    /**
     * Record convert fail cols.
     */
    private Set<String> convertFailFields = new HashSet<String>();

    /**
     * The result of the previous listener
     */
    private Object currentRowAnalysisResult;
    /**
     * Some global variables
     */
    private GlobalConfiguration globalConfiguration;

    public ReadRowHolder(Integer rowIndex, GlobalConfiguration globalConfiguration) {
        this.rowIndex = rowIndex;
        this.globalConfiguration = globalConfiguration;
    }

    public GlobalConfiguration getGlobalConfiguration() {
        return globalConfiguration;
    }

    public void setGlobalConfiguration(GlobalConfiguration globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
    }

    public Object getCurrentRowAnalysisResult() {
        return currentRowAnalysisResult;
    }

    public void setCurrentRowAnalysisResult(Object currentRowAnalysisResult) {
        this.currentRowAnalysisResult = currentRowAnalysisResult;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Override
    public HolderEnum holderType() {
        return HolderEnum.ROW;
    }

    public Set<String> getConvertFailFields() {
        return convertFailFields;
    }
}
