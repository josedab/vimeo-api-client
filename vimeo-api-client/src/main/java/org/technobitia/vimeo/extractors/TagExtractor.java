package org.technobitia.vimeo.extractors;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.technobitia.vimeo.model.Tag;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class TagExtractor implements Function<JSONObject, Tag>{

    public Tag apply(JSONObject jsonData) {
        Tag tag = new Tag();
        tag.setTag(jsonData.getString("tag"));
        tag.setName(jsonData.getString("name"));
        tag.setUri(jsonData.getString("uri"));
        tag.setCanonical(jsonData.getString("canonical"));
        return tag;
    }
    
    public List<Tag> apply(JSONArray jsonArray) {
        List<Tag> tags = Lists.newArrayList();
        Tag tag = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject tagsJsonData = jsonArray.getJSONObject(i);
            tag = apply(tagsJsonData);
            tags.add(tag);
        }
        return tags;
    }

}
