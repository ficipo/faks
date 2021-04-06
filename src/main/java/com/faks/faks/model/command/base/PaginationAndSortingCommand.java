package com.faks.faks.model.command.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationAndSortingCommand implements Serializable {
    private Integer currentPage;
    private Integer size;
    private String sortProperty;
    private String sortDirection;

    public PageRequest generatePagingAndSortingRequest() {
        Sort.Direction sortDir = Sort.Direction
                .fromOptionalString(sortDirection)
                .orElse(Sort.DEFAULT_DIRECTION);

        Sort sort = Sort.by(sortDir, Optional.ofNullable(this.sortProperty)
                .filter(s -> !s.isEmpty()).orElse("id"));

        if (this.currentPage != null) {
            this.currentPage = this.currentPage - 1;
        }

        return PageRequest.of(
                Optional.ofNullable(this.currentPage).orElse(0),
                Optional.ofNullable(this.size).filter(s -> !s.equals(0)).orElse(10), sort);
    }
}
