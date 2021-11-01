package com.nishad.springbootmysqlrestapi.repo;

import com.nishad.springbootmysqlrestapi.model.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepo extends JpaRepository<course, Long> {
}
