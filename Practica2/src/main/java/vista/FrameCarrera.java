
package vista;
import hilos.HiloCarrera;
import modelo.Personaje;
import modelo.Premio;

import javax.swing.*;
import java.awt.*;

public class FrameCarrera extends javax.swing.JFrame {
    private JPanel panel;
    private boolean hayGanador = false;
    private HiloCarrera h1, h2;

    // Vector de premios (máx 5)
    private Premio[] premios = new Premio[5];
    private int cantidadPremios = 0;

    public FrameCarrera(Personaje j1, Personaje j2) {

        setTitle("Carrera de Escobas");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        generarPremios();

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // jugador 1
                g.setColor(Color.RED);
                g.fillRect(h1.getX(), 50, 30, 30);

                // jugador 2
                g.setColor(Color.BLUE);
                g.fillRect(h2.getX(), 150, 30, 30);

                // premios
                for (int i = 0; i < cantidadPremios; i++) {
                    g.drawString("" + premios[i].tipo, premios[i].posicion, 100);
                }
            }
        };

        add(panel);

        

        // Iniciar hilos
        h1.start();
        h2.start();
    }

   
    private void generarPremios() {

        for (int i = 0; i < 5; i++) {

            int pos = (int)(Math.random() * 500);

            char tipo;
            int r = (int)(Math.random() * 3);

            if (r == 0) tipo = 'S';
            else if (r == 1) tipo = 'B';
            else tipo = 'Q';

            premios[i] = new Premio(pos, tipo);
            cantidadPremios++;
        }
    }
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrameCarrera.class.getName());

    
    public FrameCarrera() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public synchronized void declararGanador(Personaje p) {

    if (!hayGanador) {
        hayGanador = true;

        javax.swing.JOptionPane.showMessageDialog(this,
            "Ganador: " + p.getNombre() +
            "\nPuntos: " + p.getPuntos()
        );
    }
}
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new FrameCarrera().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
