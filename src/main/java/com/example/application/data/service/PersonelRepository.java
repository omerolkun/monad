package com.example.application.data.service;

import com.example.application.data.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonelRepository extends JpaRepository<Personel, Integer> {

    @Query("select c from Personel c " +
            "where lower(c.Ad) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.Soyad) like lower(concat('%', :searchTerm, '%'))")
    List<Personel> search(@Param("searchTerm") String searchTerm);

}
