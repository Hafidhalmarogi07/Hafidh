package com.Test.Hafidh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Test.Hafidh.Model.HafidhModel;

@Repository
public interface HafidhRepository extends JpaRepository<HafidhModel, Long> {

}
