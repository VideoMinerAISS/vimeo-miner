package aiss.miner.vimeo.controller;

import aiss.miner.vimeo.Repository.VimeoCaptionRepository;
import aiss.miner.vimeo.Repository.VimeoUserRepository;
import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import aiss.miner.vimeo.model.vimeo.VimeoUser;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class VimeoUserController {
    VimeoUserRepository vimeoUserRepository;

    // GET http://localhost:8080/api/commits/{id}
    @GetMapping("/commits/{id}")
    public VimeoUser findOne(@PathVariable(value="id") Long id) {
        Optional<VimeoUser> commit = vimeoUserRepository.findById(id);
        return commit.get();
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/projects/{projectId}/commits")
    @ResponseStatus(HttpStatus.CREATED)
    public VimeoUser createCommit(@RequestBody @Valid VimeoUser commit, @PathVariable("projectId") long projectId) {
        return vimeoUserRepository
                .save(new VimeoUser());
    }
}
