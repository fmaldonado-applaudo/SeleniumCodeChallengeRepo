package restasssured;


import endpoints.EndPoints;
import io.restassured.response.Response;
import restassuredmodel.Characters;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class RestAssuredChallenge {
    private int iCharId;
    private final String newLine = System.getProperty("line.separator");
    EndPoints oEndpointRespone = new EndPoints();

    @Test(groups = "allChars")
    public void getAllCharacters() {
        System.out.println("Exercise 2: Get all characters");

        Response epResponse = oEndpointRespone.doGetRequest("https://www.breakingbadapi.com/api/characters");
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

        epResponse = oEndpointRespone.doGetRequest("https://www.breakingbadapi.com/api/characters/" + iCharId);
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
