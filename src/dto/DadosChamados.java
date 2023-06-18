package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.StatusChamado;

public class DadosChamados {
    
    private Map<Integer, StatusChamado> resultados;

    public void ResultadoChamados() {
        resultados = new HashMap<>();
    }

    public void adicionarResultado(int statusChamadoId, StatusChamado status) {
        resultados.put(statusChamadoId, status);
    }

    public Integer getResultado(StatusChamado statusChamado) {
        return resultados.getOrDefault(statusChamado, 0);
    }


}
