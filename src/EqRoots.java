public class EqRoots {
    private static final double EPS = 1e-5; // 1 * 10^-5

    public static void main(String[] args) {
        // Вл.класс
        Func f1 = new ExpMinusHalf();
        System.out.println(findRoot(f1, 0.01, 2, EPS));
        // Ан. класс
        Func f2 = new Func() {
            public double f(double x) {
                return Math.sin(x) - 0.75;
            }
        };
        System.out.println(findRoot(f2, 2, 3, EPS));
        //Ссылка ст. метод
        Func f3 = Math::tan;
        System.out.println(findRoot(f3, 2, 4, EPS));
        //Ссылка на метод
        LnXCubeMinus2 obj = new LnXCubeMinus2();
        Func f4 = obj::eval;
        System.out.println(findRoot(f4, 1, 3, EPS));
        // Лямбда
        Func f5 = x -> x * x * x - 8 * x + 2;
        System.out.println(findRoot(f5, 1, 5, EPS));
    }

    public static double findRoot(Func func, double left, double right, double eps) {
        while ((right - left) > eps) {
            double m = (left + right) / 2;
            if (func.f(m) == 0)
                return m;
            if (func.f(left) < 0 && func.f(m) < 0
                    || func.f(left) > 0 && func.f(m) > 0)
                left = m;
            else if (func.f(m) < 0 && func.f(right) < 0
                    || func.f(m) > 0 && func.f(right) > 0)
                right = m;
        }
        return left;
    }

    private static class ExpMinusHalf implements Func {
        @Override
        public double f(double x) {
            return Math.exp(-x) - 0.5;
        }
    }

    private static class LnXCubeMinus2 {
        double eval(double x) {
            return Math.log(x * x * x) - 2;
        }
    }
}
