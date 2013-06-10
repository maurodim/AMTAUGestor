/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amtaugestor;

import java.util.ArrayList;

/**
 *
 * @author mauro
 */
public interface Procedimientos {
    public void alta();
    public void baja(Integer numero);
    public void modificacion();
    public ArrayList listar();
    public void actualizarListado(ArrayList listado);
    public void cargar();
    public void cargarPlanes();
}
