package itssmt.taller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itssmt.taller.entity.TPedido;

@Repository
public interface ITPedidoDao extends JpaRepository<TPedido, Integer>{


}
