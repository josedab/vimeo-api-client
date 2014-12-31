package org.technobitia.vimeo.extractors;

import org.json.JSONObject;
import org.technobitia.vimeo.model.Tag;

import com.google.common.base.Function;

public class TagExtractor implements Function<JSONObject, Tag>{

    public Tag apply(JSONObject arg0) {
        Tag tag = new Tag();
        return tag;
    }

}
