package space.yjeong.domain.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByRoomId(Long roomId);
    Image findFirstByRoomId(Long roomId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Image i where i.room.id = :roomId")
    void deleteAllByRoomId(@Param("roomId") Long roomId);
}
