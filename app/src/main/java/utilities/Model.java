package utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class Model implements Serializable {
    private String message,status;
    private UsersData usersdata;
    private ArrayList<ProductList> Productslist;
    private ArrayList<subcategories> subcategories;
    private  ArrayList<Addresslist> addresslists;

    public ArrayList<Addresslist> getAddresslists() {
        return addresslists;
    }

    public ArrayList<ProductList> getProductslist() {
        return Productslist;
    }

    private ArrayList<CategoriesList> Categorieslist;

    public ArrayList<utilities.subcategories> getSubcategories() {
        return subcategories;
    }

    public ArrayList<CategoriesList> getCategorieslist() {
        return Categorieslist;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public UsersData getUsersdata() {
        return usersdata;
    }
}
