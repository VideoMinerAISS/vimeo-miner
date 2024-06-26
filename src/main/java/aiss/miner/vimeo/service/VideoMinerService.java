package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.video.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoMinerService {
    @Autowired
    RestTemplate restTemplate;

    String baseURI = "http://localhost:8080";
    public void createChannel(Channel channel)
    {
        HttpEntity<Channel> body = new HttpEntity<>(channel, null);
        String uri = baseURI + "/videominer/channels";

        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.POST, body, Channel.class);

        System.out.println(response.getBody());
    }
}
