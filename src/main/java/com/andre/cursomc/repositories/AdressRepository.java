package com.andre.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.cursomc.domain.Adress;;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer>
{
	

}
