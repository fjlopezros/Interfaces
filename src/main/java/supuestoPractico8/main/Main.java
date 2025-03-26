package supuestoPractico8.main;

import supuestoPractico8.mvc.view.Principal;
import supuestoPractico8.mvc.controller.ControladorPrincipal;

public class Main {
    public static void main(String[] args) {
        new ControladorPrincipal(new Principal());
    }
}
