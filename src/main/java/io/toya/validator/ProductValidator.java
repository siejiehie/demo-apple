package io.toya.validator;

import io.toya.form.ProductForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Higgs on 2017/3/11.
 */
public class ProductValidator {

    public List<String> validate(ProductForm productForm) {
        List<String> errors = new ArrayList<String>();
        String name = productForm.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.add("Product must have a name");
        }
        String price = productForm.getPrice();
        if (price == null || price.trim().isEmpty()) {
            errors.add("Product must have a price");
        } else {
            try {
                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                errors.add("Invalid price value");
                e.printStackTrace();
            }
        }
        return errors;
    }

}
