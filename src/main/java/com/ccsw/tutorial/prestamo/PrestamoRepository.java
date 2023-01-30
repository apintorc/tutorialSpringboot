package com.ccsw.tutorial.prestamo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.author.model.Author;
import com.ccsw.tutorial.prestamo.model.Prestamo;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {
	
    /**
    * Método para recuperar un listado paginado de {@link com.ccsw.tutorial.prestamo.model.Prestamo}
    * @param page
    * @return
    */
    Page<Prestamo> findAll(Pageable pageable);

    @Query("select p from Prestamo p where (:idGame is null or p.game.id like '%'||:idGame||'%') and (:idClient is null or p.client.id = :idClient) and (:fecha_inicio is null or :fecha_fin is null)")
    List<Prestamo> find(@Param("idGame") Long idGame, @Param("idClient") Long idClient, @Param("fecha_inicio") Date fecha_inicio, @Param("fecha_fin") Date fecha_fin);

    
}
