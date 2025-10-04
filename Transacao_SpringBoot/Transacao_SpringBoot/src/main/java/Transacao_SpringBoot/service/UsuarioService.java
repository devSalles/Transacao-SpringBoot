package Transacao_SpringBoot.service;

import Transacao_SpringBoot.core.exception.*;
import Transacao_SpringBoot.dto.usuario.UsuarioRequestDTO;
import Transacao_SpringBoot.dto.usuario.UsuarioResponseDTO;
import Transacao_SpringBoot.model.Usuario;
import Transacao_SpringBoot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public Usuario postUsuario(UsuarioRequestDTO usuarioRequestDTO)
    {
        if(this.usuarioRepository.findByCpf(usuarioRequestDTO.getCpf())!=null)
        {
            throw new CpfExistenteException();
        }

        if(this.usuarioRepository.findByEmail(usuarioRequestDTO.getEmail())!=null)
        {
            throw new EmailExistenteException();
        }

        Usuario usuarioSalvar=usuarioRequestDTO.toUsuario();
        return this.usuarioRepository.save(usuarioSalvar);
    }

    public UsuarioResponseDTO showByIDUsuario(Long id)
    {
        Usuario usuarioID = this.usuarioRepository.findById(id).orElseThrow(IdNaoEncontrado::new);
        return UsuarioResponseDTO.fromUsuario(usuarioID);
    }

    public UsuarioResponseDTO showByCpfUsuario(String cpf)
    {
        Usuario usuarioCPF = this.usuarioRepository.findByCpf(cpf);

        if(usuarioCPF==null)
        {
            throw new CpfNaoEncontradoException();
        }

        return UsuarioResponseDTO.fromUsuario(usuarioCPF);
    }

    public List<UsuarioResponseDTO> showAll()
    {
        List<Usuario>showAllUsuario=this.usuarioRepository.findAll();

        if(showAllUsuario.isEmpty())
        {
            throw new BancoVazioException();
        }
        return showAllUsuario.stream().map(user->UsuarioResponseDTO.fromUsuario(user)).toList();
    }
}
