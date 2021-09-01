package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    public ProductRepository() {
    }

    private Product[] products = new Product[0];

    public void save(Product item) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        products = tmp;
    }
}
