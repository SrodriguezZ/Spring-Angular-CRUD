
package com.gestion.empleados.com.seguridad.spring.controller;

import com.gestion.empleados.com.seguridad.spring.excepciones.ResourceNotFoundExcepcion;
import com.gestion.empleados.com.seguridad.spring.model.Empleado;
import com.gestion.empleados.com.seguridad.spring.respository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    //Lista de empleado
    @GetMapping("/empleados")
    public List<Empleado> listaempleados(){
        return empleadoRepository.findAll();
    }
    
    //Sirve para guardar un empeado
    @PostMapping("/empleados")
    public Empleado registrarEmpleados(@RequestBody Empleado empleado){
        return empleadoRepository.save(empleado);
    }
    
    //Este metodo sirve para buscar un empleado
    @GetMapping("empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundExcepcion("No existe el empleado con el ID : " + id));
        return ResponseEntity.ok(empleado);
    }
    
    //Para actualizar un empleado
    @PatchMapping("empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundExcepcion("No existe el empleado con el ID: " + id));
        empleado.setNombres(detallesEmpleado.getNombres());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());
        
        Empleado empleadoActualizado = empleadoRepository.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }
    
    //Eliminar un empleado
    @DeleteMapping("empleados/{id}")
    public void eliminarEmpleado(@PathVariable Long id){
        empleadoRepository.deleteById(id);
    }
}
