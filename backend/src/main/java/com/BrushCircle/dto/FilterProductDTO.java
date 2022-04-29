package com.BrushCircle.dto;

public class FilterProductDTO
{

    private String filter;

    public FilterProductDTO(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
