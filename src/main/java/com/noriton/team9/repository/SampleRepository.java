package com.noriton.team9.repository;

import com.noriton.team9.domain.Sample;
import com.noriton.team9.domain.SampleLike;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface SampleRepository extends JpaRepository<Sample, Long> {


}
