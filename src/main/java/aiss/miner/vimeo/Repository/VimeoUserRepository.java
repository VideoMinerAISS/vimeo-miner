package aiss.miner.vimeo.Repository;

import aiss.miner.vimeo.model.vimeo.VimeoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VimeoUserRepository extends JpaRepository<VimeoUser, Long> {
}
