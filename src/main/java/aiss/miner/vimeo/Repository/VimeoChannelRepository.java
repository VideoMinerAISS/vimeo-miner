package aiss.miner.vimeo.Repository;

import aiss.miner.vimeo.model.vimeo.VimeoChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VimeoChannelRepository extends JpaRepository<VimeoChannel, Long> {
}
