package aiss.miner.vimeo.controller;
import aiss.miner.vimeo.model.video.Channel;
import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import aiss.miner.vimeo.service.VideoMinerService;
import aiss.miner.vimeo.service.VimeoTranslatedService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class VimeoChannelChannel {
    VideoMinerService videoMinerService;
    VimeoTranslatedService vimeoTranslatedService;

    @GetMapping("/commits/{id}")
    public Channel findOne(@PathVariable(value="id") String id) {
        return vimeoTranslatedService.getVimeoChannels(id);
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/projects/{projectId}/commits")
    @ResponseStatus(HttpStatus.CREATED)
    public Channel postOne(@PathVariable(value="id") String id) {
        Channel channel = vimeoTranslatedService.getVimeoChannels(id);
        videoMinerService.createChannel(channel);
        return  channel;
    }
}
