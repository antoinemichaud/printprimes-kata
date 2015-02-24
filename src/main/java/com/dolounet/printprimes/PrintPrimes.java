package com.dolounet.printprimes;

public class PrintPrimes {
    public static void main(String[] args) {
        printPrimesUntil1000();
    }

    static void printPrimesUntil1000() {
        final int NUMBER_OF_PRIMES_TO_PRINT = 1000;
        final int ROWS_NUMBER = 50;
        final int COLUMNS_NUMBER = 4;

        final int ORDMAX = 30;
        int P[] = new int[NUMBER_OF_PRIMES_TO_PRINT + 1];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;

        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N;
        int MULT[] = new int[ORDMAX + 1];

        J = 1;
        K = 1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (K < NUMBER_OF_PRIMES_TO_PRINT) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] = MULT[N] + P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N = N + 1;
                }
            } while (!JPRIME);
            K = K + 1;
            P[K] = J;
        }
        {
            PAGENUMBER = 1;
            PAGEOFFSET = 1;
            while (PAGEOFFSET <= NUMBER_OF_PRIMES_TO_PRINT) {
                System.out.println("The First " + NUMBER_OF_PRIMES_TO_PRINT + " Prime Numbers --- Page " + PAGENUMBER);
                System.out.println("");
                for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + ROWS_NUMBER; ROWOFFSET++) {
                    for (C = 0; C < COLUMNS_NUMBER; C++)
                        if (ROWOFFSET + C * ROWS_NUMBER <= NUMBER_OF_PRIMES_TO_PRINT)
                            System.out.format("%10d", P[ROWOFFSET + C * ROWS_NUMBER]);
                    System.out.println("");
                }
                System.out.println("\f");
                PAGENUMBER = PAGENUMBER + 1;
                PAGEOFFSET = PAGEOFFSET + ROWS_NUMBER * COLUMNS_NUMBER;
            }
        }
    }
}
