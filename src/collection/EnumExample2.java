package collection;

import java.util.function.BiFunction;
import java.util.function.IntFunction;

class EnumMovie {
    enum Type {
        REGULAR, NEW_RELEASE, CHILDREN
    }
    private final Type type;

    public EnumMovie(Type type) {
        this.type = type;
    }

    public int computePrice(int days) {
        return switch (type) {
            case REGULAR -> days + 1;
            case NEW_RELEASE -> days * 2;
            case CHILDREN -> 5;
        };
    }
}


abstract class Movie {
    abstract int computePrice(int days);
}

class RegularMovie extends Movie {
    @Override
    int computePrice(int days) {
        return days + 1;
    }
}

class NewReleaseMovie extends Movie {
    @Override
    int computePrice(int days) {
        return days * 2;
    }
}

class ChildrenMovie extends Movie {
    @Override
    int computePrice(int days) {
        return 5;
    }
}

class PriceService {
    int computeRegularPrice(int days) {
        return days + 1;
    }
    int computeChildrenPrice(int days) {
        return 5;
    }
    int computeNewReleasePrice(int days) {
        return days * 2;
    }
}

class MovieV2 {
    enum Type {
        REGULAR(PriceService::computeRegularPrice),
        CHILDREN(PriceService:: computeChildrenPrice),
        NEW_RELEASE(PriceService::computeNewReleasePrice);

        public final BiFunction<PriceService, Integer, Integer> priceAlgo;
        Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
            this.priceAlgo = priceAlgo;
        }
    }

    private final Type type;
    private final PriceService priceService;

    public MovieV2(Type type, PriceService priceService) {
        this.type = type;
        this.priceService = priceService;
    }

    public int computePrice(int days) {
        return type.priceAlgo.apply(priceService, days);
    }
}

public class EnumExample2 {
    public static void main(String[] args) {

        System.out.println("----------------Example 1: Using switch with enum-----------------------");

        System.out.println("REGULAR: " + new EnumMovie(EnumMovie.Type.REGULAR).computePrice(2));
        System.out.println("CHILDREN: " + new EnumMovie(EnumMovie.Type.CHILDREN).computePrice(2));
        System.out.println("NEW_RELEASE: " + new EnumMovie(EnumMovie.Type.NEW_RELEASE).computePrice(2));
        System.out.println('\n');

        System.out.println("----------------Example 2: Using abstract class with derived classes-----------------------");
        System.out.println("REGULAR: " + new RegularMovie().computePrice(2));
        System.out.println("CHILDREN: " + new ChildrenMovie().computePrice(2));
        System.out.println("NEW_RELEASE: " + new NewReleaseMovie().computePrice(2));
        System.out.println('\n');

        System.out.println("----------------Example 3: One class with many methods-----------------------");
        System.out.println("REGULAR: " + new PriceService().computeRegularPrice(2));
        System.out.println("CHILDREN: " + new PriceService().computeChildrenPrice(2));
        System.out.println("NEW_RELEASE: " + new PriceService().computeNewReleasePrice(2));
        System.out.println('\n');

        System.out.println("----------------Example 4: With biFunction-----------------------");
        PriceService priceService = new PriceService();
        int days = 2;

        System.out.println("REGULAR: " + new MovieV2(MovieV2.Type.REGULAR, priceService).computePrice(days));
        System.out.println("CHILDREN: " + new MovieV2(MovieV2.Type.CHILDREN, priceService).computePrice(days));
        System.out.println("NEW_RELEASE: " + new MovieV2(MovieV2.Type.NEW_RELEASE, priceService).computePrice(days));
        System.out.println('\n');

    }
}
