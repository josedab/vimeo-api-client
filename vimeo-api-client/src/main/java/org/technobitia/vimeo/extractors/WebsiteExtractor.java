package org.technobitia.vimeo.extractors;

import org.json.JSONObject;
import org.technobitia.vimeo.model.Website;

import com.google.common.base.Function;

public class WebsiteExtractor implements Function<JSONObject, Website> {

    public Website apply(JSONObject jsonData) {
        Website website = new Website();
        website.setLink(jsonData.getString("link"));
        website.setName(jsonData.getString("name"));
        website.setDescription(jsonData.getString("description"));
        return website;
    }

}
