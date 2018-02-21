package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        //I've got the following codes from: https://www.codevoila.com/post/65/java-json-tutorial-and-example-json-java-orgjson#toc_5
        Sandwich sandwich = new Sandwich();

        JSONObject sandwichJsonObject = new JSONObject(json);

        JSONObject name =  sandwichJsonObject.getJSONObject("name");

        String mainName = name.getString("mainName");

        JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs"); //array

        String placeOfOrigin = sandwichJsonObject.getString("placeOfOrigin");

        String description = sandwichJsonObject.getString("description");

        String image = sandwichJsonObject.getString("image");

        JSONArray ingredients = sandwichJsonObject.getJSONArray("ingredients");


        //setters
        sandwich.setMainName(mainName);

        // https://stackoverflow.com/questions/15871309/convert-jsonarray-to-string-array/28010925
        List<String> alsoKnownList = new ArrayList<String>();
        for (int i = 0; i < alsoKnownAs.length(); i++){
            alsoKnownList.add(alsoKnownAs.getString(i));
        }
        sandwich.setAlsoKnownAs(alsoKnownList); //changed the parameter @ Sandwich -> setAlsoKnownAs -> List<String>

        sandwich.setPlaceOfOrigin(placeOfOrigin);

        sandwich.setDescription(description);

        sandwich.setImage(image);

        List<String> ingredientsList = new ArrayList<String>();
        for (int i = 0; i < ingredients.length(); i++){
            ingredientsList.add(ingredients.getString(i));
        }
        sandwich.setIngredients(ingredientsList);

        return sandwich;
    }
}
