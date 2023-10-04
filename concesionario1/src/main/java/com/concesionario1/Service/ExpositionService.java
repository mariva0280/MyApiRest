package com.concesionario1.Service;

import com.concesionario1.Controller.CarInput;
import com.concesionario1.Controller.CarOutput;
import com.concesionario1.Controller.ExpositionInput;
import com.concesionario1.Controller.ExpositionOutput;
import com.concesionario1.Domain.Coche;
import com.concesionario1.Domain.Exposicion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void addCocheToExposicion(int codExpo, int cocheId, CarInput cocheInput) throws ExpositionNotFoundException {
        Exposicion exposicion = findExpoByCodExpo(codExpo);
        if(exposicion != null) {
            exposicion.addCocheExpo(cocheId,cocheInput);
        }else {
            throw new ExpositionNotFoundException("Exposition not found");
        }
    }

    public List<ExpositionOutput> getExposiciones() {
        List<ExpositionOutput> expositionOutput = new ArrayList<>();
        for(Exposicion exposicion : exposiciones) {
            expositionOutput.add(new ExpositionOutput(exposicion.getCodExpo()));
        }
        return expositionOutput;
    }
    public CarOutput getCarFromExposicion(int codExpo,int cocheId) throws ExpositionNotFoundException, CarNotFoundException {
        Exposicion exposicion = findExpoByCodExpo(codExpo);
        if(exposicion != null) {
            CarInput carInput = exposicion.getCoches().get(cocheId);
            if(carInput != null) {
                return new CarOutput(carInput.getMatricula(),carInput.getMarca());
            }else{
                throw new CarNotFoundException("Car not found in the exposition");
            }
        }else{
            throw new ExpositionNotFoundException("Exposition not found");
        }
    }

    private Exposicion findExpoByCodExpo(int codExpo) {
        for(Exposicion exposicion : exposiciones) {
            if(exposicion.getCodExpo() == codExpo){
                return exposicion;
            }
        }
        return null;
    }
}
