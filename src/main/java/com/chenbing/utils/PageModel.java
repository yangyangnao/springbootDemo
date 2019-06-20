package com.chenbing.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageModel<T> {
    private List<T> rows;
    private long total;
    private Integer page;

    public PageModel(){}


    public PageModel(PageInfo<T> t) {
        this.rows = t.getList();
        this.total = t.getTotal();
        this.page = t.getPageNum();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
