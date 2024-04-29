package aiss.miner.vimeo.controller;

import aiss.miner.vimeo.Repository.VimeoUserRepository;
import aiss.miner.vimeo.Repository.VimeoVideoRepository;
import aiss.miner.vimeo.model.vimeo.VimeoUser;
import aiss.miner.vimeo.model.vimeo.VimeoVideo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class VimeoVideoController {
    VimeoVideoRepository vimeoVideoRepository;

    // GET http://localhost:8080/api/commits/{id}
    @GetMapping("/commits/{id}")
    public VimeoVideo findOne(@PathVariable(value="id") Long id) {
        Optional<VimeoVideo> commit = vimeoVideoRepository.findById(id);
        return commit.get();
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/projects/{projectId}/commits")
    @ResponseStatus(HttpStatus.CREATED)
    public VimeoVideo createCommit(@RequestBody @Valid VimeoVideo commit, @PathVariable("projectId") long projectId) {
        return vimeoVideoRepository
                .save(new VimeoVideo());
    }
}
