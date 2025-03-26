package supuestoPractico8.mvc.controller;

import supuestoPractico8.mvc.view.Principal;
import supuestoPractico8.mvc.view.Secundaria;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class ControladorPrincipal implements ActionListener {
    private Principal vP;
    private Secundaria vS;

    public ControladorPrincipal(Principal vP){
        this.vP = vP;

        vP.getButton1().setActionCommand("secundaria");
        vP.getButton1().addActionListener(this);

        ponLaAyuda();

        vP.setContentPane(vP.getPane());
        vP.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("secundaria")){
            new supuestoPractico8.mvc.controller.ControladorSecundaria(new Secundaria());
            this.vP.dispose();
        }
    }
    private void ponLaAyuda() {
        try {
            // Carga el fichero de ayuda
            File fichero = new File("src/main/java/Interfaces/supuestoPractico8/help/help_set.hs");
            URL hsURL = fichero.toURI().toURL();

            // Crea el HelpSet y el HelpBroker
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();

            // Pone ayuda a item de menu al pulsarlo y a F1 en ventana
            // principal y secundaria.
            hb.enableHelpOnButton(vP.getItemAyuda(), "aplicacion", helpset);
            hb.enableHelpKey(vP.getContentPane(), "ventana_principal",
                    helpset);
            hb.enableHelpKey(vS.getContentPane(), "ventana_secundaria",
                    helpset);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
}
