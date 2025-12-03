package com.tienda.musicverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.musicverse.dto.AlbumGrandDTO;
import com.tienda.musicverse.dto.AlbumRegistroDTO;
import com.tienda.musicverse.dto.ProductosMiniDTO;
import com.tienda.musicverse.model.Album;
import com.tienda.musicverse.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import java.time.LocalDate;

@RestController
@RequestMapping({"/album"})
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    // @PostMapping("")
    // public ResponseEntity<?> crearAlbum(@RequestBody AlbumRegistroDTO dto) {
        
    //     String ok = albumService.ingresarAlbum(dto);
    //     if(ok.equals("NOK")){
    //         return ResponseEntity
    //         .status(HttpStatus.CONFLICT)
    //         .body("Ya existe un album registrado con ese RUT");
    //     }
    //     return ResponseEntity.ok(ok);
    // }

    @PostMapping(value = "/registrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crearAlbum(
            @RequestPart("data") String sdto,
            @RequestPart("imagen") MultipartFile imagen) throws Exception {
            // Verificar que el DTO no sea null
        System.out.println(sdto);
        System.out.println(imagen.getContentType());
        ObjectMapper objectMapper = new ObjectMapper();
        AlbumRegistroDTO dto = objectMapper.readValue(sdto, AlbumRegistroDTO.class);
        String ok = albumService.ingresarAlbum(dto, imagen);
        if(ok.equals("NOK")){
            return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Ya existe un album registrado con ese RUT");
        }
        return ResponseEntity.ok(ok);
    }

    @GetMapping("")
    public ResponseEntity<List<Album>> listarTodosAlbumnes() {
        List<Album> lista = albumService.listarAlbums();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/mini")
    public ResponseEntity<List<ProductosMiniDTO>> listarTodosAlbumnesMini() {
        List<ProductosMiniDTO> lista = albumService.listarAlbumsMini();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/mini/{id}")
    public ResponseEntity<List<ProductosMiniDTO>> listarAlbumsMiniGenero(@PathVariable int id) {
        List<ProductosMiniDTO> lista = albumService.listarAlbumsMiniGenero(id);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/mini/user/{rut}")
    public ResponseEntity<List<ProductosMiniDTO>> listarAlbumsMiniGeneroUser(@PathVariable String rut) {
        List<ProductosMiniDTO> lista = albumService.listarAlbumsMiniGeneroUser(rut);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<?> buscarPorNombreGrand(@PathVariable String nombre) {
        try {
            return ResponseEntity.ok(albumService.buscarPorNombre(nombre));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(albumService.obtenerPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/artista/{nombre}")
    public ResponseEntity<List<Album>> obtenerPorArtista(@PathVariable String nombre) {
        return ResponseEntity.ok(albumService.listarPorArtista(nombre));
    }

    @GetMapping("/genero/{nombre}")
    public ResponseEntity<List<Album>> obtenerPorGenero(@PathVariable String nombre) {
        return ResponseEntity.ok(albumService.listarPorGenero(nombre));
    }

    @GetMapping("/upc/{code}")
    public ResponseEntity<?> obtenerPorUPC(@PathVariable int code) {
        try {
            return ResponseEntity.ok(albumService.buscarPorUPC(code));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @GetMapping("/buscador")
    public ResponseEntity<List<Album>> buscar(@RequestParam String query) {
        return ResponseEntity.ok(albumService.buscar(query));
    }

    @GetMapping("/buscador/mini")
    public ResponseEntity<List<ProductosMiniDTO>> buscarMini(@RequestParam String query) {
        return ResponseEntity.ok(albumService.buscarMini(query));
    }
}
