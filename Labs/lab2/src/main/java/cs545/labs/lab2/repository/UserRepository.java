package cs545.labs.lab2.repository;

import cs545.labs.lab2.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

//    @Query(value = "select u from Users u join u.posts ps Group by u.id, u.name having count(u)>:postCount ")
    @Query(value = "select u from Users u where size(u.posts)>:postCount ")
    public List<Users> findByPostsSizeGreaterThan(int postCount);
}
