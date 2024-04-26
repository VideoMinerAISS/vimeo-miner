package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import aiss.miner.vimeo.model.vimeo.VimeoVideo;
import aiss.miner.vimeo.model.vimeo.VimeoVideosResponse;
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

    public VimeoChannel getVimeoChannels(String id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer d7d8bf450c46a48bd20293ccb0e1cc5f");

        HttpEntity<VimeoChannel> httpRequest = new HttpEntity<>(null, httpHeaders);
        String uri = "https://api.vimeo.com/channels/" + id;
        ResponseEntity<VimeoChannel> httpResponse = restTemplate.exchange(uri, HttpMethod.GET, httpRequest, VimeoChannel.class);



        VimeoChannel channel = null;
        channel = httpResponse.getBody();
        channel.setId(id);

        channel.setVideos(getVimeoVideos(id));

        return channel;
    }

    public List<VimeoVideo> getVimeoVideos(String id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer d7d8bf450c46a48bd20293ccb0e1cc5f");

        HttpEntity<VimeoChannel> httpRequest = new HttpEntity<>(null, httpHeaders);
        String uri = "https://api.vimeo.com/channels/" + id + "/videos";
        ResponseEntity<VimeoVideosResponse> httpResponse = restTemplate.exchange(uri, HttpMethod.GET, httpRequest, VimeoVideosResponse.class);

        VimeoVideosResponse vimeoVideosResponse = null;
        vimeoVideosResponse = httpResponse.getBody();

        return vimeoVideosResponse.getVideos();
    }
}
