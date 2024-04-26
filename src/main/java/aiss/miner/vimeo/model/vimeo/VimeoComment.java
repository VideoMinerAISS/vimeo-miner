package aiss.miner.vimeo.model.vimeo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoComment {

    @JsonProperty("uri")
    private String uri;
    private  String id;
    @JsonProperty("text")
    private String text;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("user")
    private VimeoUser user;



    public  VimeoComment(){
        id = null;
    }
    public String getId() {
        if (id == null){
            id = uri.split("/comments/")[1];
        }

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public VimeoUser getUser() {
        return user;
    }

    public void setUser(VimeoUser user) {
        this.user = user;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "VimeoComment{" +
                "id='" + getId() + '\'' +
                ", text='" + text + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", user=" + user +
                '}';
    }
}
