package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.video.Channel;
import aiss.miner.vimeo.model.video.Video;
import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VimeoTranslatedService {

    //This is a Wrapper for VimeoService that returns data using the VideoMiner Models
    @Autowired
    VimeoService vimeoService;
    public Channel getVimeoChannels(String channelId)
    {
        return getVimeoChannels(channelId, 10 ,10);
    }
    public Channel getVimeoChannels(String channelId, Integer maxVideos, Integer maxComments)
    {
        return new Channel(vimeoService.getVimeoChannels(channelId,maxVideos,maxComments));
    }
}
