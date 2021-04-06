package com.faks.faks.model.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class SharedSpecification<T> {


    Specification<T> getEqualStrong(Long value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.equal(getGenericValue(root, Long.class, properties), value);
            }
            return null;
        };
    }

    Specification<T> getLike(String value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.like(criteriaBuilder.lower(getGenericValue(root, String.class, properties)),
                        "%" + value.toLowerCase() + "%");
            }
            return null;
        };
    }

    Specification<T> getIn(List<Long> values, String... properties) {
        return (root, query, builder) -> {
            if (checkIfPropertyHasValue(values) && !values.isEmpty()) {
                CriteriaBuilder.In<Long> in = builder.in(getGenericValue(root, Long.class, properties));
                for (Long value : values) {
                    in = in.value(value);
                }
                return in;
            }
            return null;
        };
    }

    Specification<T> getInString(List<String> values, String... properties) {
        return (root, query, builder) -> {
            if (checkIfPropertyHasValue(values) && !values.isEmpty()) {
                CriteriaBuilder.In<String> in = builder.in(getGenericValue(root, String.class, properties));
                for (String value : values) {
                    in = in.value(value);
                }
                return in;
            }
            return null;
        };
    }

    Specification<T> isValueNull(Boolean value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (value) {
                return criteriaBuilder.isNull(getGenericValue(root, String.class, properties));
            }
            return null;
        };
    }

    <K> Specification<T> getEqual(K value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.equal(getGenericValue(root, String.class, properties), value);
            }
            return null;
        };
    }

    <K> Specification<T> lessThanOrEqualTo(Long value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.lessThanOrEqualTo(getGenericValue(root, Long.class, properties), value);
            }
            return null;
        };
    }

    Specification<T> greaterThanOrEqualTo(Long value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.greaterThanOrEqualTo(getGenericValue(root, Long.class, properties), value);
            }
            return null;
        };
    }

    Specification<T> getDateEqual(ZonedDateTime value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.equal(getGenericValue(root, String.class, properties), value);
            }
            return null;
        };
    }

    Specification<T> getDateFrom(ZonedDateTime value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.greaterThanOrEqualTo(getGenericValue(root, ZonedDateTime.class, properties), value);
            }
            return null;
        };
    }

    Specification<T> getDateBetween(ZonedDateTime value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.between(getGenericValue(root, ZonedDateTime.class, properties), value.minusDays(1), value.plusDays(1));
            }
            return null;
        };
    }

    Specification<T> getDateTo(Date value, String... properties) {
        return (root, query, criteriaBuilder) -> {
            if (checkIfPropertyHasValue(value)) {
                return criteriaBuilder.lessThanOrEqualTo(getGenericValue(root, Date.class, properties), value);
            }
            return null;
        };
    }

    private <K> Expression<K> getGenericValue(Root<T> root, Class<K> type, String... values) {
        Path path = root;
        for (String value : values) {
            path = path.get(value);
        }
        return path;
    }


    private boolean checkIfPropertyHasValue(String property) {
        return (property != null && !property.isEmpty());
    }

    private <T> boolean checkIfPropertyHasValue(T property) {
        return property != null;
    }
}
