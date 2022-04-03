package com.example.postcode.repository;

import com.example.postcode.entity.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostcodeRepository extends JpaRepository<Postcode,Long> {
    List<Postcode> findAllByCodeBetween(Long fromRange, Long toRange);
}
