package com.jayden.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页类，后续用使用Mybatis中的分类响应来封装
 */
@Data
public class PageResult<T> implements Serializable {
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 每页的记录数
     */
    private Long size;

    /**
     * 当前页数
     */
    private Long current;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 数据
     */
    private List<T> records = Collections.emptyList();

    public void loadData(IPage<T> pageData){
        this.total = pageData.getTotal();
        this.size = pageData.getSize();
        this.current = pageData.getCurrent();
        this.pages = pageData.getPages();
        this.records = pageData.getRecords();
    }

}
