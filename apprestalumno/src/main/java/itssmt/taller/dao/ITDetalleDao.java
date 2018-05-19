package itssmt.taller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itssmt.taller.entity.TDetalle;

@Repository
public interface ITDetalleDao extends JpaRepository<TDetalle, Integer> {

}
