package features.java8;

// additional packages consists of classes, interfaces and enums to allows functional-style operations on the elements

// Stream does not store elements and is functional in nature
// Operations performed on a stream does not modify original source.
// Stream is lazy
// The elements of a stream are only visited once during the life of a stream
// Like an iterator, a new stream must be generated to revisit the same elements of the source


// stream interface methods

// boolean allMatch(Predicate<? super T> predicate): returns all elements of this stream match the provided predicate
// boolean anyMatch(Predicate<? super T> predicate):

// Stream<T> filter(Predicate<? super T> predicate): filter by predicate

// Optional<T> findAny()
// Optional<T> findFirst()

// <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
// DoubleStream flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)

// void forEach(Consumer<? super T> action)

// Stream<T> limit(long maxSize)

// <R> Stream <R> map(Function<? super T, ? extends R> mapper)
// DoubleStream map(DoubleFunction<? super T> mapper)

// Optional<T> max(Comparator<? super T> comparator>

// Optional<T> reduce(BinaryOperator<T> accumulator)
// T reduce(T identity, BinaryOperator<T> accumulator>
// <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)

// Stream<T> sorted()
// Stream<T> sorted(Comparator<? super T> comparator)

// Object[] toArray()

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CompanyProduct{
    int id;
    String name;
    float price;
    public CompanyProduct(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class StreamExample {
    public static void main(String[] args) {

        System.out.println("----------------Example 1: Stream to filter product with predicate-----------------------");

        List<CompanyProduct> productList = new ArrayList<>();
        productList.add(new CompanyProduct(1, "HP Laptop", 25000f));
        productList.add(new CompanyProduct(2, "Dell Laptop", 30000f));
        productList.add(new CompanyProduct(3, "Lenovo Laptop", 28000f));
        productList.add(new CompanyProduct(4, "Sony Laptop", 27500f));
        productList.add(new CompanyProduct(5, "Apple Laptop", 90000f));
        List<Float> productItemPriceList = productList.stream()
                .filter(product -> product.price > 27000f)
                .map(product -> product.price)
                .collect(Collectors.toList());  // Collectors.toSet() to remove duplicates
        System.out.println(productItemPriceList);
        System.out.println('\n');

        System.out.println("----------------Example 2: Stream to sum price of product-----------------------");
        Float totalPrice = productList.stream().map(product -> product.price).reduce(0.0f, Float::sum);
        System.out.println("Total price of all products are: " + totalPrice);
        System.out.println('\n');

        System.out.println("----------------Example 3: Stream to find element with max price-----------------------");
        CompanyProduct productWithMaxPrice = productList.stream().max((p1, p2) -> Float.compare(p1.price, p2.price)).get();
        System.out.println("Product " + productWithMaxPrice.name + " has a maximum price (" + productWithMaxPrice.price + ")");
        System.out.println('\n');

        System.out.println("----------------Example 4: Filter and collect as a Map-----------------------");
        Map<Integer, String> mapProduct = productList.stream()
                .filter(p -> p.price > 27000)
                .collect(Collectors.toMap(
                    p -> p.id, p -> p.name
                ));
        System.out.println(mapProduct);
        System.out.println('\n');

        System.out.println("----------------Example 3: Iterate element-----------------------");
        Stream.iterate(1, e -> e + 1).filter(e -> e % 5 == 0).limit(5).forEach(System.out::println);
    }
}
