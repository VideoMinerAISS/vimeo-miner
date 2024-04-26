package aiss.miner.vimeo.model.vimeo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoCommentsResponse {




    @JsonProperty("data")
    List<VimeoComment> commentList;

    public List<VimeoComment> getCommentList() {
        return new ArrayList<>(commentList);
    }

}
