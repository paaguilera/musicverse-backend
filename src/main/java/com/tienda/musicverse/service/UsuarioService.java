package com.tienda.musicverse.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tienda.musicverse.dto.UsuarioModificarDTO;
import com.tienda.musicverse.dto.UsuarioRegistroDTO;
import com.tienda.musicverse.dto.GenerosFavoritosDTO;
import com.tienda.musicverse.dto.GenerosUsuarioDTO;
import com.tienda.musicverse.dto.UsuarioMiniDTO;
import com.tienda.musicverse.model.Genero;
import com.tienda.musicverse.model.MetodoPago;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.repository.GeneroRepository;
import com.tienda.musicverse.repository.MetodoPagoRepository;
import com.tienda.musicverse.repository.RolRepository;
import com.tienda.musicverse.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public UsuarioService() {
    }

    public String registrarUsuario(UsuarioRegistroDTO dto){

        Usuario usuario = new Usuario();
        try {
            if(usuarioRepository.existsById(dto.getRut())){
                return "Error: usuario ya registrado";
            }
            if(usuarioRepository.existsByCorreo(dto.getCorreo())){
                return "Error: usuario ya registrado";
            }
            usuario.setRut(dto.getRut());
            usuario.setNombre(dto.getNombre());
            usuario.setCorreo(dto.getCorreo());
            usuario.setContrasena(new BCryptPasswordEncoder().encode(dto.getContrasenia()));
            usuario.setActiva(true);
            usuario.setDireccion(dto.getDireccion());
            usuario.setTelefono(dto.getTelefono());
            usuario.setGenero(dto.getGenero());
            usuario.setRol(rolRepository.findByNombre("Usuario").get());
            usuario.setFechaNacimiento(dto.getFechaNacimiento());
            usuarioRepository.save(usuario);

            this.agregarMetodoPago(dto.getRut(), dto.getMetodoPago());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "ok";
    }

    public String registrarAdmin(UsuarioRegistroDTO dto){

        Usuario usuario = new Usuario();
        try {
            if(usuarioRepository.existsById(dto.getRut())){
                return "Error: usuario ya registrado";
            }
            usuario.setRut(dto.getRut());
            usuario.setNombre(dto.getNombre());
            usuario.setCorreo(dto.getCorreo());
            usuario.setContrasena(new BCryptPasswordEncoder().encode(dto.getContrasenia()));
            usuario.setActiva(true);
            usuario.setDireccion(dto.getDireccion());
            usuario.setTelefono(dto.getTelefono());
            usuario.setGenero(dto.getGenero());
            usuario.setRol(rolRepository.findByNombre("Admin").get());
            usuario.setFechaNacimiento(dto.getFechaNacimiento());

            usuarioRepository.save(usuario);
            this.agregarMetodoPago(dto.getRut(), dto.getMetodoPago());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "ok";
    }

    public List<Usuario> obteneUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
    public List<UsuarioMiniDTO> obteneUsuariosMini() {
        List<UsuarioMiniDTO> lista = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAll();
        UsuarioMiniDTO dto = new UsuarioMiniDTO();
        for(Usuario usuario: usuarios){
            if(!usuario.getRol().getNombre().equals("Admin")){
                dto.setCorreo(usuario.getCorreo());
                dto.setNombre(usuario.getNombre());
                dto.setRut(usuario.getRut());
                lista.add(dto);
                dto = new UsuarioMiniDTO();
            }
        }
        return lista;
    }
    public UsuarioModificarDTO obtenerUsuarioDTO(String rut) {
        Usuario usuario = usuarioRepository.findById(rut).orElse(null);
        if (usuario == null) return null;
        UsuarioModificarDTO dto = new UsuarioModificarDTO();
        dto.setCorreo(usuario.getCorreo());
        dto.setNombre(usuario.getNombre());
        dto.setDireccion(usuario.getDireccion());
        dto.setTelefono(usuario.getTelefono());
        dto.setFecha(usuario.getFechaNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dto.setMetodoPago(usuario.getMetodoPago().getId_metodopago());
        return dto;
    }

    public String modificUsuario(String id,UsuarioModificarDTO dto) {
        try {
            Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                    new RuntimeException("Usuario no encontrado: " + id));

            usuario.setNombre(dto.getNombre());
            usuario.setCorreo(dto.getCorreo());
            usuario.setDireccion(dto.getDireccion());
            usuario.setTelefono(dto.getTelefono());
            usuario.setFechaNacimiento(LocalDate.parse(dto.getFecha()));
            usuario.setGenero(dto.getGenero());
            agregarMetodoPago(usuario.getRut(),dto.getMetodoPago());
            usuario.setContrasena(new BCryptPasswordEncoder().encode(dto.getContrasenia()));
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "ok";
    }

    public void eliminarUsuario(String rut){
        Usuario usuario = this.usuarioRepository.findById(rut)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

    public String generosFavoritos(String id,GenerosFavoritosDTO dto){
        Usuario usuario = this.usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        try {
            List<Genero> generos = generoRepository.findAllById(dto.getGenerosIds());
            usuario.getGeneros().clear();
            usuario.setGeneros(generos);

            usuarioRepository.save(usuario);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Lista Actualizada";
    }

    public String agregarMetodoPago(String rut, int id){
        try {
            Usuario usuario = this.usuarioRepository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            MetodoPago metodoPago = this.metodoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metodo Pago no encontrado"));
            
            usuario.setMetodoPago(metodoPago);
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "ok";
    }

    public List<GenerosUsuarioDTO> generosFavoritoList(String rut){
        Usuario usuario = this.usuarioRepository.findById(rut).get();
        List<Genero> generos = usuario.getGeneros();
        List<GenerosUsuarioDTO> dtos = new ArrayList<>();
        GenerosUsuarioDTO dto = new GenerosUsuarioDTO();
        for(Genero gen: generos){
            dto.setId(gen.getIdGenero());
            dto.setNombre(gen.getNombre());
            dtos.add(dto);
            dto = new GenerosUsuarioDTO();
        }
        return dtos;
    }

    public void eliminarUsuarioPorRut(String rut) {
        Usuario usuario = this.usuarioRepository.findById(rut).get();
        GenerosFavoritosDTO genDTO = new GenerosFavoritosDTO();
        this.generosFavoritos(rut, genDTO);
        usuarioRepository.delete(usuario);
    }

    public List<UsuarioMiniDTO> buscarQuery(String query) {

        List<Usuario> resultados = new ArrayList<>();
        resultados.addAll(usuarioRepository.findByNombreContainingIgnoreCase(query));
        resultados.addAll(usuarioRepository.findByCorreoContainingIgnoreCase(query));
        resultados.addAll(usuarioRepository.findByRutContainingIgnoreCase(query));

        resultados = resultados.stream()
                                .filter(user -> !user.getRol().getNombre().equals("Admin"))
                                .distinct().toList();
        return resultados.stream().map(user -> {
            UsuarioMiniDTO mini = new UsuarioMiniDTO();
            mini.setCorreo(user.getCorreo());
            mini.setNombre(user.getNombre());
            mini.setRut(user.getRut());
            return mini;
        }).toList();
    }
}
