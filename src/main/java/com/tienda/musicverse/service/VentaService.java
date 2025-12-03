package com.tienda.musicverse.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.musicverse.dto.CompraCarritoDTO;
import com.tienda.musicverse.dto.ProductoCompraDTO;
import com.tienda.musicverse.model.Album;
import com.tienda.musicverse.model.DetalleVenta;
import com.tienda.musicverse.model.MetodoPago;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.model.Venta;
import com.tienda.musicverse.repository.AlbumRepository;
import com.tienda.musicverse.repository.DetalleVentaRepository;
import com.tienda.musicverse.repository.MetodoPagoRepository;
import com.tienda.musicverse.repository.UsuarioRepository;
import com.tienda.musicverse.repository.VentaRepository;

@Service
public class VentaService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;


    public Venta realizarCompra(CompraCarritoDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getRutUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        MetodoPago metodoPago = metodoPagoRepository.findById(dto.getIdMetodoPago())
                .orElseThrow(() -> new RuntimeException("Método de pago inválido"));

        Venta venta = new Venta();
        venta.setUsuario(usuario);
        venta.setMetodoPago(metodoPago);
        if(dto.getIdMetodoPago()==5){
            venta.setEstado("POR PAGAR");
        }else if(dto.getIdMetodoPago()==6){
            venta.setEstado("POR PAGAR");
        }else{
            venta.setEstado("PAGADO");
        }
        venta.setFecha(LocalDate.now());

        venta = ventaRepository.save(venta);
        int total = 0;

        List<DetalleVenta> detalles = new ArrayList<>();

        for (ProductoCompraDTO item : dto.getProductos()) {

            Album album = albumRepository.findById(item.getIdAlbum())
                    .orElseThrow(() -> new RuntimeException("Álbum no encontrado"));

            // Validar stock
            if (album.getStock() < item.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + album.getNombre());
            }

            // Restar stock
            album.setStock(album.getStock() - item.getCantidad());
            albumRepository.save(album);

            DetalleVenta detalle = new DetalleVenta();
            detalle.setAlbum(album);
            detalle.setVenta(venta);
            detalle.setCantidad(item.getCantidad());
            detalle.setDescuento(item.getDesc());
            detalle.setPrecio(album.getPrecio());
            detalleVentaRepository.save(detalle);
            detalles.add(detalle);
            double desc = 1 - item.getDesc();
            //total
            if(desc != 0){
                total += (album.getPrecio() * item.getCantidad() * desc);
            }else{
                total += (album.getPrecio() * item.getCantidad());
            }
            
            
        }

        venta.setMonto(total);
        venta.setDetalles(detalles);
        ventaRepository.save(venta);

        return venta;
    }

    public List<Venta> listarComprasUsuario(String rut) {

        usuarioRepository.findById(rut)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        return ventaRepository.findByUsuarioRut(rut);
    }
}
