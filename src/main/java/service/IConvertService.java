package service;

import org.springframework.data.jpa.domain.Specification;
import repository.entity.Product;

import java.util.Map;

public interface IConvertService {
    Map<String, Object> convertParamToFilter(String param);

    Specification<Product> createSpecification(Map<String, Object> filter);
}
