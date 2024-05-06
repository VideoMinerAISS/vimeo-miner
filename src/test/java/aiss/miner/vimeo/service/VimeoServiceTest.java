package aiss.miner.vimeo.service;

import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import aiss.miner.vimeo.model.vimeo.VimeoComment;
import aiss.miner.vimeo.model.vimeo.VimeoVideo;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VimeoServiceTest {

    @Autowired
    VimeoService vimeoService;

    @ParameterizedTest
    @DisplayName("Get Vimeo Channel from id")
    @ValueSource(strings = {"762461"})
    void getVimeoChannel(String channelId) {

        VimeoChannel channel = vimeoService.getVimeoChannels(channelId);
        assertNotEquals(channel,null, "Channels is null");
        System.out.println(channel);
    }

    @ParameterizedTest()
    @DisplayName("Vimeo Channel not Found")
    @ValueSource(strings = {"1"})
    void getNonExistingVimeoChannel(String channelId) {
        Exception exception = assertThrows(HttpClientErrorException.class, () -> {
            vimeoService.getVimeoChannels(channelId);
        });

        String expectedMessage = "404 Not Found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));



    }

//    @ParameterizedTest
//    @DisplayName("Vimeo Channel forbidden")
//    @ValueSource(strings = {"1"})
//    void getForbiddenVimeoChannel(String channelId) {
//        Exception exception = assertThrows(HttpClientErrorException.class, () -> {
//        vimeoService.getVimeoChannels(channelId);
//        });
//        /
//        String expectedMessage = "403 Forbidden";
//        String actualMessage = exception.getMessage();
//
//        assertTrue(actualMessage.contains(expectedMessage));
//    }


    @ParameterizedTest
    @DisplayName("Vimeo Channel too many requests")
    @ValueSource(strings = {"762461"})
    void getInfiniteVimeoChannels(String channelId) {

        //This test only works when using the free access of the API
        vimeoService.getVimeoChannels(channelId);
        Exception exception = assertThrows(HttpClientErrorException.class, () -> {
            vimeoService.getVimeoChannels(channelId);
        });

        String expectedMessage = "429 Too Many Requests";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


    @ParameterizedTest
    @DisplayName("Get Vimeo Videos from Channel")
    @ValueSource(strings = {"447433"})
    void getVimeoVideos(String channelId) {

        List<VimeoVideo> videos = vimeoService.getVimeoVideos(channelId);
        assertFalse(videos.isEmpty(), "Videos are empty");
        System.out.println(videos);
    }

    @ParameterizedTest
    @DisplayName("Get Vimeo Comments from Video")
    @ValueSource(strings = {"411870028"})
    void getVimeoComments(String videoId) {

        List<VimeoComment> comments  = vimeoService.getVimeoComments(videoId);
        assertFalse(comments.isEmpty(), "Comments are empty");
        System.out.println(comments);
    }

    @ParameterizedTest
    @DisplayName("Get Vimeo Captions from Video")
    @ValueSource(strings = {"241543888"})
    void getVimeoCaptions(String videoId) {
        List<VimeoCaption> captions  = vimeoService.getVimeoCaptions(videoId);
        assertFalse(captions.isEmpty(), "Captions are empty");
        System.out.println(captions);
    }
}