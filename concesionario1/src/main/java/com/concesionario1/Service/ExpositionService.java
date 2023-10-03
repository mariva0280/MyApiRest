package com.concesionario1.Service;

import com.concesionario1.Controller.ExpositionInput;
import com.concesionario1.Domain.Exposicion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ExpositionService {
    private List<Exposicion> exposiciones = new ArrayList<>();

    public void addExposition(ExpositionInput input) throws ExpositionExistsException {

        Exposicion exposicion = new Exposicion(input.getCodExpo(),input.getNombre());
        for(Exposicion item : exposiciones) {
            if(item.getCodExpo() == exposicion.getCodExpo()) throw new ExpositionExistsException("The exposition already exists");
        }
        exposiciones.add(exposicion);
    }
}
