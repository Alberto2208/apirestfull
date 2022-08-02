/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.demo.controller;

import com.m5a.demo.model.Usuario;
import com.m5a.demo.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> listar() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.crear(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario u) {
        Usuario usuario = buscarUsuario(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {
                 usuario.setNombre(u.getNombre());
                usuario.setClave(u.getClave());
                usuario.setEstado(u.getEstado());
                usuario.setEmail(u.getEmail());
                return new ResponseEntity<>(usuarioService.crear(u), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
           
        }

    }


    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

}
