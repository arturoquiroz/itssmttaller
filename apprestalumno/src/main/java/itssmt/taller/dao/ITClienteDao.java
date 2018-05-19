package itssmt.taller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itssmt.taller.entity.TCliente;

@Repository
public interface ITClienteDao extends JpaRepository<TCliente, Integer>{

}
