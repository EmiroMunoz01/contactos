package em.contactos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import em.contactos.modelo.Contacto;
import em.contactos.servicio.ContactoServicio;


@Controller
public class ContactoControlador {
    // con esto indicamos que estamos enviando informacion desde el
    // contactoControlador
    // private static final Logger logger =
    // LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    ContactoServicio contactoServicio;

    @GetMapping("/")
    // 1 invocamos el modelo, para que podamos recibir y compartir informacion
    public String iniciar(ModelMap modelo) {
        List<Contacto> contactos = contactoServicio.listarContactos();
        // 2 con esto estamos imprimiendo cada objeto uqe estamos recibiendo en el
        // listado de contactos
        // contactos.forEach((contacto) -> logger.info(contacto.toString()));
        contactos.forEach((contacto) -> contacto.toString());
        // 3 compartiremos la info desde el controlador a traves del modelo
        modelo.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar() {
        return "agregar";
    }


    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto){
        contactoServicio.guardarContacto(contacto);
        //de esta forma podremos ver los datos almacenamos en la base de datos, de lo contrario no podremos ver
        return "redirect:/"; //rederigimos al controlador al path de inicio y nos recargara los datos agregados, nos llamara el metodo get
    }
    
    

}
