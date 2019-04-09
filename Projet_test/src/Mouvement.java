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
	  
	  creationImage dirt = new creationImage("Base/Dirt.png","1");
	  creationImage wood = new creationImage("Base/bois.png","2");
	  creationImage rock = new creationImage("Base/rock.png","3");
	  creationImage sand = new creationImage("Base/sand.png","4");
	  creationImage wind = new creationImage("Base/Dirt.png","5");
	  creationImage fire2 = new creationImage("Base/fire_2.png","6");
	  creationImage stick = new creationImage("Base/stick.png","7");
	  creationImage bone = new creationImage("Base/bone.png","8");
	  creationImage water = new creationImage("Base/water.png","9");
	  creationImage glass = new creationImage("Base/glass.png","10");
	  creationImage glaçon = new creationImage("Base/glaçon.png","11");
	  creationImage ironNugget = new creationImage("Base/iron_nugget.png","12");
	  creationImage ironIngot = new creationImage("Base/iron_ingot.png","13");
	  creationImage Poubelle_1 = new creationImage("Base/Poubelle_1.png","14");
	  creationImage Poubelle_2 = new creationImage("Base/Poubelle_2.png","15");
	  
	  //La vie
	  creationImage Sans = new creationImage("Base/Sans.png","16");
	  creationImage life = new creationImage("Base/life.png","17");
	  creationImage fish = new creationImage("Base/fish.png","18");
	  creationImage bird = new creationImage("Base/bird.png","19");
	  creationImage egg = new creationImage("Base/egg.png","20");
	  
	  //Les armes
	  creationImage ak = new creationImage("Base/ak.png","21");
	  creationImage axe = new creationImage("Base/axe.png","22");
	  creationImage backpack = new creationImage("Base/backpack.png","23");
	  creationImage baseball_bat = new creationImage("Base/baseball_bat.png","24");
	  creationImage battle_axe = new creationImage("Base/battle_axe.png","25");
	  creationImage battle_hammer = new creationImage("Base/battle_hammer.png","26");
	  creationImage bouclier = new creationImage("Base/bouclier.png","27");
	  creationImage bouteille_alcool = new creationImage("Base/bouteille_alcool.png","28");
	  creationImage bow = new creationImage("Base/bow.png","29");
	  creationImage bow_arrow = new creationImage("Weapon/bow-arrow.png","30");
	  creationImage butcher_knife = new creationImage("Base/butcher_knife.png","31");
	  creationImage chainsaw = new creationImage("Base/chainsaw.png","32");
	  creationImage crossbow = new creationImage("Base/crossbow.png","33");
	  creationImage crossbow_arrow = new creationImage("Base/crossbow_arrow.png","34");
	  creationImage dague = new creationImage("Base/dague.png","35");
	  creationImage double_spear = new creationImage("Base/double_spear.png","36");
	  creationImage Epee_classique = new creationImage("Base/Epee_classique.png","37");
	  creationImage gas_mask = new creationImage("Base/gas_mask.png","38");
	  creationImage grenade = new creationImage("Base/grenade.png","39");
	  creationImage grenade_laucher = new creationImage("Base/grenade_laucher.png","40");
	  creationImage guandao = new creationImage("Base/guandao.png","41");
	  creationImage hunter_knife = new creationImage("Base/hunter_knife.png","42");
	  creationImage katana = new creationImage("Base/katana.png","43");
	  creationImage Katana1 = new creationImage("Base/Katana1.png","44");
	  creationImage kunai = new creationImage("Base/kunai.png","45");
	  creationImage lance = new creationImage("Base/lance.png","46");
	  creationImage lightsaber = new creationImage("Base/lightsaber.png","47");
	  creationImage medkiy = new creationImage("Base/medkiy.png","48");
	  creationImage military_knife = new creationImage("Base/military_knife.png","49");
	  creationImage minigun = new creationImage("Base/minigun.png","50");
	  creationImage molotov_cocktail = new creationImage("Base/molotov_cocktail.png","51");
	  creationImage pistol = new creationImage("Base/pistol.png","52");
	  creationImage pistol_ammo = new creationImage("Base/pistol_ammo.png","53");
	  creationImage revolver = new creationImage("Base/revolver.png","54");
	  creationImage rocket = new creationImage("Base/rocket.png","55");
	  creationImage rocket_launcher = new creationImage("Base/rocket_launcher.png","56");
	  creationImage scythe = new creationImage("Base/scythe.png","57");
	  creationImage shotgun = new creationImage("Base/shotgun.png","58");
	  creationImage shuriken = new creationImage("Base/shuriken.png","59");
	  creationImage smoke_grenade = new creationImage("Base/smoke_grenade.png","60");
	  creationImage sniper = new creationImage("Base/sniper.png","61");
	  creationImage tanto1 = new creationImage("Base/tanto1.png","62");
	  creationImage throwing_knife = new creationImage("Base/throwing_knife.png","63");
	  creationImage thunder = new creationImage("Base/thunder.png","64");
	
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
    root.getChildren().addAll(Sans.imageView,bone.imageView,Poubelle_1.imageView,Poubelle_2.imageView,life.imageView,dirt.imageView,sand.imageView,water.imageView,wood.imageView,stick.imageView,rock.imageView,fire2.imageView,wind.imageView,egg.imageView,fish.imageView,glass.imageView,bird.imageView,axe.imageView,ironNugget.imageView);
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