package com.Test.Hafidh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Test.Hafidh.Model.ImageModel;

@Repository
public interface ImagesRepository extends JpaRepository<ImageModel, Long > {

}
