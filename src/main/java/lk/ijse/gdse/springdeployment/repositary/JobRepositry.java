package lk.ijse.gdse.springdeployment.repositary;

import lk.ijse.gdse.springdeployment.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobRepositry extends JpaRepository<Job,  Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Job  SET status='DEACTIVATE' where id=?",nativeQuery = true)
    void updateStauts(String id);
    List<Job> findJobByJobTitleContainingIgnoreCase(String keyword);

    @Query(value = "SELECT * FROM job LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Job> findJobsPaginated(@Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM job", nativeQuery = true)
    int getTotalJobCount();

}
