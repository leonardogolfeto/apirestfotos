package com.info2b.api.apirest.repository;


import com.info2b.api.apirest.models.Imagens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagensRepository extends JpaRepository<Imagens, Long> {

    Imagens findById(long id);


}