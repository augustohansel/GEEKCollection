package com.pooweb.geekcollection.repositories;

import com.pooweb.geekcollection.models.ActionFigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionFigureRepository extends JpaRepository<ActionFigure, Long> {
}
