package em.contactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import em.contactos.modelo.Contacto;

public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {

}
