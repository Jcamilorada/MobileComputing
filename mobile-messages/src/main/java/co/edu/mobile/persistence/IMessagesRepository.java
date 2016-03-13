package co.edu.mobile.persistence;

import co.edu.mobile.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMessagesRepository extends JpaRepository<Message, Long>
{
    @Query("select u from Message u where u.from = ?1 and u.to = ?2")
    List<Message> findByUsers(long fromUser, long toUser);
}
