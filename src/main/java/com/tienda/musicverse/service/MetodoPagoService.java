package com.tienda.musicverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.musicverse.model.MetodoPago;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.repository.MetodoPagoRepository;
import com.tienda.musicverse.repository.UsuarioRepository;

@Service
public class MetodoPagoService {
    
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void registrarMetodo(String nombre, String tipo){
        MetodoPago metodoPago = new MetodoPago();
        if(!metodoPagoRepository.findByNombre(nombre).isPresent()){
            metodoPago.setNombre(nombre);
            metodoPago.setTipo(tipo);

            this.metodoPagoRepository.save(metodoPago);
        }
    }

    public void agregarMetodoPago(String rut, int id){
        Usuario usuario = usuarioRepository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        MetodoPago metodoPago = metodoPagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metodo Pago no encontrado"));

        this.metodoPagoRepository.save(metodoPago);

        usuario.setMetodoPago(metodoPago);
        this.usuarioRepository.save(usuario);
    }

    public List<MetodoPago> obtenerMetodosPago(){
        return this.metodoPagoRepository.findAll();
    }
}
