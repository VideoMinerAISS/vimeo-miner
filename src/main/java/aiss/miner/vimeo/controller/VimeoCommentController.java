package aiss.miner.vimeo.controller;

import aiss.miner.vimeo.Repository.VimeoCaptionRepository;
import aiss.miner.vimeo.Repository.VimeoCommentRepository;
import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import aiss.miner.vimeo.model.vimeo.VimeoComment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class VimeoCommentController {
    VimeoCommentRepository vimeoCommentRepository;

    // GET http://localhost:8080/api/commits/{id}
    @GetMapping("/commits/{id}")
    public VimeoComment findOne(@PathVariable(value="id") Long id) {
        Optional<VimeoComment> commit = vimeoCommentRepository.findById(id);
        return commit.get();
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/projects/{projectId}/commits")
    @ResponseStatus(HttpStatus.CREATED)
    public VimeoComment createCommit(@RequestBody @Valid VimeoComment commit, @PathVariable("projectId") long projectId) {
        return vimeoCommentRepository
                .save(new VimeoComment());
    }
}
