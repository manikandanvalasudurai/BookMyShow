package com.mani.example.bookmyshowjun25.repositories;
import com.mani.example.bookmyshowjun25.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long userId);
}
