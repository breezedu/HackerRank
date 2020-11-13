package tenDaysStats;

public class Stats_day06_CentralLimitTheorem_Simpson02 { 
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = 100;
        double mean = 2.4 * n;
        double std = 2.0 * Math.sqrt(n);

        double prob1 = getCummulativeProbability (250, mean, std);
        System.out.printf("%.4f\n", (prob1));
    }

   static double getCummulativeProbability (double x, double mean, double std)
        {
            Function function = new Function();

            // ENTER the desired values of a, b and n !!!
            double z = (x-mean)/(std * Math.sqrt(2));
            double a = 0;                                           
            double b = z;
            int n = 10000;
            // Applies simpson method to function
            double erf = function.IntSimpson(a,b,n) * 2 / (Math.sqrt(Math.PI));
            return 0.5 * (1 + erf);
        }

        static class Function{                                                        

        // Define the function to integrate
        double f (double x) {                                              
           return Math.exp(-Math.pow(x, 2));
        }

        // Simpson's method for integral calculus
        // a = lower bound
        // b = upper bound of integration
        // n = number of passes (higher = less margin of error, but takes longer)
        double IntSimpson(double a, double b,int n){                       
           int i,z;                                                       
           double h,s;                                                    

           n=n+n;
           s = f(a)*f(b);
           h = (b-a)/n;                                        
           z = 4;

           for(i = 1; i<n; i++){
              s = s + z * f(a+i*h);
              z = 6 - z;
           }
           return (s * h)/3;
        } 
    }  

}
