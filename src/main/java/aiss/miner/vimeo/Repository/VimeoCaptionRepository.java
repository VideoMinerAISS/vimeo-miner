package aiss.miner.vimeo.Repository;

import aiss.miner.vimeo.model.vimeo.VimeoCaption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VimeoCaptionRepository extends JpaRepository<VimeoCaption, Long> {
}
