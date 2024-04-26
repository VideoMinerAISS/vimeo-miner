package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.vimeo.VimeoChannel;
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
    @DisplayName("Get Vimeo Channels")
    @ValueSource(strings = {"447433"})
    void testGetVimeoChannel(String id) {

        VimeoChannel channel = vimeoService.getVimeoChannels(id);
        System.out.println(channel);
    }

    @ParameterizedTest
    @DisplayName("Get Vimeo Videos from Channel")
    @ValueSource(strings = {"447433"})
    void testGetVimeoVideos(String id) {

        List<VimeoVideo> videos = vimeoService.getVimeoVideos(id);
        System.out.println(videos);
    }
}