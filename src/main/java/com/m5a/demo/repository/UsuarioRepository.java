/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.demo.repository;

import com.m5a.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ACER
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
