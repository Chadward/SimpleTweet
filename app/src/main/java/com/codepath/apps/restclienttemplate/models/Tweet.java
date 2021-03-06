package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {

    public String body;
    public long uid;
    public String createdAt;
    public User user;
    public String ts;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.ts = TimeFormatter.getTimeDifference(TimeFormatter.getTimeStamp(tweet.createdAt));

        return tweet;
    }

    //public String getFormattedTimestamp(String thing) {
    //    return TimeFormatter.getTimeDifference(TimeFormatter.getTimeStamp(thing));
    //}
}
