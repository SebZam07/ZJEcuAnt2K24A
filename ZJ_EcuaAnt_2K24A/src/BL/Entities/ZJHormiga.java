package BL.Entities;

public abstract class ZJHormiga implements ZJIHormiga {
    private Integer id;
    private String tipo;
    private String sexo;
    private String estado;

    

    public ZJHormiga() {
    }
    public ZJHormiga(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    public ZJHormiga(Integer id, String tipo, String sexo, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.sexo = sexo;
        this.estado = estado;
    }
    @Override
    public String toString() {
        return tipo.toUpperCase();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }   

    @Override
    public ZJHormiga comer(ZJIngestaNativa ingestaNativa) {
        if (ingestaNativa.getGenoAlimentoInyectado() != null && ingestaNativa.getGenoAlimentoInyectado().getTipo().equals("X")) {
            this.setEstado("VIVA");
            this.setTipo("Hormiga Obrera");
        } else {
            this.setEstado("MUERTA");
        }
        return this;
    }
}
