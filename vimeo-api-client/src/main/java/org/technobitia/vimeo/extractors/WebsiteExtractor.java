package org.technobitia.vimeo.extractors;

import org.json.JSONObject;
import org.technobitia.vimeo.model.Website;

import com.google.common.base.Function;

public class WebsiteExtractor implements Function<JSONObject, Website> {

    public Website apply(JSONObject arg0) {
        Website website = new Website();
        return website;
    }

}
