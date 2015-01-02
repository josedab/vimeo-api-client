package org.technobitia.vimeo.extractors;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.technobitia.vimeo.model.User;
import org.technobitia.vimeo.model.Video;

import com.google.common.base.Function;

public class VideoExtractor implements Function<JSONObject, Video> {

    private UserExtractor userExtractor;
    private TagExtractor tagExtractor;
    
    public Video apply(JSONObject jsonData) {
        Video video = new Video();
        
        video.setName(jsonData.getString("name"));
        video.setDescription(jsonData.getString("description"));
        
        String createdTimeDate = jsonData.getString("created_time");
        video.setCreatedTime(new Date(createdTimeDate));
        
        String modifiedTimeDate = jsonData.getString("modified_time");
        video.setModifiedTime(new Date(modifiedTimeDate));
        
        JSONObject userJsonData = jsonData.getJSONObject("user");
        User user = userExtractor.apply(userJsonData);
        video.setUser(user);
        
        JSONArray tagsJsonArray = jsonData.getJSONArray("tags");
        video.setTags(tagExtractor.apply(tagsJsonArray));
        
        video.setStatus(jsonData.getString("status"));
        video.setLink(jsonData.getString("link"));
        video.setUri(jsonData.getString("uri"));
        video.setDuration(jsonData.getInt("duration"));
        video.setWidth(jsonData.getInt("widht"));
        video.setHeight(jsonData.getInt("height"));
        video.setContentRating(jsonData.getJSONArray("contentRating").join(","));
        
        JSONObject metadataJson = jsonData.getJSONObject("metadata");
        if(metadataJson!=null){
            JSONObject connections = metadataJson.getJSONObject("connections");
            video.setCommentCount(getConnectionMetadataFromJson(connections, "comments"));
            video.setLikeCount(getConnectionMetadataFromJson(connections, "likes"));
        }
        
        JSONObject statsJson = jsonData.getJSONObject("stats");
        if(statsJson != null){
            int viewCount = statsJson.getInt("plays");
            video.setViewCount(viewCount);
        }
        
        return video;
    }
    
    private int getConnectionMetadataFromJson(JSONObject connectionsJsonData, String metadataKey) {
        int result = -1;
        if (connectionsJsonData != null) {
            JSONObject metadataJsonData = connectionsJsonData.getJSONObject(metadataKey);
            if (metadataJsonData != null) {
                result = metadataJsonData.getInt("total");
            }
        }
        return result;
    }

}
