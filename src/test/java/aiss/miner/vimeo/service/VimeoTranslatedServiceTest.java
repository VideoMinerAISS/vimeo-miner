package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.video.Channel;
import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VimeoTranslatedServiceTest {

    @Autowired
    VimeoTranslatedService vimeoTranslatedService;

    @ParameterizedTest
    @DisplayName("Get Vimeo Channel from id")
    @ValueSource(strings = {"762461"})
    void getVimeoChannels(String channelId) {

        Channel channel = vimeoTranslatedService.getVimeoChannels(channelId);
        assertNotEquals(channel,null, "Channels is null");
        System.out.println(channel);
    }
}