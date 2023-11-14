package com.jayden.page;

import lombok.Setter;

@Setter
public class PageRequest {
    private Long pageNo = 1L;

    private Long pageSize = 10L;

    public Long getPageNo(){
        if (pageNo == null || pageNo < 1) {
            return 1L;
        }
        return pageNo;
    }

    public Long getPageSize(){
        // 最大200条
        if (pageSize == null || pageSize < 1 || pageSize > 200) {
            return 200L;
        }
        return pageSize;
    }
}
