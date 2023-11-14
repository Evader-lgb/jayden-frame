package com.jayden.page;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PageResponse<T> {
    private Long pageNo = 1L;

    private Long pageSize = 10L;

    private Long total;

    private Long totalPages;

    private List<T> records = Collections.emptyList();

    private Long start = 1L;

    private Long end = 0L;

    public void setRecords(List<T> records) {
        this.records = records;
        if (records != null && records.size() > 0 && this.total == 0) {

        }
    }

    public void setPageNo(Long pageNo) {
        if(pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
        }
    }

    public void setPageSize(Long pageSize) {
        if(pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public Long getPageStart() {
        return (pageNo - 1) * pageSize;
    }

    public void setTotal(Long total){
        this.total = total;
        if (total == -1) {
            this.pageNo = 1L;
            return;
        }
        if (this.pageSize > 0) {
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0L;
        }
        this.start = (this.pageNo > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
    }
}
