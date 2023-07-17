package com.pooweb.geekcollection.repositories;

import com.pooweb.geekcollection.models.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepository extends JpaRepository<Poster, Long>{
}
