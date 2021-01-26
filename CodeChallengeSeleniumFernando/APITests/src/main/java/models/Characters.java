package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Characters {
    @JsonProperty("char_id")
    private int char_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("occupation")
    private List<String> occupation;

    @JsonProperty("img")
    private String img;

    @JsonProperty("status")
    private String status;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("appearance")
    private List<Integer> appearance;

    @JsonProperty("portrayed")
    private String portrayed;

    @JsonProperty("category")
    private String category;

    @JsonProperty("better_call_saul_appearance")
    private List<String> better_call_saul_appearance;

    @Override
    public String toString() {
        return "Characters{" +
                "char_id=" + char_id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", occupation=" + occupation +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", nickname='" + nickname + '\'' +
                ", appearance=" + appearance +
                ", portrayed='" + portrayed + '\'' +
                ", category='" + category + '\'' +
                ", better_call_saul_appearance=" + better_call_saul_appearance +
                '}';
    }

    public int getChar_id() {
        return char_id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public String getImg() {
        return img;
    }

    public String getStatus() {
        return status;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Integer> getAppearance() {
        return appearance;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }
}
