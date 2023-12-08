package controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConvertService;
import service.IConvertService;
import service.IProductService;
import service.dto.ProductDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Getter
@Setter
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IConvertService convertService = new ConvertService();
    @Autowired
    private IProductService productService;
    @GetMapping
    public List<ProductDTO> search(@RequestParam(name = "filter") String filter){
        filter = "and(eq(name,'dale'),eq(format,'ruled'),or(bounded,lt(shipDate,2017-07-27)))";
        Map<String, Object> filterMap = convertService.convertParamToFilter(filter);


        List<ProductDTO> list = new ArrayList<>();

        return list;
    }
}
