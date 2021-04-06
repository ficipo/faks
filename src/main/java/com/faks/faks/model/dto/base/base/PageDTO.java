package com.faks.faks.model.dto.base.base;

import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {
    private int totalPages;
    private int currentPage;
    private int size;
    private long totalElements;
    private String sortDirection;
    private String sortProperty;

    public static PageDTO ofPage(Page source) {
        return builder()
                .totalPages(source.getTotalPages())
                .currentPage(source.getNumber() + 1)
                .size(source.getSize())
                .totalElements(source.getTotalElements())
                .sortProperty(source.getSort().get()
                        .map(Sort.Order::getProperty)
                        .findFirst()
                        .orElse(""))
                .sortDirection(source.getSort().get()
                        .map(order -> order.getDirection().toString())
                        .findFirst()
                        .orElse(""))
                .build();
    }

    public static <T>PageDTO ofCollection(Collection<T> list, int size) {
        return builder()
                .totalPages(list.size() / size)
                .currentPage(0)
                .size(size)
                .totalElements(list.size())
                .build();
    }

}
