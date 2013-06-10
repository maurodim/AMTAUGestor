/*
 * AMTAUGestorApp.java
 */

package amtaugestor;

import java.util.ArrayList;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import procesos.ViejosDatos;

/**
 * The main class of the application.
 */
public class AMTAUGestorApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new AMTAUGestorView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of AMTAUGestorApp
     */
    public static AMTAUGestorApp getApplication() {
        return Application.getInstance(AMTAUGestorApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        Procedimientos pr=new ViejosDatos();
        Procedimientos ps=new Socios();
        ArrayList listado=new ArrayList();
        pr.cargarPlanes();
        listado=pr.listar();
        ps.actualizarListado(listado);
        Procedimientos pc=new Cobradores();
        listado=pc.listar();
        pc.actualizarListado(listado);
        launch(AMTAUGestorApp.class, args);
    }
}
