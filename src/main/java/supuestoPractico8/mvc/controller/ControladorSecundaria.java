package supuestoPractico8.mvc.controller;

import supuestoPractico8.mvc.view.Secundaria;

import javax.swing.*;

public class ControladorSecundaria {
    private Secundaria vS;
    public ControladorSecundaria(Secundaria vS){
        this.vS = vS;

        vS.setContentPane(vS.getPanel1());
        vS.setVisible(true);
    }
}
