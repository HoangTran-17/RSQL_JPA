package service;

import org.springframework.data.jpa.domain.Specification;
import repository.entity.Product;
import service.operator.LogicalOperator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static service.QueryOperator.EQUALS;
import static service.QueryOperator.NOT_EQ;

public class ConvertService implements IConvertService{

    @Override
    public Map<String, Object> convertParamToFilter(String filter) {
        Map<String, Object> filterMap = new HashMap<>();
        matcher(filterMap, filter);
        return filterMap;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Specification<Product> createSpecification(Map<String, Object> filter) {
        List<String> value = (List<String>) filter.get("value");
        String key = (String) filter.get("key");
        if (key.equals(LogicalOperator.AND.getKey())) {

        } else if (key.equals(LogicalOperator.OR.getKey())) {

        } else if (key.equals(LogicalOperator.NOT.getKey())) {

        }

        switch (key){
//            case LogicalOperator.AND.getKey():
//                return (root, query, criteriaBuilder) ->
//                        criteriaBuilder.equal(
//                                root.get(value.get(0)), value.get(1)
//                        );
//            case NOT_EQ:
//                return (root, query, criteriaBuilder) ->
//                        criteriaBuilder.notEqual(
//                                root.get(value.get(0)), value.get(1)
//                        );
//            case GREATER_THAN:
//                return (root, query, criteriaBuilder) ->
//                        criteriaBuilder.gt(root.get(input.getField()),
//                                (Number) castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
//            case LESS_THAN:
//                return (root, query, criteriaBuilder) ->
//                        criteriaBuilder.lt(root.get(input.getField()),
//                                (Number) castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
//            case IN:
//                return (root, query, criteriaBuilder) ->
//                        criteriaBuilder.in(root.get(input.getField()))
//                                .value(castToRequiredType(root.get(input.getField()).getJavaType(), input.getValues()));
            default:
                throw new RuntimeException("Operation not supported yet");
        }
    }
    private Object castToRequiredType(Class fieldType, String value) {
        if(fieldType.isAssignableFrom(Double.class)){
            return Double.valueOf(value);
        }else if(fieldType.isAssignableFrom(Integer.class)){
            return Integer.valueOf(value);
        }else if(Enum.class.isAssignableFrom(fieldType)){
            return Enum.valueOf(fieldType, value);
        }
        return null;
    }
    private Object castToRequiredType(Class fieldType, List<String> value) {
        List<Object> lists = new ArrayList<>();
        for (String s : value) {
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }

    private Map<String, Object> matcher(Map<String, Object> filter, String param) {
        String regex = "([\\w]+)\\(([\\w,'()-]+)\\)"; // abc(xyz)
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(param);
        while (matcher.find()){
            filter.put("key", matcher.group(1));
            List<String> listParam = new LinkedList<>();
            splitFilter(listParam, matcher.group(2));
            List<Object> value = new LinkedList<>();
            listParam.forEach(subParam -> {
                if (subParam.contains(")")) {
                    Map<String, Object> subFilter = new HashMap<>();
                    matcher(subFilter, subParam);
                    value.add(subFilter);
                } else {
                    value.add(subParam);
                }
            });
            filter.put("value", value);
        }
        return filter;
    }

    private List<String> splitFilter(List<String> list, String param) {
        int x = 0;
        int i = 0;
        for(; i < param.length(); i++){
            char character = param.charAt(i);
            if (character == ',' && x == 0) break;
            if (character == '(') x++;
            if (character == ')') x--;
        }
        list.add(param.substring(0, i));
        if (i < param.length()){
            param = param.substring(++i);
            splitFilter(list, param);
        }
        return list;
    }


}
