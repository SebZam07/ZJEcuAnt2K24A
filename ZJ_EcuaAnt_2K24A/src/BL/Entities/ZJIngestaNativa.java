package BL.Entities;

public abstract class ZJIngestaNativa extends ZJAlimento implements ZJIIngestaNativa{
    private ZJGenoAlimento genoAlimentoInyectado;

    @Override
    public boolean inyectar(ZJGenoAlimento genoAlimento) {
        if (genoAlimento != null) {
            this.genoAlimentoInyectado = genoAlimento;
            return true;
        }
        return false;
    }

    public ZJGenoAlimento getGenoAlimentoInyectado() {
        return this.genoAlimentoInyectado;
    }
}
