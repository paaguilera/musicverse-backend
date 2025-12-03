package com.tienda.musicverse.component;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tienda.musicverse.dto.UsuarioRegistroDTO;
import com.tienda.musicverse.service.GeneroService;
import com.tienda.musicverse.service.MetodoPagoService;
import com.tienda.musicverse.service.RolService;
import com.tienda.musicverse.service.UsuarioService;

@Component
public class InicioComponent implements CommandLineRunner{

    @Autowired
    private RolService rolService;

    @Autowired
    private MetodoPagoService metodoPagoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private GeneroService generoService;

    public void run(String... args) throws Exception {

        // Crear roles si no existen
        rolService.registarRol("Admin");
        rolService.registarRol("Empleado");
        rolService.registarRol("Usuario");

        // Crear Metodo Pago
        this.metodoPagoService.registrarMetodo("Banco Estado Cuenta rut", "Debito");
        this.metodoPagoService.registrarMetodo("Banco Estado Credito", "Credito");
        this.metodoPagoService.registrarMetodo("Banco Chile Cuenta Fan", "Debito");
        this.metodoPagoService.registrarMetodo("Banco Chile Credito", "Credito");
        this.metodoPagoService.registrarMetodo("Efectivo", "Efectivo");
        this.metodoPagoService.registrarMetodo("Otros", "Otros");

        this.generoService.ingresarGenero("Rock");
        this.generoService.ingresarGenero("Metal");
        this.generoService.ingresarGenero("Rap");
        this.generoService.ingresarGenero("Trap");
        this.generoService.ingresarGenero("Pop");
        this.generoService.ingresarGenero("Jazz");
        this.generoService.ingresarGenero("Reggaeton");
        this.generoService.ingresarGenero("Indie");
        this.generoService.ingresarGenero("Hip Hop");

        UsuarioRegistroDTO usuarioRegistroDTO = new UsuarioRegistroDTO();

        usuarioRegistroDTO.setContrasenia("admin");
        usuarioRegistroDTO.setCorreo("admin@admin.com");
        usuarioRegistroDTO.setNombre("admin");
        usuarioRegistroDTO.setRut("11.111.111-1");
        usuarioRegistroDTO.setDireccion("admin");
        usuarioRegistroDTO.setMetodoPago(1);
        usuarioRegistroDTO.setGenero("Masculino");
        usuarioRegistroDTO.setTelefono("999666333");
        usuarioRegistroDTO.setFechaNacimiento(LocalDate.of(1995, 07, 24));

        
        System.out.println(usuarioService.registrarAdmin(usuarioRegistroDTO));
    }
}
