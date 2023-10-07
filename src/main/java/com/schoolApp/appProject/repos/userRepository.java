package com.schoolApp.appProject.repos;

import com.schoolApp.appProject.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Long>{
}
