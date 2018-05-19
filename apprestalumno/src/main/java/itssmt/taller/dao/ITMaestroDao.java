package itssmt.taller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import itssmt.taller.entity.TMaestro;

@Repository
public interface ITMaestroDao extends JpaRepository<TMaestro, Integer> {
	

}
