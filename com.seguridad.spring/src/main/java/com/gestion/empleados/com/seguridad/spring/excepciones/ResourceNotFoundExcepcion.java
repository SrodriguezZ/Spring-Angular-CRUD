
package com.gestion.empleados.com.seguridad.spring.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepcion extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundExcepcion (String mensaje){
        super(mensaje);
    }
}
