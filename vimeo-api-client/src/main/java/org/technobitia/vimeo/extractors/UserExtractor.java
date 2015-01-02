package org.technobitia.vimeo.extractors;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.technobitia.vimeo.model.User;
import org.technobitia.vimeo.model.Website;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class UserExtractor implements Function<JSONObject, User> {

    private WebsiteExtractor websiteExtractor;

    public User apply(JSONObject jsonData) {
        User user = new User();
        user.setBio(jsonData.getString("bio"));

        user.setLocation(jsonData.getString("location"));
        user.setLink(jsonData.getString("link"));
        user.setName(jsonData.getString("name"));
        
        JSONObject picturesJson = jsonData.getJSONObject("pictures");
        if(picturesJson!=null){
            String pictureUri = picturesJson.getString("uri");
            user.setPictureUrl(pictureUri);
        }

        JSONArray websitesArray = jsonData.getJSONArray("websites");
        List<Website> websites = extractWebsites(websitesArray);
        user.setWebsites(websites);

        return user;
    }

    private List<Website> extractWebsites(JSONArray websitesArray) {
        List<Website> websites = Lists.newArrayList();
        Website website = null;
        for (int i = 0; i < websitesArray.length(); i++) {
            JSONObject websiteJsonData = websitesArray.getJSONObject(i);
            website = websiteExtractor.apply(websiteJsonData);
            websites.add(website);
        }
        return websites;
    }

}
