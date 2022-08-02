/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.demo.service;

import com.m5a.demo.model.Usuario;
import com.m5a.demo.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired 
    private UsuarioRepository usuariorepository;
    
    @Override
    public Usuario crear(Usuario p) {
        return usuariorepository.save(p);
    }

    @Override
    public Usuario findById(Long id) {
        return usuariorepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findByAll() {
        return usuariorepository.findAll();
    }

    @Override
    public void delete(Long id) {
        usuariorepository.deleteById(id);
    }
    
}
