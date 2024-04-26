package aiss.miner.vimeo.model.vimeo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class VimeoUser {

    @JsonProperty("uri")
    private String uri;

    private String id;
    @JsonProperty("name")
    private String name;


    @JsonProperty("link")
    private String userLink;

    @JsonProperty("pictures")
    private VimeoPicture picture;

    public VimeoUser()
    {
        id= null;
    }
    public String getId() {
        if (id == null)
        {
            id = uri.replace("/users/" , "");
        }

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictureLink()
    {
        return picture.getBaseLink();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

    @Override
    public String toString() {
        return "VimeoUser{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", userLink='" + userLink + '\'' +
                ", pictureLink='" + getPictureLink() + '\'' +
                '}';
    }
}
