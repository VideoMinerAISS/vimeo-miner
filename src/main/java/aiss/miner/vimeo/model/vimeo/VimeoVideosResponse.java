package aiss.miner.vimeo.model.vimeo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoVideosResponse {

    @JsonProperty("data")
    private List<VimeoVideo> videos;

    public List<VimeoVideo> getVideos() {
        return new ArrayList<>(videos);
    }

    public void setVideos(List<VimeoVideo> videos) {
        this.videos = videos;
    }
}
