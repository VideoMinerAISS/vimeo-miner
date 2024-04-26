package aiss.miner.vimeo.model.vimeo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoChannel {

    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_time")
    private String createdTime;

    private List<VimeoVideo> videos;

    public VimeoChannel ()
    {
        videos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "VimeoChannel{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", createdTime=" + createdTime +
                ", video Count=" + videos.size() +
                ", first video=" + videos.get(0) + "\n"+
                ", second video=" + videos.get(1) + "\n"+
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<VimeoVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<VimeoVideo> videos) {
        this.videos = videos;
    }




}
