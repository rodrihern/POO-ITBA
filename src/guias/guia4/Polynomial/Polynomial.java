package guias.guia4.Polynomial;

public class Polynomial {
    private double[] poly;

    public Polynomial(int grade) throws InvalidGradeException {
        if(grade < 0) {
            throw new InvalidGradeException();
        }
        poly = new double[grade + 1];
    }

    public void set(int idx, double value) throws InvalidIndexException {
        if(idx >= poly.length) {
            throw new InvalidIndexException();
        }
        poly[idx] = value;
    }

    public double eval(double x) {
        double ans = 0;
        int i = 0;
        for(double coef : poly) {
            ans += coef * Math.pow(x, i++);
        }
        return ans;
    }
}
