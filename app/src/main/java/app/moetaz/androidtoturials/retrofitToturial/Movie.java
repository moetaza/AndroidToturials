package app.moetaz.androidtoturials.retrofitToturial;

import com.google.gson.annotations.SerializedName;

public class Movie {

    private String name;

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
}
