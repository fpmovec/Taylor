import java.util.Scanner;
import java.text.*;
import java.util.*;
public class TaylorWithBD {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        Formatter frmt = new Formatter();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Solving function: sin(x)/x");
        System.out.println("Format for e: 10^(-k)");
        System.out.println("Enter k, please");
        System.out.print("Your k: ");
        Taylor.SetK(inputScanner.nextInt());
        System.out.print("Enter x, please: ");
        Taylor.SetX(inputScanner.nextDouble());
        if (Taylor.GetX() == 0) {
            System.out.println("X не может быть 0");
            return;
        } else {
            System.out.printf("Your e = 10^(-%d) \n", Taylor.GetK());
            numberFormat.setMaximumFractionDigits(Taylor.GetK() + 1);
            System.out.println("X = " + Taylor.GetX());
            System.out.println("Your answer = " + numberFormat.format(Taylor.TaylorSolving(Taylor.GetK(), Taylor.GetX())));
            frmt.format("In HEX(double): %a In OCT(int): %o", Taylor.TaylorSolving(Taylor.GetK(), Taylor.GetX()), (int) Taylor.TaylorSolving(Taylor.GetK(), Taylor.GetX()));
            System.out.println(frmt);
            frmt = new Formatter();
            frmt.format("With floating point: %f", Taylor.TaylorSolving(Taylor.GetK(), Taylor.GetX()));
            System.out.println(frmt);
            frmt = new Formatter();
            frmt.format("Limited field: %(+012.9f", Taylor.TaylorSolving(Taylor.GetK(), Taylor.GetX()));
            System.out.println(frmt);
            frmt = new Formatter();
            frmt.format("%4$d, %2$d, %3$d, %1$d", 1, 2, 3, 4);
            System.out.println(frmt);
            System.out.print("Standard function: " + numberFormat.format(Math.sin(Taylor.GetX()) / Taylor.GetX()));
        }
    }
}
    class Taylor
    {
        private static int k;
        private static double X;

        public static void SetK(int number){
            k = number;
        }
        public static int GetK(){
            return k;
        }
        public static void SetX(double number){
            X = number;
        }
        public static double GetX(){
            return X;
        }

        public static double TaylorSolving(double degree, double argument){
            double epsilon = Math.pow(10, -degree);
            double taylorResult = 0;
            int n = 1;
            double member = 1;

            while (Math.abs(member) >= epsilon){

                if(n > 1) {
                    member *= (-((double) Math.pow(argument, 2)) / (double)((2 * n - 2) * (2 * n - 1)));
                }
                taylorResult += member;
                n++;
            }
            return taylorResult;
        }
}
