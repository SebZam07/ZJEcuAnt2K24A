package BL.Entities;

public class ZJHRastreadora extends ZJHormiga{
    public ZJHRastreadora(int id) {
        super(id, "Rastreadora");
        this.setEstado("VIVA");
    }

    @Override
    public ZJHormiga comer(ZJIngestaNativa ingestaNativa) {
        if (ingestaNativa instanceof ZJHerbivoro && ingestaNativa.getGenoAlimentoInyectado().getTipo().equals("XX")) {
            return this;  // Sin cambios, sigue viva
        }

        this.setEstado("MUERTA");
        return this;
    }

}
