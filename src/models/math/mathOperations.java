package models.math;

public class mathOperations {
    public Double addition(double a, double b){
        return a+b;
    }
    public Double substraction(double a, double b){
        return a-b;
    }
    public Double multiplication(double a, double b){
        return a*b;
    }
    public Double division(double a, double b){
        return a/b;
    }
    public Double min(double a, double b){
        double ret = a < b ? a : b;
        return ret;
    }
    public Double max(double a, double b){
        double ret = a > b ? a : b;
        return ret;
    }
}
