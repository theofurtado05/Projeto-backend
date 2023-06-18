package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DadosChamados {
    
    private HashMap<Date, Integer> mapaDatas = new HashMap<>();

    public DadosChamados() {
        mapaDatas = new HashMap<>();
    }

    public HashMap<Date, Integer> getMapaDatas() {
        return mapaDatas;
    }

    public void setMapaDatas(HashMap<Date, Integer> mapaDatas) {
        this.mapaDatas = mapaDatas;
    }


}
