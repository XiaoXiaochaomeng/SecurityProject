package com.jwt.JWT.Project.repository;

import com.jwt.JWT.Project.entity.Account;
import com.jwt.JWT.Project.entity.Authority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

    @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
    List<Authority> authoritiesOf(List<Account> accounts);

    @Query(value = "SELECT f.* FROM Authorities f INNER JOIN Accounts a ON f.Username = a.Username WHERE a.username = ?1", countQuery = "SELECT COUNT(*) FROM Feedbacks f INNER JOIN Accounts a ON f.Username = a.Username WHERE a.username = ?1", nativeQuery = true)
    Page<Authority> findByAccountUsername(String username, Pageable pageable);

    long countByAccountUsername(String username);

}
