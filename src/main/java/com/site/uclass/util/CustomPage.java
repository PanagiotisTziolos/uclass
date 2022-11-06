package com.site.uclass.util;

import java.util.List;

public class CustomPage {

    public <T> List<T> getNextItemsFromList(List<T> items, int beginning, int size) {
        int start = beginning * size;
        int end = start + size;
        
        if (end > items.size())
            return items.subList(start, items.size());
        else
            return items.subList(start, end);
    }

    public int getTotalPages(double listSize, int itemsPerPage) {
        return (int)(Math.ceil(listSize / itemsPerPage) - 1);
    }
}
