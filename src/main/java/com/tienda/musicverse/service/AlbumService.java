package com.tienda.musicverse.service;

import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tienda.musicverse.dto.AlbumEstadoDTO;
import com.tienda.musicverse.dto.AlbumGrandDTO;
import com.tienda.musicverse.dto.AlbumRegistroDTO;
import com.tienda.musicverse.dto.GenerosFavoritosDTO;
import com.tienda.musicverse.dto.ProductosMiniDTO;
import com.tienda.musicverse.model.Album;
import com.tienda.musicverse.model.Artista;
import com.tienda.musicverse.model.Cancion;
import com.tienda.musicverse.model.Genero;
import com.tienda.musicverse.model.Resenia;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.repository.AlbumRepository;
import com.tienda.musicverse.repository.ArtistaRepository;
import com.tienda.musicverse.repository.GeneroRepository;

@Service
public class AlbumService {

    @Value("${album.images.path}")
    private String imagePath;

    @Value("${album.images.url}")
    private String baseUrl;

    @Value("${album.images.url.ip4}")
    private String ipUrl;

    @Value("${album.images.url.local}")
    private String localUrl;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public String ingresarAlbum(AlbumRegistroDTO dto, MultipartFile imagen){
        Album album = new Album();
        try {
            Artista artista = artistaRepository.findByNombre(dto.getArtista())
            .orElseGet(() -> {
                Artista nuevo = new Artista();
                nuevo.setNombre(dto.getArtista());
                return artistaRepository.save(nuevo);
            });
            
            Genero genero = generoRepository.findByNombre(dto.getGenero())
                .orElseThrow(() -> new RuntimeException("El género no existe"));
            if(albumRepository.findByNombre(dto.getNombre()).isPresent()){
                return "El Album ya existe";
            }

            album.setNombre(dto.getNombre());
            album.setFormato(dto.getFormato());
            album.setCodeUPC(dto.getCodeUPC());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(dto.getFecha_lanza(), formatter);
            album.setFecha_lanza(fecha);
            album.setPrecio(dto.getPrecio());
            album.setStock(dto.getStock());
            album.setArtista(artista);
            album.setGenero(genero);

            album.setCanciones(new ArrayList<>());
            album.setResenias(new ArrayList<>());

            if (!imagen.isEmpty()) {

                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")).toString();

                String filename = "";
                filename = dto.getNombre().replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                filename = filename.toLowerCase().replace(" ", "-");
                filename = filename.replaceAll("[^a-z0-9-_]", "");
                filename = timestamp + "_" + filename;
                if (imagen.getContentType() != null && imagen.getContentType().contains("/")) {
                    filename = filename+"." + imagen.getContentType().split("/")[1];
                }
                Path finalPath = Paths.get(imagePath + filename);
                Files.createDirectories(finalPath.getParent());
                Files.write(finalPath, imagen.getBytes());

                String url = ipUrl + filename;

                album.setImagenUrl(url);
            }

            albumRepository.save(album);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "ok";
    }

    public List<Album> listarAlbums() {
        return albumRepository.findAll();
    }

    public List<ProductosMiniDTO> listarAlbumsMini() {
        List<Album> albums = albumRepository.findAll();
        List<ProductosMiniDTO> lista = new ArrayList();
        albums.stream().map(album -> {
            ProductosMiniDTO mini = new ProductosMiniDTO();
            mini.setArtista(album.getArtista().getNombre());
            mini.setGenero(album.getGenero().getNombre());
            mini.setId(album.getId_album());
            mini.setImagenUrl(album.getImagenUrl());
            mini.setNombre(album.getNombre());
            mini.setPrecio(album.getPrecio());
            mini.setDesabilidato(album.isDesabilidato());
            return mini;
        }).forEach(lista::add);

        return lista;
    }

    public List<ProductosMiniDTO> listarAlbumsMiniGenero(int id) {
        List<Album> albums = albumRepository.findByGeneroIdGenero(id);
        System.out.println(albums);
        List<ProductosMiniDTO> lista = new ArrayList();
        albums.stream().map(album -> {
            ProductosMiniDTO mini = new ProductosMiniDTO();
            mini.setArtista(album.getArtista().getNombre());
            mini.setGenero(album.getGenero().getNombre());
            mini.setId(album.getId_album());
            mini.setImagenUrl(album.getImagenUrl());
            mini.setNombre(album.getNombre());
            mini.setPrecio(album.getPrecio());
            mini.setDesabilidato(album.isDesabilidato());
            return mini;
        }).forEach(lista::add);

        return lista;
    }
    public List<ProductosMiniDTO> listarAlbumsMiniGeneroUser(String rut) {
        List<Album> albums = albumRepository.findAlbumsByUsuarioGenero(rut);
        System.out.println(albums);
        List<ProductosMiniDTO> lista = new ArrayList();
        albums.stream().map(album -> {
            ProductosMiniDTO mini = new ProductosMiniDTO();
            mini.setArtista(album.getArtista().getNombre());
            mini.setGenero(album.getGenero().getNombre());
            mini.setId(album.getId_album());
            mini.setImagenUrl(album.getImagenUrl());
            mini.setNombre(album.getNombre());
            mini.setPrecio(album.getPrecio());
            mini.setDesabilidato(album.isDesabilidato());
            return mini;
        }).forEach(lista::add);

        return lista;
    }
    public Album obtenerPorId(int id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Álbum no encontrado"));
    }

    public List<Album> listarPorArtista(String nombreArtista) {
        return albumRepository.findByArtistaNombre(nombreArtista);
    }

    public List<Album> listarPorGenero(String nombreGenero) {
        return albumRepository.findByGeneroNombre(nombreGenero);
    }

    public Album buscarPorUPC(int upc) {
        return albumRepository.findByCodeUPC(upc)
                .orElseThrow(() -> new RuntimeException("Álbum no encontrado"));
    }

    public List<Album> buscar(String query) {

        List<Album> resultados = new ArrayList<>();

        // Si es número → podría ser UPC o ID
        if (query.matches("\\d+")) {
            int numero = Integer.parseInt(query);

            // Buscar por UPC
            albumRepository.findByCodeUPC(numero).ifPresent(resultados::add);

            // Buscar por ID
            albumRepository.findById(numero).ifPresent(resultados::add);
        }

        // Buscar por nombre de álbum
        resultados.addAll(albumRepository.findByNombreContainingIgnoreCase(query));

        // Buscar por artista
        resultados.addAll(albumRepository.findByArtistaNombreContainingIgnoreCase(query));

        // Buscar por género
        resultados.addAll(albumRepository.findByGeneroNombreContainingIgnoreCase(query));

        // Eliminar duplicados
        return resultados.stream().distinct().toList();
    }
    public List<ProductosMiniDTO> buscarMini(String query) {

        List<Album> resultados = new ArrayList<>();
        if (query.matches("\\d+")) {
            int numero = Integer.parseInt(query);
            albumRepository.findByCodeUPC(numero).ifPresent(resultados::add);
            albumRepository.findById(numero).ifPresent(resultados::add);
        }

        resultados.addAll(albumRepository.findByNombreContainingIgnoreCase(query));
        resultados.addAll(albumRepository.findByArtistaNombreContainingIgnoreCase(query));
        resultados.addAll(albumRepository.findByGeneroNombreContainingIgnoreCase(query));
        resultados = resultados.stream().distinct().toList();

        // Convertir a ProductosMiniDTO
        return resultados.stream().map(album -> {
            ProductosMiniDTO mini = new ProductosMiniDTO();
            mini.setArtista(album.getArtista().getNombre());
            mini.setGenero(album.getGenero().getNombre());
            mini.setId(album.getId_album());
            mini.setImagenUrl(album.getImagenUrl());
            mini.setNombre(album.getNombre());
            mini.setPrecio(album.getPrecio());
            mini.setDesabilidato(album.isDesabilidato());
            return mini;
        }).toList();
    }
    public AlbumGrandDTO buscarPorNombre(String nombre){
        Album album = albumRepository.findByNombre(nombre).get();
        AlbumGrandDTO albumGrandDTO = new AlbumGrandDTO();

        List<Cancion> canciones = album.getCanciones();
        List<String> cc = new ArrayList<>();

        for (Cancion cancion : canciones) {
            cc.add(cancion.getNombre());
        }

        List<Resenia> resenias = album.getResenias();
        List<String> rr = new ArrayList<>();
        
        for (Resenia resenia : resenias) {
            rr.add(resenia.getContenido());
        }

        albumGrandDTO.setCanciones(cc);
        albumGrandDTO.setResenias(rr);
        albumGrandDTO.setIdAlbum(album.getId_album());
        albumGrandDTO.setNombre(album.getNombre());
        albumGrandDTO.setFormato(album.getFormato());
        albumGrandDTO.setCodeUPC(album.getCodeUPC());
        albumGrandDTO.setFechaLanza(album.getFecha_lanza());
        albumGrandDTO.setPrecio(album.getPrecio());
        albumGrandDTO.setStock(album.getStock());
        albumGrandDTO.setImagenUrl(album.getImagenUrl());
        albumGrandDTO.setArtista(album.getArtista().getNombre());
        albumGrandDTO.setGenero(album.getGenero().getNombre());
        albumGrandDTO.setDesabilidato(album.isDesabilidato());
        return albumGrandDTO;
    }

    public void estadoAlbum(int id,AlbumEstadoDTO estadoDTO){
        Album album = this.albumRepository.findById(id).get();
        album.setDesabilidato(estadoDTO.isEstado());
        albumRepository.save(album);
    }
}
