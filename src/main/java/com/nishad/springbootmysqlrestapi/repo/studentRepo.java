package com.nishad.springbootmysqlrestapi.repo;

import com.nishad.springbootmysqlrestapi.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<student, Long> {
}
