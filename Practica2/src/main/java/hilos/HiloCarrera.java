package hilos;

import modelo.Personaje;
import modelo.Premio;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import vista.CarreraFrame;

public class HiloCarrera extends Thread {

    private final Premio[] premios;
    private final int cantidadPremios;

    private final Personaje jugador;
    private int x = 0;
    private final JPanel panel;
    private boolean terminar = false;

    private final CarreraFrame frame; 

    public HiloCarrera(Personaje p, JPanel panel, Premio[] premios, int cantidadPremios, CarreraFrame frame) {
        this.jugador = p;
        this.panel = panel;
        this.premios = premios;
        this.cantidadPremios = cantidadPremios;
        this.frame = frame;
    }

    @Override
    public void run() {
        try {
            while (x < 500 && !terminar) {

                Thread.sleep(jugador.getVelocidad());
                x += 10;

                // recorrer premios
                for (int i = 0; i < cantidadPremios; i++) {

                    Premio pr = premios[i];

                    //validar premio ya usado
                    if (pr != null && x >= pr.posicion) {

                        aplicarEfecto(pr);

                        premios[i] = null; //eliminar premio
                    }
                }

                // detectar ganador por meta
                if (x >= 500 && !terminar) {
                    terminar = true;
                    frame.declararGanador(jugador);
                }

                // repaint seguro
                SwingUtilities.invokeLater(() -> panel.repaint());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void aplicarEfecto(Premio p) {

        switch (p.tipo) {

            case 'S':
                jugador.sumarPuntos(150);
                x = 500;
                terminar = true;

                frame.declararGanador(jugador); //ganar inmediatamente
                break;

            case 'B':
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case 'Q':
                jugador.sumarPuntos(10);
                break;
        }
    }

    public int getX() {
        return x;
    }
}