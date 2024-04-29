package aiss.miner.vimeo.Repository;

import aiss.miner.vimeo.model.vimeo.VimeoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VimeoCommentRepository extends JpaRepository<VimeoComment, Long> {

}
