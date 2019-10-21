package com.qfedu.examination.vo;

import lombok.Data;


public class Page {
    private Integer page;
    private Integer limit;
    private Integer begin;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getBegin() {
        this.begin = (page - 1)*limit;
        return begin;
    }


}
