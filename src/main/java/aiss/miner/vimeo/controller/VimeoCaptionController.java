package aiss.miner.vimeo.controller;

import aiss.miner.vimeo.Repository.VimeoCaptionRepository;
import aiss.miner.vimeo.Repository.VimeoCommentRepository;
import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class VimeoCaptionController {
    VimeoCaptionRepository vimeoCaptionRepository;

    // GET http://localhost:8080/api/commits/{id}
    @GetMapping("/commits/{id}")
    public VimeoCaption findOne(@PathVariable(value="id") Long id) {
        Optional<VimeoCaption> commit = vimeoCaptionRepository.findById(id);
        return commit.get();
    }

    // POST http://localhost:8080/api/projects/{projectId}/commits
    @PostMapping("/projects/{projectId}/commits")
    @ResponseStatus(HttpStatus.CREATED)
    public VimeoCaption createCommit(@RequestBody @Valid VimeoCaption commit, @PathVariable("projectId") long projectId) {
        return vimeoCaptionRepository
                .save(new VimeoCaption());
    }
}

