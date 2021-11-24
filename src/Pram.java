public class Pram {
    public static final double Part = 100;

    public static void main(String[] args) {

        // Вл.класс
        Func f1 = new lnNat();
        System.out.println(findInt(f1, 2, 5, Part));

        // Ан. класс
        Func f2 = new Func() {
            @Override
            public double f(double x) {
                return x * 2 + x;
            }
        };
        System.out.println(findInt(f2, 3, 4, Part));

        //Ссылка ст. метод
        exp obj = new exp();
        Func f3 = obj::exp;
        System.out.println(findInt(f3, 0.01, 2, Part));

        //Ссылка yf метод
        Func f4 = X2::pow;
        System.out.println(findInt(f4, 1, 3, Part));

        // Лямбда
        Func f5 = x -> (x * Math.sin(x));
        System.out.println(findInt(f5, 0, 1, Part));

    }

    public static double findInt(Func func, double left, double right, double Part) {
        double S = 0;
        double sh = (right - left) / Part;
        for (int j = 0; j < Part; j++) {
            S = S + sh * func.f(sh * j + left);
        }
        return S;
    }


    private static class lnNat implements Func {
        @Override
        public double f(double x) {
            return Math.log10(x);
        }
    }


    private static class exp {
        double exp(double x) {
            return Math.exp(-x);
        }
    }

    private static class X2 {
        static double pow(double x) {
            return Math.pow(x, 2);
        }
    }

}


