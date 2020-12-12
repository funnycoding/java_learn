package generics;

import arrays.Suppliers;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/12 10:49 下午
 */

// Store.java
// 挺有意思的例子，多个数据结构封装
class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price $" + price;
    }

    public void priceChange(Double change) {
        price += change;
    }

    // 随机商品生成器
    public static Supplier<Product> generator =
            new Supplier<Product>() {
                private Random rand = new Random(47);

                @Override
                public Product get() {
                    return new Product(rand.nextInt(1000), "Test",
                            Math.round(rand.nextDouble() * 1000) + 0.99);
                }
            };
}

// 货架，其中包含商品
class Shelf extends ArrayList<Product> {
    Shelf(int nProducts) {
        // 这个 fill 方法很有意思，值得弄清楚
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

// 向 Aisle 通道中添加货架
class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

// 收银台
class CheckoutStand {
}

// 办公室
class Office {
}


public class Store extends ArrayList<Aisle> {
    // 先来个收银台列表
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    // 再来个办公室
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        // 往走廊中添加 货架和产品
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }


    // 打印每个过道的每个货架中的每个商品
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // 5个走廊，每个走廊4个货架，每个货架3个商品
        System.out.println(new Store(5, 4, 3));
    }
}
