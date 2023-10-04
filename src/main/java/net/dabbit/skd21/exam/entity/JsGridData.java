package net.dabbit.skd21.exam.entity;



import java.util.List;

public class JsGridData {
    private Integer pageIndex;//当前的页码
    private Integer pageSize;//每页显示的条数
    private Integer offset;
    private List<?> data;
    private Long itemsCount;
    private String search;//查询条件
    //先计算偏移量


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Long getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Long itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if(pageSize==null)return 5;
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        if(pageIndex==null || pageSize==null)return 0;
        offset = (pageIndex-1)*pageSize;
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
