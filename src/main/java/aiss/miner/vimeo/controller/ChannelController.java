package aiss.miner.vimeo.controller;
import aiss.miner.vimeo.model.video.Channel;
import aiss.miner.vimeo.service.VideoMinerService;
import aiss.miner.vimeo.service.VimeoTranslatedService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    VideoMinerService videoMinerService;
    @Autowired
    VimeoTranslatedService vimeoTranslatedService;

    @GetMapping("/{id}")
    public Channel findOne(@PathVariable String id,
                           @RequestParam(value="maxVideos", defaultValue ="10") @Min(0) @Max(20) String maxVideos,
                           @RequestParam(value="maxComments", defaultValue ="10") @Min(0) @Max(20) String maxComments
                           ) {

        return vimeoTranslatedService.getVimeoChannels(id, Integer.parseInt(maxVideos), Integer.parseInt(maxComments));
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Channel postOne(@PathVariable String id,
                           @RequestParam(value="maxVideos", defaultValue ="10") @Min(0) @Max(20) String maxVideos,
                           @RequestParam(value="maxComments", defaultValue ="10") @Min(0) @Max(20) String maxComments) {

        Channel channel = vimeoTranslatedService.getVimeoChannels(id,Integer.parseInt(maxVideos), Integer.parseInt(maxComments));
        videoMinerService.createChannel(channel);
        return channel;
    }
}
