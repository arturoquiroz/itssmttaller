package itssmt.taller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itssmt.taller.entity.TAlumno;

@Repository
public interface ITAlumnoDao  extends JpaRepository<TAlumno, Integer>{

	
	
}
