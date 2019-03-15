package app.api.user.interfaces.criteria;

import app.api.base.dto.SearchCriteria;
import app.api.user.domain.model.User;
import com.querydsl.core.types.dsl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by taesu on 2019-03-10.
 */
public class UserPredicateBuilder {
    private List<SearchCriteria> params;

    public UserPredicateBuilder() {
        params = new ArrayList<>();
    }

    public UserPredicateBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public BooleanExpression build(String condition) {
        if (params.size() == 0) {
            return null;
        }

        List<BooleanExpression> predicates = params.stream().map(UserPredicate::getPredicate)
                .filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = null;
        for (BooleanExpression predicate : predicates) {
            if (result == null) {
                if (condition.equalsIgnoreCase("and")) {
                    result = Expressions.asBoolean(true).isTrue();
                } else {
                    result = Expressions.asBoolean(false).isTrue();
                }
            }

            result = condition.equalsIgnoreCase("and") ? result.and(predicate) : result.or(predicate);
        }
        return result;
    }

    static class UserPredicate {
        static BooleanExpression getPredicate(SearchCriteria criteria) {
            PathBuilder<User> entityPath = new PathBuilder<>(User.class, "user");

            try {
                Double.parseDouble(criteria.getValue().toString());
                NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
                int value = Integer.parseInt(criteria.getValue().toString());
                switch (criteria.getOperation()) {
                    case "=":
                        return path.eq(value);
                    case ">":
                        return path.gt(value);
                    case ">=":
                        return path.goe(value);
                    case "<":
                        return path.lt(value);
                    case "<=":
                        return path.loe(value);
                }
            } catch (NumberFormatException e) {
                //Ignore
            }

            StringPath path = entityPath.getString(criteria.getKey());
            switch (criteria.getOperation()) {
                case "=":
                    return path.equalsIgnoreCase(criteria.getValue().toString());
                case ":":
                    return path.containsIgnoreCase(criteria.getValue().toString());
            }
            return null;
        }
    }
}
