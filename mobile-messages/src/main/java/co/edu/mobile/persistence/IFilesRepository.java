package co.edu.mobile.persistence;

import co.edu.mobile.domain.SharedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFilesRepository extends JpaRepository<SharedFile, Long>
{
    @Query("select u from SharedFile u where (u.from = ?1 and u.to = ?2) or (u.from = ?2 and u.to = ?1) order by u.date")
    List<SharedFile> findByUsers(long fromUserId, long toUserId);
}
