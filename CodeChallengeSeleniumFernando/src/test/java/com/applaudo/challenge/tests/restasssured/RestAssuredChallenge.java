package com.applaudo.challenge.tests.restasssured;


import com.applaudo.challenge.restassured.model.Characters;
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
        for (Characters oChar : aCharacters){
            if (oChar.getName().equals("Walter White")) {
                iCharId = oChar.getChar_id();
            }
            System.out.println("Character name: " + oChar.getName() + newLine + "Portrayed: " + oChar.getPortrayed() + newLine + "------------------------------------------------------");
        }
    }

        @Test(groups = "WalterWhite", priority = 1, dependsOnGroups = "allChars")
        public void getWalterWhiteTest()
        {
            System.out.println("Exercise 1: Get Walter White info");
            Assert.assertNotNull(iCharId);
            Characters[] aCharacters = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get("https://www.breakingbadapi.com/api/characters/" + iCharId).as(Characters[].class);
            for (Characters oChar : aCharacters){
                Assert.assertEquals(oChar.getBirthday(),"09-07-1958");
                System.out.println("Birthday: " + oChar.getBirthday());
            }
    }



}
