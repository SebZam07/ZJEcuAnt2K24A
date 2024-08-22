package BL.Entities;

public class ZJLarva extends ZJHormiga{
    public ZJLarva(int id) {
        super(id, "Larva");
        this.setSexo("Asexual");  
        this.setEstado("VIVA");
    }

    @Override
    public ZJHormiga comer(ZJIngestaNativa ingestaNativa) {
        if (ingestaNativa instanceof ZJHerbivoro && ingestaNativa.getGenoAlimentoInyectado().getTipo().equals("XX")) {
            ZJHRastreadora rastreadora = new ZJHRastreadora(this.getId());
            rastreadora.setSexo("Hembra");  // Cambio a Hembra
            return rastreadora;
        }

        if (ingestaNativa instanceof ZJNectarivoros &&
            (ingestaNativa.getGenoAlimentoInyectado().getTipo().equals("X") ||
             ingestaNativa.getGenoAlimentoInyectado().getTipo().equals("XX") ||
             ingestaNativa.getGenoAlimentoInyectado().getTipo().equals("XY"))) {
            return this;  // Sin cambios, la larva sigue viva
        }

        this.setEstado("MUERTA");
        return this;
    }
}
