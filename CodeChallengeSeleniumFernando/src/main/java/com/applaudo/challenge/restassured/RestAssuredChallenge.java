package com.applaudo.challenge.restassured;


import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredChallenge {
    private int iCharId;
    private final String newLine = System.getProperty("line.separator");

    @Test(groups = "allChars")
    public void getAllCharacters() {
        System.out.println("Exercise 2: Get all characters");
        Characters[] aCharacters = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get("https://www.breakingbadapi.com/api/characters").as(Characters[].class);

        for (int i = 0; i < aCharacters.length; i++) {
            if (aCharacters[i].getName().equals("Walter White")) {
                iCharId = aCharacters[i].getChar_id();
            }
            System.out.println("Character name: " + aCharacters[i].getName() + newLine + "Portrayed: " + aCharacters[i].getPortrayed() + newLine + "------------------------------------------------------");
        }
    }

        @Test(groups = "WalterWhite", priority = 1, dependsOnGroups = "allChars")
        public void getWalterWhiteTest()
        {
            System.out.println("Exercise 1: Get Walter White info");
            Assert.assertNotNull(iCharId);
            Characters[] aCharacters = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get("https://www.breakingbadapi.com/api/characters/" + iCharId).as(Characters[].class);
            for (int i = 0; i < aCharacters.length; i++) {
                Assert.assertEquals(aCharacters[i].getBirthday(),"09-07-1958");
                System.out.println("Birthday: " + aCharacters[i].getBirthday());
            }

    }



}
