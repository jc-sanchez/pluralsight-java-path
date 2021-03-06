package com.jcsanchez.collections.maps;

import java.util.Comparator;
import static java.util.Comparator.comparing;

/**
 * Created by jsssn on 23-Apr-17.
 */
public class Product {
    public static final Comparator<Product> BY_WEIGHT
            = comparing(Product::getWeight);

    public static final Comparator<Product> BY_NAME
            = comparing(Product::getName);

    private final int id;
    private final String name;
    private final int weight;

    public Product(final int id, final String name, final int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getWeight() { return weight; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + weight;
        return result;
    }
}
