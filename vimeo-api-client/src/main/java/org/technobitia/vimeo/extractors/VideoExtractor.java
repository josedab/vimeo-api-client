package org.technobitia.vimeo.extractors;

import org.json.JSONObject;
import org.technobitia.vimeo.model.Video;

import com.google.common.base.Function;

public class VideoExtractor implements Function<JSONObject, Video> {

    public Video apply(JSONObject arg0) {
        Video video = new Video();
        return video;
    }

}
