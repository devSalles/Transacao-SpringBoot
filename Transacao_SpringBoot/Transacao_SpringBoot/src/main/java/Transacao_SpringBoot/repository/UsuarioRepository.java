package Transacao_SpringBoot.repository;

import Transacao_SpringBoot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    //Procurar por CPF
    Usuario findByCpf(String CPF);

    //Procurar por Email
    Usuario findByEmail(String email);
}
