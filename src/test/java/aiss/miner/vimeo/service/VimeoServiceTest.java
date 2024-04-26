package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import aiss.miner.vimeo.model.vimeo.VimeoComment;
import aiss.miner.vimeo.model.vimeo.VimeoVideo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VimeoServiceTest {

    @Autowired
    VimeoService vimeoService;

    @ParameterizedTest
    @DisplayName("Get Vimeo Channel from id")
    @ValueSource(strings = {"762461"})
    void testGetVimeoChannel(String channelId) {

        VimeoChannel channel = vimeoService.getVimeoChannels(channelId);
        System.out.println(channel);
    }

    @ParameterizedTest
    @DisplayName("Get Vimeo Videos from Channel")
    @ValueSource(strings = {"447433"})
    void testGetVimeoVideos(String channelId) {

        List<VimeoVideo> videos = vimeoService.getVimeoVideos(channelId);
        System.out.println(videos);
    }

    @ParameterizedTest
    @DisplayName("Get Vimeo Comments from Video")
    @ValueSource(strings = {"411870028"})
    void testGetVimeoComments(String videoId) {

        List<VimeoComment> comments  =vimeoService.getVimeoComments(videoId);
        System.out.println(comments);
    }
}