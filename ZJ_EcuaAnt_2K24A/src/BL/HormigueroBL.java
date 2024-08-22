package BL;
import Infra.AppException;
import BL.Entities.ZJCarnivoro;
import BL.Entities.ZJGenoAlimento;
import BL.Entities.ZJHerbivoro;
import BL.Entities.ZJHormiga;
import BL.Entities.ZJIngestaNativa;
import BL.Entities.ZJLarva;
import BL.Entities.ZJNectarivoros;
import BL.Entities.ZJOmnivoro;
import BL.Entities.X;
import BL.Entities.XX;
import BL.Entities.XY;

import java.util.ArrayList;

public class HormigueroBL {
    public ArrayList<ZJHormiga> lstHormiguero = new ArrayList<>();

    public String crearLarva() throws AppException {
        ZJHormiga hormiga = new ZJLarva(lstHormiguero.size() + 1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
    }

    public String alimentarHormiga(int idHormiga, String alimentoGeno, String alimentoNativo) throws AppException {
        ZJGenoAlimento aGeno;
        ZJIngestaNativa aNativo;
        ZJHormiga hormiga = null;

        switch (alimentoGeno) {
            case "XX":
                aGeno = new XX();
                break;
            case "XY":
                aGeno = new XY();
                break;
            default:
                aGeno = new X();
                break;
        }

        System.out.println("alimentoNativo: " + alimentoNativo); // Línea de depuración

        switch (alimentoNativo.toLowerCase()) {
            case "carnivoro":
                aNativo = new ZJCarnivoro();
                break;
            case "herviboro":
                aNativo = new ZJHerbivoro();
                break;
            case "Omnivoro":
                aNativo = new ZJOmnivoro();
                break;
            case "nectarivoros":
                aNativo = new ZJNectarivoros();
                break;
            default:
                return "Ingesta nativa inválida";
        }

        for (ZJHormiga h : lstHormiguero) {
            if (h.getId() == idHormiga) {
                hormiga = h;
                break;
            }
        }

        if (hormiga == null || hormiga.getEstado().equals("MUERTA")) {
            return "Ups...! Hormiga no válida o ya está muerta.";
        }

        aNativo.inyectar(aGeno);
        ZJHormiga nuevaHormiga = hormiga.comer(aNativo);
        lstHormiguero.set(lstHormiguero.indexOf(hormiga), nuevaHormiga);

        return nuevaHormiga.getTipo() + " Alimentada";
    }
}