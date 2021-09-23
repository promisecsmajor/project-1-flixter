package com.codepath.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    private static String backdropImageSize;
    private static String posterImageSize;
    String basePath = "http://image.tmdb.org/t/p/";
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;



    // Empty constructor needed for Parceler library
    public Movie (){}

    public Movie(JSONObject jsonObject, String backdropImageSize, String posterImageSize) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        Movie.posterImageSize = posterImageSize;
        Movie.backdropImageSize = backdropImageSize;
        rating = jsonObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray (JSONArray movieJsonArray, String backdropImageSize, String posterImageSize) throws JSONException {
        List<Movie> movies  = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i), backdropImageSize, posterImageSize));
        }
        return movies;
    }

    public String getPosterPath() {

        return basePath + posterImageSize + posterPath;
    }

    public String getBackdropPath(){
        return basePath + backdropImageSize + backdropPath;
    }
    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() { return rating; }
}
