package com.example.winify.cvsi.dto.builder;


import com.example.winify.cvsi.dto.templates.ProductTemplate;
import com.example.winify.cvsi.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artemie on 28.06.2016.
 */
public class ProductBuilder {

    public ProductTemplate getProductTemplate(Product product) {
        ProductTemplate productTemplate = new ProductTemplate();
        productTemplate.setId(product.getId());
        productTemplate.setTitle(product.getTitle());
        productTemplate.setDescription(product.getDescription());
        productTemplate.setCurrency(product.getCurrency());
        productTemplate.setPrice(product.getPrice());
        productTemplate.setBorrow(product.getIsBorrow());
        productTemplate.setLimitDate(product.getLimitDate().getTime());
        productTemplate.setCategoryEnumList(product.getCategoryEnumList());
        productTemplate.setCreatedDate(product.getCreatedDate().getTime());
        productTemplate.setUpdatedDate(product.getUpdatedDate().getTime());
        return productTemplate;
    }

    public List<ProductTemplate> getProductTemplateList(List<Product> productList) {
        List<ProductTemplate> productTemplateList = new ArrayList<ProductTemplate>();

        for (Product product : productList) {
            ProductTemplate productTemplate = new ProductTemplate();
            productTemplate.setId(product.getId());
            productTemplate.setTitle(product.getTitle());
            productTemplate.setDescription(product.getDescription());
            productTemplate.setCurrency(product.getCurrency());
            productTemplate.setPrice(product.getPrice());
            productTemplate.setBorrow(product.getIsBorrow());
            productTemplate.setLimitDate(product.getLimitDate().getTime());
            productTemplate.setCategoryEnumList(product.getCategoryEnumList());
            productTemplate.setCreatedDate(product.getCreatedDate().getTime());
            productTemplate.setUpdatedDate(product.getUpdatedDate().getTime());
            productTemplateList.add(productTemplate);
        }
        return productTemplateList;
    }
}