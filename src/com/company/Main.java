package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите номер задания (3 или 5):");
        Scanner scan = new Scanner(System.in);
        int var = scan.nextInt();
        switch (var){
            case 3:
                task3();
                break;
            case 5:
                task5();
                break;
            default:
                System.out.println("Такого задания нет.");
                break;
        }
    }

    public static void task3() {
        double A = 1;
        double m = 5;
        double C = 16;
        double a = m - Math.sqrt(C / A);
        double b = m + Math.sqrt(C / A);
        double M = 3 * Math.sqrt(A) / (4 * Math.sqrt(C));
        double[] X = new double[20];
        double dispv = 0;
        double mov = 0;

        int i;
        for(i = 0; i < 20; ++i) {
            double x1;
            double x2;
            double f;
            do {
                double r1 = Math.random();
                double r2 = Math.random();
                x1 = a + r1 * (b - a);
                x2 = M * r2;
                f = 3 * Math.sqrt(A) / (4 * C * Math.sqrt(C)) * (C - A * Math.pow(x1 - m, 2));
            } while(x2 > f);

            X[i] = x1;
            mov += x1;
            //System.out.println("X[" + (i + 1) + "] = " + X[i]);
        }
        System.out.format("+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n");
        System.out.format("|    №   |    1   |    2   |    3   |    4   |    5   |    6   |    7   |    8   |    9   |    10  |    11  |    12  |    13  |    14  |    15  |    16  |    17  |    18  |    19  |    20  |\n");
        System.out.format("+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n");
        System.out.format("|    X   |%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|\n", X[0], X[1], X[2], X[3], X[4], X[5], X[6], X[7], X[8], X[9], X[10], X[11], X[12], X[13], X[14], X[15], X[16], X[17], X[18], X[19]);
        System.out.format("+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n");


        double y2 = (20 * C * Math.pow(m, 2) + 4 * (Math.pow(C, 2) / A)) / (20 * C);
        double disp = y2 - Math.pow(m, 2);
        mov /= 20;

        for(i = 0; i < 20; ++i) {
            dispv += Math.pow(X[i] - mov, 2);
        }

        dispv /= 19;
        System.out.print("\n");
        System.out.format("+--------------------------------------+           +--------------------------------------+\n");
        System.out.format("|     характеристики распределения     |           |       выборочные характеристики      |\n");
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
        System.out.format("| мат. ожидание  |         %.1f         |           | среднее выборочное   |    %.5f    |\n", m, mov);
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
        System.out.format("|   дисперсия    |         %.2f        |           | выборочная дисп.     |    %.5f    |\n", disp, dispv);
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
        System.out.format("| ср.квадр. откл |       %.7f     |           | ср.квадр. откл       |    %.7f  |\n", Math.sqrt(disp), Math.sqrt(dispv));
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
    }

    public static void task5() {
        double[] randNum = new double[20];
        double[] P = new double[10];
        double[] resN = new double[20];
        double q = 0.6;
        double p = 1 - q;

        //моделирование случайных чисел r
        for (int i = 0; i<20; i++) {
            randNum[i] = Math.random();
        }
        System.out.format("+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n");
        System.out.format("|    №   |    1   |    2   |    3   |    4   |    5   |    6   |    7   |    8   |    9   |    10  |    11  |    12  |    13  |    14  |    15  |    16  |    17  |    18  |    19  |    20  |\n");
        System.out.format("+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n");
        System.out.format("|    r   |%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|%.6f|\n", randNum[0], randNum[1], randNum[2], randNum[3], randNum[4], randNum[5], randNum[6], randNum[7], randNum[8], randNum[9], randNum[10], randNum[11], randNum[12], randNum[13], randNum[14], randNum[15], randNum[16], randNum[17], randNum[18], randNum[19]);
        System.out.format("+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n");

        //вычисление вероятностей P
        for (int k = 1; k<11; k++) {
            P[k-1]=Math.pow(q,k-1)*p;
        }
        System.out.print("\n");
        System.out.format("+--------+---+----+-----+------+-------+--------+--------+---------+----------+-----------+\n");
        System.out.format("|    k   | 1 |  2 |  3  |   4  |   5   |    6   |    7   |    8    |     9    |     10    |\n");
        System.out.format("+--------+---+----+-----+------+-------+--------+--------+---------+----------+-----------+\n");
        System.out.format("|    P   |%.1f|%.2f|%.3f|%.4f|%.5f|%.6f|%.6f|%.7f|%.8f|%.9f|\n", P[0], P[1], P[2], P[3], P[4], P[5], P[6], P[7], P[8], P[9]);
        System.out.format("+--------+---+----+-----+------+-------+--------+--------+---------+----------+-----------+\n");

        //определение интервала, в к-й попадает каждое r
        double mv = 0;
        double left = 0;
        double right = P[0];
        for (int i = 0; i<20; i++) {
            for (int k = 0; k<10; k++) {
                if (randNum[i]>=left && randNum[i]<right) {
                    resN[i] = k + 1;
                    left = 0;
                    right = P[0];
                    mv+=resN[i];
                    break;
                } else {
                    left = right;
                    right += P[k+1];
                }
            }
        }
        System.out.print("\n");
        System.out.format("+--------+---+---+---+---+---+---+---+---+---+----+----+----+----+----+----+----+----+----+----+----+\n");
        System.out.format("|  r[i]  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 |\n");
        System.out.format("+--------+---+---+---+---+---+---+---+---+---+----+----+----+----+----+----+----+----+----+----+----+\n");
        System.out.format("|    N   | %1.0f | %1.0f | %1.0f | %1.0f | %1.0f | %1.0f | %1.0f | %1.0f | %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |  %1.0f |\n", resN[0], resN[1], resN[2], resN[3], resN[4], resN[5], resN[6], resN[7], resN[8], resN[9], resN[10], resN[11], resN[12], resN[13], resN[14], resN[15], resN[16], resN[17], resN[18], resN[19]);
        System.out.format("+--------+---+---+---+---+---+---+---+---+---+----+----+----+----+----+----+----+----+----+----+----+\n");

        //вычисление и сравнение выборочных характеристик и характеристик распределения
        double m = 1/p; //мат ожидание
        double disp = q/Math.pow(p, 2); //дисперсия
        double dispv = 0;
        mv /= 20;
        for (int i = 0; i<20; i++) {
            dispv += Math.pow(resN[i] - mv, 2);
        }
        dispv /= 19;
        System.out.print("\n");
        System.out.format("+--------------------------------------+           +--------------------------------------+\n");
        System.out.format("|     характеристики распределения     |           |       выборочные характеристики      |\n");
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
        System.out.format("| мат. ожидание  |         %.1f         |           | среднее выборочное   |    %.5f    |\n", m, mv);
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
        System.out.format("|   дисперсия    |         %.2f        |           | выборочная дисп.     |    %.5f    |\n", disp, dispv);
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
        System.out.format("| ср.квадр. откл |       %.7f     |           | ср.квадр. откл       |    %.7f  |\n", Math.sqrt(disp), Math.sqrt(dispv));
        System.out.format("+----------------+---------------------+           +----------------------+---------------+\n");
    }
}
