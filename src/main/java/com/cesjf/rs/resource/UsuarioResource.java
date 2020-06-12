package com.cesjf.rs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesjf.rs.dto.ConsultaUsuarioDto;
import com.cesjf.rs.dto.LoginDto;
import com.cesjf.rs.dto.RetornoLoginDto;
import com.cesjf.rs.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository repo;
	
	@PostMapping("/login")
	public ResponseEntity<?> validaLogin(@RequestBody LoginDto body){
		
		try {
			RetornoLoginDto retornoDto = repo.retornoLogin(body.getLogin(), body.getSenha());
			
			if(retornoDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(retornoDto);
			}else {
				return ResponseEntity.status(HttpStatus.OK).body("Usuário ou senha inválidos!");
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/consulta/{id}")
	public ConsultaUsuarioDto consultaUsuario (@PathVariable Long id) {
		try {
			ConsultaUsuarioDto dto = new ConsultaUsuarioDto();
			
			dto = repo.consulta(id);
			
			return dto;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
