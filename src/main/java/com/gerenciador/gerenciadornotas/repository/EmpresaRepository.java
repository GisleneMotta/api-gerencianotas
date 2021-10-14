package com.gerenciador.gerenciadornotas.repository;

import com.gerenciador.gerenciadornotas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
