package apitests;


import controllers.GetCharactersEndPoint;
import io.restassured.response.Response;
import models.Characters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CharactersAPITest {
    private int iCharId;
    private final String newLine = System.getProperty("line.separator");
    private final String getCharactersEndPoint = "https://www.breakingbadapi.com/api/characters";
    GetCharactersEndPoint oEndpointRespone = new GetCharactersEndPoint();

    @Test(groups = "allChars")
    public void verifyCharactersInfo() {
        System.out.println("Exercise 2: Get all characters");

        Response epResponse = oEndpointRespone.getCharacters(getCharactersEndPoint);
        Characters[] aCharacters = epResponse.as(Characters[].class);

        //Exercise 2
        //ITERATE AND ASSIGN ID WHEN NAME IS WALTER WHITE
        Arrays.stream(aCharacters).
                forEach(oChar ->
                {
                    if (oChar.getName().equals("Walter White")) {
                        iCharId = oChar.getChar_id();
                    }
                    System.out.println("Character name: " + oChar.getName() + newLine + "Portrayed: " + oChar.getPortrayed() + newLine + "------------------------------------------------------");
                });

        //Exercise 1
        System.out.println("Exercise 1: Get Walter White info");
        Assert.assertNotNull(iCharId);

        epResponse = oEndpointRespone.getCharacters(getCharactersEndPoint + iCharId);
        aCharacters = epResponse.as(Characters[].class);

        //Verify walter white birthday and then print it
        Arrays.stream(aCharacters). forEach(
                oChar -> {
                    Assert.assertEquals(oChar.getBirthday(), "09-07-1958");
                    System.out.println("Birthday: " + oChar.getBirthday());
                }
        );

    }




}
