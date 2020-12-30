package com.applaudo.challenge.tests.utilities;

import java.util.Random;

public class Utilities {
    /*METHOD: randomNumberGenerator
      AUTHOR: Fernando Maldonado
      CREATED: 11/13/2020-Fernando Maldonado
      UPDATED: 11/13/2020-Fernando Maldonado*/
    public int randomNumberGenerator(int iMin, int iMax){
        try {
            Random randomGenerator = new Random();
            int iRandomNumber = randomGenerator.nextInt(iMax - iMin) + iMin;
            return iRandomNumber;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
}
