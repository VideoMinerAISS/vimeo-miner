package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.vimeo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import org.springframework.http.HttpHeaders;

import java.util.List;

@Service
public class VimeoService {


    @Autowired
    RestTemplate restTemplate;


    final String TOKEN = "Bearer d7d8bf450c46a48bd20293ccb0e1cc5f";

    public VimeoChannel getVimeoChannels(String channelId)
    {
        return getVimeoChannels(channelId, 10 ,10);
    }
    public VimeoChannel getVimeoChannels(String channelId, Integer maxVideos, Integer maxComments)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", TOKEN);

        HttpEntity<VimeoChannel> httpRequest = new HttpEntity<>(null, httpHeaders);
        String uri = "https://api.vimeo.com/channels/" + channelId;
        ResponseEntity<VimeoChannel> httpResponse = restTemplate.exchange(uri, HttpMethod.GET, httpRequest, VimeoChannel.class);


        VimeoChannel channel = null;
        channel = httpResponse.getBody();
        channel.setId(channelId);

        channel.setVideos(getVimeoVideos(channelId));

        return channel;
    }

    public List<VimeoVideo> getVimeoVideos(String channelId)
    {
       return getVimeoVideos(channelId, 10);
    }

    public List<VimeoVideo> getVimeoVideos(String channelId, Integer maxVideos)
    {
        return getVimeoVideos(channelId, maxVideos,10);
    }

    public List<VimeoVideo> getVimeoVideos(String channelId, Integer maxVideos, Integer maxComments ){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", TOKEN);

        HttpEntity<VimeoChannel> httpRequest = new HttpEntity<>(null, httpHeaders);
        String uri = "https://api.vimeo.com/channels/" + channelId + "/videos?per_page="+ maxVideos.toString();
        ResponseEntity<VimeoVideosResponse> httpResponse = restTemplate.exchange(uri, HttpMethod.GET, httpRequest, VimeoVideosResponse.class);
        VimeoVideosResponse vimeoVideosResponse = null;
        vimeoVideosResponse = httpResponse.getBody();

        List<VimeoVideo> videos = vimeoVideosResponse.getVideos();
        for (var video: videos){
            video.setCommentList(getVimeoComments(video.getId(), maxComments));
        }

        return videos;
    }

    public List<VimeoComment> getVimeoComments(String videoId)
    {
        return  getVimeoComments(videoId, 10);
    }
    public List<VimeoComment> getVimeoComments(String videoId, Integer maxComments){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", TOKEN);

        HttpEntity<VimeoChannel> httpRequest = new HttpEntity<>(null, httpHeaders);
        String uri = "https://api.vimeo.com/videos/" + videoId + "/comments?per_page=" + maxComments.toString();
        ResponseEntity<VimeoCommentsResponse> httpResponse = restTemplate.exchange(uri, HttpMethod.GET, httpRequest, VimeoCommentsResponse.class);

        VimeoCommentsResponse vimeoCommentsResponse = null;
        vimeoCommentsResponse = httpResponse.getBody();

        return vimeoCommentsResponse.getCommentList();
    }
}
