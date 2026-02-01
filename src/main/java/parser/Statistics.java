package parser;

import java.math.BigInteger;

public class Statistics {
    private BigInteger intCounter = BigInteger.ZERO;
    private int doubleCounter = 0;
    private int stringCounter = 0;

    private BigInteger intMin= BigInteger.ZERO;
    private BigInteger intMax= BigInteger.ZERO;
    private BigInteger intSum = BigInteger.ZERO;
    private BigInteger intAverage = BigInteger.ZERO;

    private double doubleMin;
    private double doubleMax;
    private double doubleSum;
    private double doubleAverage;

    private int minStringSize;
    private int maxStringSize;


    public void CollectStatInt(BigInteger num) {
        intCounter = intCounter.add(BigInteger.ONE);
        intSum.add(num);
        this.intSum = this.intSum.add(num);

        if (num.compareTo(intMax) > 0) {
                intMax = num;
        }
        if (num.compareTo(intMin) < 0) {
            intMin = num;
        }
    }

    public void CollectStatDouble(double num) {
        doubleCounter++;
        doubleSum += num;

        if (num > Double.MAX_VALUE) {
            doubleMax = num;
        }
        if (num < Double.MIN_VALUE) {
            doubleMin = num;
        }
    }
    public void CollectStatString(String string) {
        stringCounter++;

        if (string.length() > Integer.MAX_VALUE) {
            maxStringSize = string.length();
        }
        if (string.length() < Integer.MAX_VALUE) {
            minStringSize = string.length();
        }
    }

    public void PrintShortStatistics() {
        System.out.println("Количество записанных целых чисел: " + intCounter);
        System.out.println("Количество записанных чисел с плавающей точкой: " + doubleCounter);
        System.out.println("Количество записанных целых чисел: " + stringCounter);
    }

    public void PrintFullStatistics() {
        intAverage = intSum.divide(intCounter);
        doubleAverage = doubleSum / doubleCounter;

        System.out.println("Количество записанных целых чисел: " + intCounter);
        System.out.println("Максимальное целое число: " + intMax);
        System.out.println("минимальное целое число: " + intMin);
        System.out.println("Среднее среди целых чисел: " + intAverage);
        System.out.println();
        System.out.println("Количество записанных чисел с плавающей точкой: " + doubleCounter);
        System.out.println("Максимальное число с плавающей точкой: " + doubleMax);
        System.out.println("Минимальное число с плавающей точкой: " + doubleMin);
        System.out.println("Среднее среди чисел с плавающей точкой: " + doubleAverage);
        System.out.println();
        System.out.println("Количество записанных строк: " + stringCounter);
        System.out.println("Самая короткая строка: " + minStringSize);
        System.out.println("Самая длинная строка: " + maxStringSize);
    }
}
