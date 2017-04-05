package com.real.project.repository;


import com.real.project.entity.Transfers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfersRepository extends JpaRepository<Transfers,Long> {

}
