package aiss.miner.vimeo.model.vimeo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class VimeoVideo {
    @JsonProperty("uri")
    private String uri;

    private String id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    public VimeoVideo(){
        id = null;
    }

    @Override
    public String toString() {
        return "VimeoVideo{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releasedTime='" + releasedTime + '\'' +
                ", captionList=" + captionList +
                ", commentList=" + commentList +
                '}';
    }




    //Id's Getters and Setters are different because you don´t get the id from the JSON but the uri of the video

    public String getId() {
        if(id == null)
        {
            id = uri.replace("/videos/", "");
        }

        return id;
    }

    public void setId(String id) {
        this.id = id;
        this.uri = "/videos/"  + id;
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

    public String getReleasedTime() {
        return releasedTime;
    }

    public void setReleasedTime(String releasedTime) {
        this.releasedTime = releasedTime;
    }

    public List<VimeoCaption> getCaptionList() {
        return captionList;
    }

    public void setCaptionList(List<VimeoCaption> captionList) {
        this.captionList = captionList;
    }

    public List<VimeoComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<VimeoComment> commentList) {
        this.commentList = commentList;
    }

    @JsonProperty("created_time")
    private String releasedTime;

    List<VimeoCaption> captionList;
    List<VimeoComment> commentList;
}
