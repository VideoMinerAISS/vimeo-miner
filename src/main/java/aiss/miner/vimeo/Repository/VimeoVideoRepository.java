package aiss.miner.vimeo.Repository;

import aiss.miner.vimeo.model.vimeo.VimeoVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VimeoVideoRepository extends JpaRepository<VimeoVideo, Long> {
}
