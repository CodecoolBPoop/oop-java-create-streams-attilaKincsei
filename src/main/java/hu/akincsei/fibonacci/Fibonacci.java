//package hu.akincsei.fibonacci;
//
//import java.util.List;
//import java.util.stream.Stream;
//import static java.util.stream.Collectors.toList;
//
//public class Fibonacci {
//
//    /**
//     * Java 8 / Lambda approach to generate fibonacci series.
//     * Fibonacci always start as classic (e.g. 0, 1, 1, 2, 3, 5)
//     * @param series Number of how many fibonacci number should be generated
//     * @return List holding resulting fibonacci number.
//     */
//    public static List<Integer> generate(int series) {
//        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
//                .limit(series)
//                .map(n -> n[0])
//                .collect(toList());
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Fibonacci.generate(10)); // Test the code.
//    }
//}
//
//https://stackoverflow.com/questions/30595844/java-8-lambda-expressions-for-solving-fibonacci-non-recursive-way
//Stream.iterate(new long[]{ 1, 1 }, p->new long[]{ p[1], p[0]+p[1] })
//        .limit(92).forEach(p->System.out.println(p[0]));
//
//
//        27
//        down vote
//        accepted
//        The simplest solution is to use a stream of Pairs:
//
//        Stream.iterate(new long[]{ 1, 1 }, p->new long[]{ p[1], p[0]+p[1] })
//        .limit(92).forEach(p->System.out.println(p[0]));
//        Due to the lack of a standard pair type, it uses a two-element array. Further, I use .limit(92) as we can’t evaluate more elements using long values. But it’s easy to adapt to BigInteger:
//
//        Stream.iterate(new BigInteger[]{ BigInteger.ONE, BigInteger.ONE },
//        p->new BigInteger[]{ p[1], p[0].add(p[1]) })
//        .forEach(p->System.out.println(p[0]));
//        That’ll run until you haven’t enough memory to represent the next value.
//
//        BTW, to get the nth element from the stream:
//
//        Stream.iterate(new long[]{1, 1}, p -> new long[]{p[1], p[0] + p[1]})
//        .limit(91).skip(90).findFirst().get()[1];
//
//
//        https://stackoverflow.com/questions/30595844/java-8-lambda-expressions-for-solving-fibonacci-non-recursive-way/30632678
//
//
//        import java.util.List;
//        import java.util.stream.Stream;
//        import static java.util.stream.Collectors.toList;
//
//public class Fibonacci {
//
//    /**
//     * Java 8 / Lambda approach to generate fibonacci series.
//     * Fibonacci always start as classic (e.g. 0, 1, 1, 2, 3, 5)
//     * @param series Number of how many fibonacci number should be generated
//     * @return List holding resulting fibonacci number.
//     */
//    public static List<Integer> generate(int series) {
//        return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]})
//                .limit(series)
//                .map(n -> n[0])
//                .collect(toList());
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Fibonacci.generate(10)); // Test the code.
//    }
//}
//https://gist.github.com/artlovan/d7315b375f4553a1be1605b16c7a9098
//
//        To get Nth fibonacci element (using reduction):
//
//        Stream.iterate(new long[] {1, 1}, f -> new long[] {f[1], f[0] + f[1]})
//        .limit(n)
//        .reduce((a, b) -> b)
//        .get()[0];
//
//        https://stackoverflow.com/questions/30595844/java-8-lambda-expressions-for-solving-fibonacci-non-recursive-way