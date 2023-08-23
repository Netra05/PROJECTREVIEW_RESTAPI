package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Registeration_table;

public interface RegisterRepo extends JpaRepository<Registeration_table, Integer>
{

}
