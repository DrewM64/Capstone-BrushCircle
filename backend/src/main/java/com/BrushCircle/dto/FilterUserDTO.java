package com.BrushCircle.dto;

public class FilterUserDTO
{

    private String filter;

    public FilterUserDTO(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
