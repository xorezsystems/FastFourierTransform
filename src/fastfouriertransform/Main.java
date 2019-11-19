/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfouriertransform;

import java.util.Random;

/**
 *
 * @author xorez
 */
public class Main {
    private static final int MIN = 1;
    private static final int MAX = 1000;
    private static final Random RANDOM = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int a = Math.abs(nextRandomInt(MIN, MAX));
        int b = Math.abs(nextRandomInt(MIN, MAX));
        applyFFT(Integer.toString(a), Integer.toString(b));
        
    }
    
    private static int nextRandomInt(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }
    
    public static void applyFFT(String a, String b) {
        if (a.equals("0") || b.equals("0")) {
            //return "0";
        }
        boolean negative = false;
        if ((a.charAt(0) == '-' && b.charAt(0) != '-') || (a.charAt(0) != '-' && b.charAt(0) == '-')) {
            negative = true;
        }
        if (a.charAt(0) == '-') {
            a = a.substring(1);
        }
        if (b.charAt(0) == '-') {
            b = b.substring(1);
        }
        int size = 1;
        while (size < (a.length() + b.length())) {
            size *= 2;
        }
        Complex[] aCoefficients = new Complex[size];
        Complex[] bCoefficients = new Complex[size];
        for (int i = 0; i < size; i++) {
            aCoefficients[i] = new Complex();
            bCoefficients[i] = new Complex();
        }
        for (int i = 0; i < a.length(); i++) {
            aCoefficients[i] = new Complex((double) (Character.getNumericValue(a.charAt(a.length() - i - 1))), 0.0);
        }
        for (int i = 0; i < b.length(); i++) {
            bCoefficients[i] = new Complex((double) (Character.getNumericValue(b.charAt(b.length() - i - 1))), 0.0);
        }
        
        System.out.println(".: Transformada Rápida de Fourier (método Cooley y John Tukey) :.");
        System.out.println("Size:"+aCoefficients.length);
        System.out.println("..::: Matriz de Coefficientes :::..");
        for (int i = 0; i < aCoefficients.length; i++) {
            System.out.println("["+aCoefficients[i].toString()+"]");
        }
        
        FastFourierTransform.cooleyTukeyFFT(aCoefficients);
        FastFourierTransform.cooleyTukeyFFT(bCoefficients);
        
        System.out.println("..::: Matriz de Transformación Inversa :::..");
        
        for (int i = 0; i < aCoefficients.length; i++) {
            System.out.println("["+aCoefficients[i]+"]");
        }
    }
    
}
