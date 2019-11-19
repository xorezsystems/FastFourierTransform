/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfouriertransform;

/**
 *
 * @author xorez
 */
public class FastFourierTransform {
    
    private FastFourierTransform() { }
    
    public static void cooleyTukeyFFT(Complex[] coefficients) {
        final int size = coefficients.length;
        if (size <= 1) 
            return;

        final Complex[] even = new Complex[size / 2];
        final Complex[] odd = new Complex[size / 2];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                even[i / 2] = coefficients[i];
            } else {
                odd[(i - 1) / 2] = coefficients[i];
            }
        }
        cooleyTukeyFFT(even);
        cooleyTukeyFFT(odd);
        for (int k = 0; k < size / 2; k++) {
            Complex t = Complex.polar(1.0, -2 * Math.PI * k / size).multiply(odd[k]);
            coefficients[k] = even[k].add(t);
            coefficients[k + size / 2] = even[k].sub(t);
        }
    } 
}
