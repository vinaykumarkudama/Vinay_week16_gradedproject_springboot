package com.glca.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.glca.app.entity.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

	// List<Ticket> findByTitleContainingIgnoreCase(String name);

	@Query("SELECT p from Ticket p WHERE " + "p.title LIKE CONCAT('%', :name, '%') OR "
			+ "p.shortDescription LIKE CONCAT('%', :name, '%')")
	List<Ticket> searchTicketsByName(@Param("name") String name);

}
