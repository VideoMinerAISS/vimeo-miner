package aiss.miner.vimeo.controller;
import aiss.miner.vimeo.model.video.Channel;
import aiss.miner.vimeo.service.VideoMinerService;
import aiss.miner.vimeo.service.VimeoTranslatedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="channel", description = "Vimeo channel management API")
@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    VideoMinerService videoMinerService;
    @Autowired
    VimeoTranslatedService vimeoTranslatedService;

    @Operation(
            summary = "Retrieve channel",
            description="Get channel",
            tags = {"channel", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    @GetMapping("/{id}")
    public Channel findOne(@Parameter(description = "id of a vimeo channel") @PathVariable String id,
                           @Parameter(description = "maximum number of videos")
                           @RequestParam(value="maxVideos", defaultValue ="10") String maxVideos,
                           @Parameter(description = "maximum number of comments")
                           @RequestParam(value="maxComments", defaultValue ="10") String maxComments
                           ) {

        return vimeoTranslatedService.getVimeoChannels(id, Integer.parseInt(maxVideos), Integer.parseInt(maxComments));
    }
    @Operation(
            summary = "Post channel",
            description="Post channel",
            tags = {"channel", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Channel.class),
                    mediaType ="application/json" )}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())})
    })
    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Channel postOne(@Parameter(description = "id of a vimeo channel") @PathVariable String id,
                           @Parameter(description = "maximum number of videos")
                           @RequestParam(value="maxVideos", defaultValue ="10") String maxVideos,
                           @Parameter(description = "maximum number of comments")
                           @RequestParam(value="maxComments", defaultValue ="10") String maxComments
    ) {

        Channel channel = vimeoTranslatedService.getVimeoChannels(id,Integer.parseInt(maxVideos), Integer.parseInt(maxComments));
        videoMinerService.createChannel(channel);
        return channel;
    }
}
