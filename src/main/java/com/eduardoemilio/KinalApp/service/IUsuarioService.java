package com.eduardoemilio.KinalApp.service;
import com.eduardoemilio.KinalApp.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> listarUsuario();

    Usuario guardarU(Usuario usuario);

    Usuario ActualizarU(int code, Usuario usuario);

    void eliminarU(int code);

    boolean existcode(int code);

    Optional<Usuario> buscarPorcode(int code);

    List<Usuario> UsuarioEstado(int estado);

}
