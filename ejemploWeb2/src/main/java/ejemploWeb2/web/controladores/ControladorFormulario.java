	/**
 * 
 */
package ejemploWeb2.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Modelos.Usuario;




/**
 * @author Pablo López
 * Clase controlador del formulario
 */


@Controller
public class ControladorFormulario {
	 
	
	 /**
	  * ANOTACIONES USADAS:
	  * formulario_registro.jsp
	  * - @RequestMapping: Asocia la solicitud con el controlador.
	  */
	    @RequestMapping(value="/formulario")  // "/formulario" se refiere a la vista "formulario_registro.jsp"
	    public String mostrarFormulario (Model modelo) { //Model: Va a poseer los atributos de "modelo"
	        Usuario usuario = new Usuario();
	        //A partir de "modelo", asignamos el nombre "usuarioVista" a nuestra instancia usuario que acabamos de crear
	        modelo.addAttribute("usuarioVista", usuario);
	        
	        return "formulario_registro";
	    }
	    
	   
	 /**
	  * ANOTACIONES USADAS:
	  * formulario_enviado.jsp
	  * - @PostMapping: Nos ahorra el proceso del metodo POST con @RequestMapping.
	  * - @ModelAttribute sirve para recuperar atributos del @RequestMapping anterior y rellenar la "key" 
	  *   usuarioVista (que usaremos en la vista formulario_enviado.jsp) con los datos que se introduzcan.
	  */
	    @PostMapping("/registrado") // "/registrado" se refiere a la vista "formulario_enviado.jsp"
	    public String rellenarFormulario (@ModelAttribute("usuarioVista") Usuario usuario) {
	    	
	        return "formulario_enviado";
	    }
	    
}
