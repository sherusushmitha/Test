package utilities;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductList implements Serializable {
    private String category_name;
    private ArrayList<ProductData> productsData;

    public String getCategory_name() {
        return category_name;
    }

    public ArrayList<ProductData> getProductsData() {
        return productsData;
    }
}
