package co.edu.mobile.persistence;


import co.edu.mobile.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersReporsitory extends JpaRepository<User, Long>
{
}
