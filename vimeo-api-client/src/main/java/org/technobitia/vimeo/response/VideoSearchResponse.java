package org.technobitia.vimeo.response;

import java.util.List;

import org.technobitia.vimeo.model.Video;

import com.google.common.collect.Lists;

public class VideoSearchResponse {
    private int totalResults;
    private int resultsPerPage;
    private int pageNumber;
    private List<Video> videos;
    
    public VideoSearchResponse(){
        videos = Lists.newArrayList();
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    
    public void addVideo(Video video){
        this.videos.add(video);
    }
}
