package com.noriton.team9.repository;

import com.noriton.team9.domain.Designer;
import com.noriton.team9.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DesignerRepository extends JpaRepository<Designer, Long> {
    List<Designer> findByLoginId(String loginId);
}
