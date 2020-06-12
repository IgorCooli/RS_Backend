package com.cesjf.rs.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cesjf.rs.dto.ConsultaUsuarioDto;
import com.cesjf.rs.dto.RetornoLoginDto;
import com.cesjf.rs.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select new com.cesjf.rs.dto.RetornoLoginDto"
			+ "(u.id,u.nome,u.sobrenome) "
			+ "from Usuario u "
			+ "where u.login = :login "
			+ "and u.senha = :senha"
		)
	RetornoLoginDto retornoLogin(String login, String senha);
	
	@Query("select new com.cesjf.rs.dto.ConsultaUsuarioDto"
			+ "(u.id, u.nome, u.sobrenome, u.endereco, u.nascimento, u.genero)"
			+ "from Usuario u"
			+ " where u.id = :id"
		)
	ConsultaUsuarioDto consulta(Long id);

}
