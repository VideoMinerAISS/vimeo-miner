package aiss.miner.vimeo.model.vimeo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VimeoCaptionResponse {




    @JsonProperty("data")
    List<VimeoCaption> captionList;
    public List<VimeoCaption> getCaptionList() {
        return captionList;
    }


}
