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
public class Complex {

    public double real;
    public double imaginary;

    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    public Complex multiply(final Complex x) {
        final Complex copy = new Complex(this.real, this.imaginary);
        copy.real = this.real * x.real - this.imaginary * x.imaginary;
        copy.imaginary = this.imaginary * x.real + this.real * x.imaginary;
        return copy;
    }

    public Complex add(final Complex x) {
        final Complex copy = new Complex(this.real, this.imaginary);
        copy.real += x.real;
        copy.imaginary += x.imaginary;
        return copy;
    }

    public Complex sub(final Complex x) {
        final Complex copy = new Complex(this.real, this.imaginary);
        copy.real -= x.real;
        copy.imaginary -= x.imaginary;
        return copy;
    }

    public double abs() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
    }

    public String toString() {
        return "(" + this.real + "," + this.imaginary + ")";
    }

    public static Complex polar(final double rho, final double theta) {
        return (new Complex(rho * Math.cos(theta), rho * Math.sin(theta)));
    }
}