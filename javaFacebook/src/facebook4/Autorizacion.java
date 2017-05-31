package facebook4;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Autorizacion {

    static String mensaje;
    static Facebook facebook;

    
    public static void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1831926960362970")
                .setOAuthAppSecret("c1ab6ff1853ca7d4d16d4ff69755198d")
                .setOAuthAccessToken("EAAaCILu6FdoBACRUwGwoB6ZCPPLqqdZB65qakKrGZCVeekhWHa3gjHw0p5ewkjIq3YLZAriwkgFodsjvTTgSZBY6Ev68ZAITAg9AaTvRGgn7rtJdvejiK2OyXF19KVUW2GbKMUJS368sV1IHYZB5dAfCd0arUnZA6fEJh51e8HC8hofkKNQBYLUkpfnz977ank4ZD")
                .setOAuthPermissions("email,publish_actions");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();

    }

   
    public static void postearMensaje(String mensaje) {

        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   
    public static void buscarPost() throws FacebookException {
        ResponseList<Post> results = facebook.getPosts(JOptionPane.showInputDialog(null, "busca los post"));

        System.out.println(results.toString());
    }

    public static void buscarFeed() throws FacebookException {
        ResponseList<Post> noticia = facebook.getFeed(JOptionPane.showInputDialog("busca noticias"));
        System.out.println(noticia.toString());
    }

  
    public static void comentario() throws FacebookException {
        facebook.commentPhoto(JOptionPane.showInputDialog("foto id "), JOptionPane.showInputDialog("coments"));
    }

   
    public static void postPhoto() throws MalformedURLException, FacebookException {

        PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
                .picture(new URL("http://facebook4j.org/images/hero.png"))
                .name("Facebook4J - A Java library for the Facebook Graph API")
                .caption("facebook4j.org")
                .description("Facebook4J is a Java library for the Facebook Graph API.");
        facebook.postFeed(post);

    }

}
