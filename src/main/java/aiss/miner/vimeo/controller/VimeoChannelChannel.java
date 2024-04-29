package aiss.miner.vimeo.controller;

import aiss.miner.vimeo.Repository.VimeoCaptionRepository;
import aiss.miner.vimeo.Repository.VimeoChannelRepository;
import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class VimeoChannelChannel {
    VimeoChannelRepository vimeoChannelRepository;

    @GetMapping("/commits/{id}")
    public VimeoChannel findOne(@PathVariable(value="id") Long id) {
        Optional<VimeoChannel> commit = vimeoChannelRepository.findById(id);
        return commit.get();
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/projects/{projectId}/commits")
    @ResponseStatus(HttpStatus.CREATED)
    public VimeoChannel createCommit(@RequestBody @Valid VimeoChannel commit, @PathVariable("projectId") long projectId) {
        return vimeoChannelRepository
                .save(new VimeoChannel());
    }
}
