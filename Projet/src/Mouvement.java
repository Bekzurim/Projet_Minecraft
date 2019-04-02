import java.io.File;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Mouvement extends Application {
	
	Point2D offset;
	Node selected;
	Point2D translateStart;
	
  @Override public void start(final Stage stage) throws Exception {
	//Les bases
	  ImageView decor = new ImageView(new File("fond.png").toURI().toString());
	  ImageView craft = new ImageView(new File("fond_craft.png").toURI().toString());
	  ImageView bouton_supprimer = new ImageView(new File("delete.png").toURI().toString());
	  ImageView Dossier = new ImageView(new File("Dossier.png").toURI().toString());
	  
	  ImageView dirt = new ImageView(new File("Base/Dirt.png").toURI().toString());
	  ImageView wood = new ImageView(new File("Base/bois.png").toURI().toString());
	  ImageView rock = new ImageView(new File("Base/rock.png").toURI().toString());
	  ImageView sand = new ImageView(new File("Base/sand.png").toURI().toString());
	  ImageView wind = new ImageView(new File("Base/wind.png").toURI().toString());
	  ImageView fire2 = new ImageView(new File("Base/fire_2.png").toURI().toString());
	  ImageView stick = new ImageView(new File("Base/stick.png").toURI().toString());
	  ImageView bone = new ImageView(new File("Base/bone.png").toURI().toString());
	  ImageView water = new ImageView(new File("Base/water.png").toURI().toString());
	  ImageView glass = new ImageView(new File("Base/glass.png").toURI().toString());
	  ImageView glaçon = new ImageView(new File("Base/glaçon.png").toURI().toString());
	  ImageView ironNugget = new ImageView(new File("Base/iron_nugget.png").toURI().toString());
	  ImageView ironIngot = new ImageView(new File("Base/iron_ingot.png").toURI().toString());
	  ImageView Poubelle_1 = new ImageView(new File("Base/Poubelle_1.png").toURI().toString());
	  ImageView Poubelle_2 = new ImageView(new File("Base/Poubelle_2.png").toURI().toString());
	  
	  rock.setId(String.valueOf(3));
	  
	  //La vie
	  ImageView Sans = new ImageView(new File("Life/Sans.png").toURI().toString());
	  ImageView life = new ImageView(new File("Life/life.png").toURI().toString());
	  ImageView fish = new ImageView(new File("Life/fish.png").toURI().toString());
	  ImageView bird = new ImageView(new File("Life/bird.png").toURI().toString());
	  ImageView egg = new ImageView(new File("Life/egg.png").toURI().toString());
	  life.setId(String.valueOf(20));
	  
	  //Les armes
	  ImageView ak = new ImageView(new File("Weapon/ak.png").toURI().toString());
	  ImageView axe = new ImageView(new File("Weapon/axe.png").toURI().toString());
	  ImageView backpack = new ImageView(new File("Weapon/backpack.png").toURI().toString());
	  ImageView baseball_bat = new ImageView(new File("Weapon/baseball_bat.png").toURI().toString());
	  ImageView battle_axe = new ImageView(new File("Weapon/battle_axe.png").toURI().toString());
	  ImageView battle_hammer = new ImageView(new File("Weapon/battle_hammer.png").toURI().toString());
	  ImageView bouclier = new ImageView(new File("Weapon/bouclier.png").toURI().toString());
	  ImageView bouteille_alcool = new ImageView(new File("Weapon/bouteille_alcool.png").toURI().toString());
	  ImageView bow = new ImageView(new File("Weapon/bow.png").toURI().toString());
	  ImageView bow_arrow = new ImageView(new File("Weapon/bow-arrow.png").toURI().toString());
	  ImageView butcher_knife = new ImageView(new File("Weapon/butcher_knife.png").toURI().toString());
	  ImageView chainsaw = new ImageView(new File("Weapon/chainsaw.png").toURI().toString());
	  ImageView crossbow = new ImageView(new File("Weapon/crossbow.png").toURI().toString());
	  ImageView crossbow_arrow = new ImageView(new File("Weapon/crossbow_arrow.png").toURI().toString());
	  ImageView dague = new ImageView(new File("Weapon/dague.png").toURI().toString());
	  ImageView double_spear = new ImageView(new File("Weapon/double_spear.png").toURI().toString());
	  ImageView Epee_classique = new ImageView(new File("Weapon/Epee_classique.png").toURI().toString());
	  ImageView gas_mask = new ImageView(new File("Weapon/gas_mask.png").toURI().toString());
	  ImageView grenade = new ImageView(new File("Weapon/grenade.png").toURI().toString());
	  ImageView grenade_laucher = new ImageView(new File("Weapon/grenade_laucher.png").toURI().toString());
	  ImageView guandao = new ImageView(new File("Weapon/guandao.png").toURI().toString());
	  ImageView hunter_knife = new ImageView(new File("Weapon/hunter_knife.png").toURI().toString());
	  ImageView katana = new ImageView(new File("Weapon/katana.png").toURI().toString());
	  ImageView Katana1 = new ImageView(new File("Weapon/Katana1.png").toURI().toString());
	  ImageView kunai = new ImageView(new File("Weapon/kunai.png").toURI().toString());
	  ImageView lance = new ImageView(new File("Weapon/lance.png").toURI().toString());
	  ImageView lightsaber = new ImageView(new File("Weapon/lightsaber.png").toURI().toString());
	  ImageView medkiy = new ImageView(new File("Weapon/medkiy.png").toURI().toString());
	  ImageView military_knife = new ImageView(new File("Weapon/military_knife.png").toURI().toString());
	  ImageView minigun = new ImageView(new File("Weapon/minigun.png").toURI().toString());
	  ImageView molotov_cocktail = new ImageView(new File("Weapon/molotov_cocktail.png").toURI().toString());
	  ImageView pistol = new ImageView(new File("Weapon/pistol.png").toURI().toString());
	  ImageView pistol_ammo = new ImageView(new File("Weapon/pistol_ammo.png").toURI().toString());
	  ImageView revolver = new ImageView(new File("Weapon/revolver.png").toURI().toString());
	  ImageView rocket = new ImageView(new File("Weapon/rocket.png").toURI().toString());
	  ImageView rocket_launcher = new ImageView(new File("Weapon/rocket_launcher.png").toURI().toString());
	  ImageView scythe = new ImageView(new File("Weapon/scythe.png").toURI().toString());
	  ImageView shotgun = new ImageView(new File("Weapon/shotgun.png").toURI().toString());
	  ImageView shuriken = new ImageView(new File("Weapon/shuriken.png").toURI().toString());
	  ImageView smoke_grenade = new ImageView(new File("Weapon/smoke_grenade.png").toURI().toString());
	  ImageView sniper = new ImageView(new File("Weapon/sniper.png").toURI().toString());
	  ImageView tanto1 = new ImageView(new File("Weapon/tanto1.png").toURI().toString());
	  ImageView throwing_knife = new ImageView(new File("Weapon/throwing_knife.png").toURI().toString());
	  ImageView thunder = new ImageView(new File("Weapon/thunder.png").toURI().toString());
	  
	  //La bouffe


	ToolBar toolBar = new ToolBar(
   	     new Button("Base"),
   	     new Button("Food"),
   	     new Button("Life"),
   	     new Button("Weapon")
   	 );
	toolBar.setStyle("-fx-background-color: rgba(0, 100, 100, 0.0);");
	toolBar.setTranslateY(100);

    StackPane root = new StackPane();
    root.getChildren().addAll(Sans,bone,Poubelle_1,Poubelle_2,life,dirt,sand,water,wood,stick,rock,fire2,wind,egg,fish,glass,bird,axe,ironNugget);
    root.setStyle("-fx-background-color: rgba(0, 100, 100, 0.0);");

    final StackPane layout = new StackPane();
    layout.getChildren().addAll(decor, craft, root,bouton_supprimer,Dossier,toolBar);
    root.setStyle("-fx-background-color: rgba(0, 100, 100, 0.0);");
    
    craft.setTranslateX(-60);
    craft.setTranslateY(-85);
    bouton_supprimer.setTranslateX(80);
    bouton_supprimer.setTranslateY(20);
    Dossier.setTranslateX(300);
    Dossier.setTranslateY(-185);
    
    
    stage.setScene(new Scene(layout));
    stage.show();
    
    int[][] matrice = new int[3][3];
    
    root.setOnMousePressed(e -> {
        Node target = (Node) e.getTarget();
        if (target != root) {
            // event occured on a child
            selected = target;
            offset = new Point2D(e.getX(), e.getY());
            translateStart = new Point2D(selected.getTranslateX(), selected.getTranslateY());
        } else {
            selected = null;
        }
        e.consume();
    });

    root.setOnMouseDragged(evt -> {
        if (selected != null) {
            selected.setTranslateX(evt.getX() - offset.getX() + translateStart.getX());
            selected.setTranslateY(evt.getY() - offset.getY() + translateStart.getY());
            ((ImageView) evt.getTarget()).setFitHeight(40);
            ((ImageView) evt.getTarget()).setFitWidth(40);
            
        }
        evt.consume();
    });
    
    root.setOnMouseReleased(evt -> {
        if (selected != null) {
        	if(140<evt.getX() && evt.getX()<206 && 90<evt.getY() && evt.getY()<156) {
        		selected.setTranslateX(-180);
                selected.setTranslateY(-130);
                if (selected.getId() != null) {
                	matrice[0][0] = Integer.valueOf(selected.getId());}
                System.out.println(matrice[0][0]);
        	}
        	
        	else if(206<=evt.getX() && evt.getX()<255 && 90<evt.getY() && evt.getY()<156) {
        		selected.setTranslateX(-130);
                selected.setTranslateY(-130);
                if (selected.getId() != null) {
                	matrice[0][1] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(255<=evt.getX() && evt.getX()<304 && 90<evt.getY() && evt.getY()<156) {
        		selected.setTranslateX(-80);
                selected.setTranslateY(-130);
                if (selected.getId() != null) {
                	matrice[0][2] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(140<evt.getX() && evt.getX()<206 && 156<=evt.getY() && evt.getY()<207) {
        		selected.setTranslateX(-180);
                selected.setTranslateY(-80);
                if (selected.getId() != null) {
                	matrice[1][0] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(206<=evt.getX() && evt.getX()<255 && 156<=evt.getY() && evt.getY()<207) {
        		selected.setTranslateX(-130);
                selected.setTranslateY(-80);
                if (selected.getId() != null) {
                	matrice[1][1] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(255<=evt.getX() && evt.getX()<304 && 156<=evt.getY() && evt.getY()<207) {
        		selected.setTranslateX(-80);
                selected.setTranslateY(-80);
                if (selected.getId() != null) {
                	matrice[1][2] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(140<evt.getX() && evt.getX()<206 && 207<=evt.getY() && evt.getY()<258) {
        		selected.setTranslateX(-180);
                selected.setTranslateY(-30);
                if (selected.getId() != null) {
                	matrice[2][0] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(206<=evt.getX() && evt.getX()<255 && 207<=evt.getY() && evt.getY()<258) {
        		selected.setTranslateX(-130);
                selected.setTranslateY(-30);
                if (selected.getId() != null) {
                	matrice[2][1] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(255<=evt.getX() && evt.getX()<304 && 207<=evt.getY() && evt.getY()<258) {
        		selected.setTranslateX(-80);
                selected.setTranslateY(-30);
                if (selected.getId() != null) {
                	matrice[2][2] = Integer.valueOf(selected.getId());}
        	}
        	
        	else {
        		selected.setTranslateX(evt.getX() - offset.getX() + translateStart.getX());
                selected.setTranslateY(evt.getY() - offset.getY() + translateStart.getY());
        		
        	}
        	((ImageView) evt.getTarget()).setFitHeight(30);
            ((ImageView) evt.getTarget()).setFitWidth(30);
            evt.consume();
            
        }	
        
    });

}


  public static void main(String[] args) { launch(args); }
}