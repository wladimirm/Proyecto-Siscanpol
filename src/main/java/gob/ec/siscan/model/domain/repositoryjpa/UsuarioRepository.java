package gob.ec.siscan.model.domain.repositoryjpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import gob.ec.siscan.domain.model.Usuario;

/**
 * 
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, CrudRepository<Usuario, Long>{
    @Query("select u from Usuario u left join fetch u.roles r where u.cuentaUsuario=:username")
    public Optional<Usuario> findByUsername(@Param("username") String username);
    
    @Query("select u from Usuario u left join fetch u.roles r where u.idUsuario=:userId")
    public Optional<Usuario> findByUserId(@Param("userId") Long userId);
}
