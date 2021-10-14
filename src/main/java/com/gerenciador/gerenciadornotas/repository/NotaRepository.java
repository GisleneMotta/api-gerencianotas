package com.gerenciador.gerenciadornotas.repository;

import com.gerenciador.gerenciadornotas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
