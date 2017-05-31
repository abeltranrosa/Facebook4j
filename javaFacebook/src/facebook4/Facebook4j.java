package facebook4;

import facebook4j.FacebookException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

public class Facebook4j {

   
    public static void main(String[] args) throws FacebookException, MalformedURLException {

        int select;
        do {
            Autorizacion.autorizar();
            select = Integer.parseInt(JOptionPane.showInputDialog("Selecciona "
                    + "\n 1.poner un post \n 2.buscar un post \n 3. Mostrar imagen \n 4.comenta una foto \n 5. postea una foto \n 0.Salir"));
            switch (select) {
                case 1:
                    Autorizacion.postearMensaje(JOptionPane.showInputDialog("contenido del mensaje "));
                    break;
                case 2:
                    Autorizacion.buscarPost();
                    break;
                case 3:
                    Autorizacion.buscarFeed();
                    break;
                case 4:
                    Autorizacion.comentario();
                    break;
                case 5:
                    Autorizacion.postPhoto();
                    break;

            }
        } while (select != 0);

    }

}
