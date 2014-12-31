package org.technobitia.vimeo.extractors;

import org.json.JSONObject;
import org.technobitia.vimeo.model.User;

import com.google.common.base.Function;

public class UserExtractor implements Function<JSONObject, User>{

    public User apply(JSONObject arg0) {
        User user = new User();
        return user;
    }

}
