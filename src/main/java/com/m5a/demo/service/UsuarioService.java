/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.demo.service;

import com.m5a.demo.model.Usuario;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface UsuarioService {

    public Usuario crear(Usuario p);

    public Usuario findById(Long id);

    public List<Usuario> findByAll();

    public void delete(Long id);

}
