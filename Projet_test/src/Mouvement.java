import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Mouvement extends Application {
	
	Point2D offset;
	Node selected;
	Point2D translateStart;
	double STARTX;
	double STARTY;
	//Map<Integer, Double> dico;
	
  @Override public void start(final Stage stage) throws Exception {

	//Les bases
	  ImageView decor = new ImageView(new File("fond.png").toURI().toString());
	  ImageView craft = new ImageView(new File("fond_craft.png").toURI().toString());
	  //ImageView supprimer = new ImageView(new File("delete.png").toURI().toString());
	  ImageView Dossier = new ImageView(new File("Dossier.png").toURI().toString());
	  ImageView inventaire = new ImageView(new File("inventory.png").toURI().toString());
	  ImageView limite1 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite2 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite3 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite4 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite5 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite6 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite7 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  ImageView limite8 = new ImageView(new File("limitetresnul.png").toURI().toString());
	  
	  creationImage dirt = new creationImage("Base/Dirt.png","1");
	  creationImage wood = new creationImage("Base/bois.png","2");
	  creationImage rock = new creationImage("Base/rock.png","3");
	  creationImage sand = new creationImage("Base/sand.png","4");
	  creationImage wind = new creationImage("Base/wind.png","5");
	  creationImage fire2 = new creationImage("Base/fire_2.png","6");
	  creationImage fire1 = new creationImage("Base/fire_2.png","6");
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
	  creationImage Sans = new creationImage("Life/Sans.png","16");
	  creationImage life = new creationImage("Life/life.png","17");
	  creationImage fish = new creationImage("Life/fish.png","18");
	  creationImage bird = new creationImage("Life/bird.png","19");
	  creationImage egg = new creationImage("Life/egg.png","20");
	  
	  //Les armes
	  creationImage ak = new creationImage("Weapon/ak.png","21");
	  creationImage axe = new creationImage("Weapon/axe.png","22");
	  creationImage backpack = new creationImage("Weapon/backpack.png","23");
	  creationImage baseball_bat = new creationImage("Weapon/baseball_bat.png","24");
	  creationImage battle_axe = new creationImage("Weapon/battle_axe.png","25");
	  creationImage battle_hammer = new creationImage("Weapon/battle_hammer.png","26");
	  creationImage bouclier = new creationImage("Weapon/bouclier.png","27");
	  creationImage bouteille_alcool = new creationImage("Weapon/bouteille_alcool.png","28");
	  creationImage bow = new creationImage("Weapon/bow.png","29");
	  creationImage bow_arrow = new creationImage("Weapon/bow-arrow.png","30");
	  creationImage butcher_knife = new creationImage("Weapon/butcher_knife.png","31");
	  creationImage chainsaw = new creationImage("Weapon/chainsaw.png","32");
	  creationImage crossbow = new creationImage("Weapon/crossbow.png","33");
	  creationImage crossbow_arrow = new creationImage("Weapon/crossbow_arrow.png","34");
	  creationImage dague = new creationImage("Weapon/dague.png","35");
	  creationImage double_spear = new creationImage("Weapon/double_spear.png","36");
	  creationImage Epee_classique = new creationImage("Weapon/Epee_classique.png","37");
	  creationImage gas_mask = new creationImage("Weapon/gas_mask.png","38");
	  creationImage grenade = new creationImage("Weapon/grenade.png","39");
	  creationImage grenade_laucher = new creationImage("Weapon/grenade_laucher.png","40");
	  creationImage guandao = new creationImage("Weapon/guandao.png","41");
	  creationImage hunter_knife = new creationImage("Weapon/hunter_knife.png","42");
	  creationImage katana = new creationImage("Weapon/katana.png","43");
	  creationImage Katana1 = new creationImage("Weapon/Katana1.png","44");
	  creationImage kunai = new creationImage("Weapon/kunai.png","45");
	  creationImage lance = new creationImage("Weapon/lance.png","46");
	  creationImage lightsaber = new creationImage("Weapon/lightsaber.png","47");
	  creationImage medkiy = new creationImage("Weapon/medkiy.png","48");
	  creationImage military_knife = new creationImage("Weapon/military_knife.png","49");
	  creationImage minigun = new creationImage("Weapon/minigun.png","50");
	  creationImage molotov_cocktail = new creationImage("Weapon/molotov_cocktail.png","51");
	  creationImage pistol = new creationImage("Weapon/pistol.png","52");
	  creationImage pistol_ammo = new creationImage("Weapon/pistol_ammo.png","53");
	  creationImage revolver = new creationImage("Weapon/revolver.png","54");
	  creationImage rocket = new creationImage("Weapon/rocket.png","55");
	  creationImage rocket_launcher = new creationImage("Weapon/rocket_launcher.png","56");
	  creationImage scythe = new creationImage("Weapon/scythe.png","57");
	  creationImage shotgun = new creationImage("Weapon/shotgun.png","58");
	  creationImage shuriken = new creationImage("Weapon/shuriken.png","59");
	  creationImage smoke_grenade = new creationImage("Weapon/smoke_grenade.png","60");
	  creationImage sniper = new creationImage("Weapon/sniper.png","61");
	  creationImage tanto1 = new creationImage("Weapon/tanto1.png","62");
	  creationImage throwing_knife = new creationImage("Weapon/throwing_knife.png","63");
	  creationImage thunder = new creationImage("Weapon/thunder.png","64"); 
	  
	  //La bouffe
	  creationImage baguette = new creationImage("Food/baguette.png","65");
	
	//this.dico = new HashMap<>();
	
	Button Bbase = new Button("Base");
    Button Bfood = new Button("Food");
    Button Bweapon = new Button("Weapon");
    Button Blife = new Button("Life");

	Button button = new Button("DELETE");
	button.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00) ");
	
	ToolBar toolBar = new ToolBar();
	toolBar.getItems().add(Bbase);
	toolBar.getItems().add(Bfood);
	toolBar.getItems().add(Blife);
	toolBar.getItems().add(Bweapon);
	
	toolBar.setStyle("-fx-background-color: rgba(0, 100, 100, 0.0);");
	toolBar.setTranslateY(90);
	toolBar.setTranslateX(-5);
	
	Group Base = new Group();
	Group Food = new Group();
	Group Weapon = new Group();
	Group Life = new Group();
	final StackPane layout = new StackPane();
	StackPane all = new StackPane();
	
    Base.getChildren().addAll(limite1,limite2,bone.imageView,Poubelle_1.imageView,Poubelle_2.imageView,dirt.imageView,sand.imageView,water.imageView,wood.imageView,stick.imageView,rock.imageView,fire1.imageView,fire2.imageView,wind.imageView);
    Food.getChildren().addAll(limite3,limite4,baguette.imageView);
    Life.getChildren().addAll(limite7,limite8,life.imageView,Sans.imageView,fish.imageView,bird.imageView,egg.imageView);
    Weapon.getChildren().addAll(limite5,limite6,chainsaw.imageView,axe.imageView);
    
    all.getChildren().add(Base);
    layout.getChildren().addAll(decor,craft,Dossier,inventaire,all,toolBar,button);
    
    for(int i=0; i<Base.getChildren().size()-2; i++){
    		selected = Base.getChildren().get(i+2);
    		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    for(int i=0; i<Food.getChildren().size()-2; i++){
		selected = Food.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    for(int i=0; i<Life.getChildren().size()-2; i++){
		selected = Life.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    for(int i=0; i<Weapon.getChildren().size()-2; i++){
		selected = Weapon.getChildren().get(i+2);
		selected.setTranslateX(-330+(51*Math.round(i/3)));selected.setTranslateY(130+51*(i%3));
    }
    
    limite1.setTranslateX(-1000);limite1.setTranslateY(-1000);
    limite2.setTranslateX(1000);limite2.setTranslateY(1000);
    limite3.setTranslateX(-1000);limite3.setTranslateY(-1000);
    limite4.setTranslateX(1000);limite4.setTranslateY(1000);
    limite5.setTranslateX(-1000);limite5.setTranslateY(-1000);
    limite6.setTranslateX(1000);limite6.setTranslateY(1000);
    limite7.setTranslateX(-1000);limite7.setTranslateY(-1000);
    limite8.setTranslateX(1000);limite8.setTranslateY(1000);
    
    craft.setTranslateX(-55);craft.setTranslateY(-85);
    button.setTranslateX(82);button.setTranslateY(18);
    Dossier.setTranslateX(300);Dossier.setTranslateY(-185);
    inventaire.setTranslateY(179);
    stage.setScene(new Scene(layout,700,500));
    stage.show();
    
    int[][] matrice = new int[3][3];
  
    Bbase.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().add(Base);
            	  
              }
            });
    
    Bfood.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().add(Food);
            	  
            	  
              }
            });
    
    Blife.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().add(Life);
            	  
            	  
              }
            });
    
    Bweapon.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  all.getChildren().clear();
            	  all.getChildren().add(Weapon);
            	  
              }
            });
    
    button.addEventHandler(MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  button.setStyle("-fx-background-color: #ff0000;");
              }
            });
    
    button.addEventHandler(MouseEvent.MOUSE_RELEASED,
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent e) {
            	  button.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00) ");
              }
            });
    
    all.setOnMousePressed(evt -> {
        Node target = (Node) evt.getTarget();
        if (target != all) {
            // event occured on a child
            selected = target;
            /*Group test = (Group) selected.getParent();
            test.getChildren().add(selected);*/
            
            offset = new Point2D(evt.getX(), evt.getY());
            translateStart = new Point2D(selected.getTranslateX(), selected.getTranslateY());
            STARTX = (evt.getX() - offset.getX() + translateStart.getX());
            STARTY = (evt.getY() - offset.getY() + translateStart.getY());
        } else {
            selected = null;
        }
        evt.consume();
    });

    all.setOnMouseDragged(evt -> {
        if (selected != null) {
            selected.setTranslateX(evt.getX() - offset.getX() + translateStart.getX());
            selected.setTranslateY(evt.getY() - offset.getY() + translateStart.getY());
            ((ImageView) evt.getTarget()).setFitHeight(40);
            ((ImageView) evt.getTarget()).setFitWidth(40);
            
        }
        evt.consume();
    });
    
    all.setOnMouseReleased(evt -> {
    	
        if (selected != null) {
        	if(815<evt.getX() && evt.getX()<864 && 860<evt.getY() && evt.getY()<909) {
        		selected.setTranslateX(-175);
                selected.setTranslateY(-130);
                if (selected.getId() != null) {
                	matrice[0][0] = Integer.valueOf(selected.getId());}
                System.out.println(matrice[0][0]);
        	}
        	
        	else if(865<=evt.getX() && evt.getX()<914 && 860<evt.getY() && evt.getY()<909) {
        		selected.setTranslateX(-125);
                selected.setTranslateY(-130);
                if (selected.getId() != null) {
                	matrice[0][1] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(915<=evt.getX() && evt.getX()<964 && 860<evt.getY() && evt.getY()<909) {
        		selected.setTranslateX(-75);
                selected.setTranslateY(-130);
                if (selected.getId() != null) {
                	matrice[0][2] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(815<evt.getX() && evt.getX()<864 && 910<=evt.getY() && evt.getY()<959) {
        		selected.setTranslateX(-175);
                selected.setTranslateY(-80);
                if (selected.getId() != null) {
                	matrice[1][0] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(865<=evt.getX() && evt.getX()<914 && 910<=evt.getY() && evt.getY()<959) {
        		selected.setTranslateX(-125);
                selected.setTranslateY(-80);
                if (selected.getId() != null) {
                	matrice[1][1] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(915<=evt.getX() && evt.getX()<964 && 910<=evt.getY() && evt.getY()<959) {
        		selected.setTranslateX(-75);
                selected.setTranslateY(-80);
                if (selected.getId() != null) {
                	matrice[1][2] = Integer.valueOf(selected.getId());}
                
        	}
        	
        	else if(815<evt.getX() && evt.getX()<864 && 960<=evt.getY() && evt.getY()<1009) {
        		selected.setTranslateX(-175);
                selected.setTranslateY(-30);
                if (selected.getId() != null) {
                	matrice[2][0] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(865<=evt.getX() && evt.getX()<914 && 960<=evt.getY() && evt.getY()<1009) {
        		selected.setTranslateX(-125);
                selected.setTranslateY(-30);
                if (selected.getId() != null) {
                	matrice[2][1] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if(915<=evt.getX() && evt.getX()<964 && 960<=evt.getY() && evt.getY()<1009) {
        		selected.setTranslateX(-75);
                selected.setTranslateY(-30);
                if (selected.getId() != null) {
                	matrice[2][2] = Integer.valueOf(selected.getId());}
        	}
        	
        	else if((evt.getY() - offset.getY() + translateStart.getY())>=100) {
        		double a = (Math.round((evt.getY() - offset.getY() + translateStart.getY()+25)/50)*50-20);
        		double b;
        		selected.setTranslateY(a);
        		if((evt.getX() - offset.getX() + translateStart.getX())>=0) {
            	b = (Math.round((evt.getX() - offset.getX() + translateStart.getX()+25)/50)*50-25+Math.round((evt.getX() - offset.getX() + translateStart.getX())/50)/2);}
            	else {b = (Math.round((evt.getX() - offset.getX() + translateStart.getX()-25)/50)*50+25+Math.round((evt.getX() - offset.getX() + translateStart.getX())/50)/2);}
        		selected.setTranslateX(b);
        		/*this.dico.put(Integer.valueOf(selected.getId()),a*1000+b);
        		for(int i=1; i<16;i++) {
        			if(dico.get(i)!=null) {
        			int getY = Integer.parseInt(Double.toString(dico.get(i)).substring(0, 3));//change substring
        			int getX = Integer.parseInt(Double.toString(dico.get(i)).substring(3, 6));
        			}
        			
        		}*/
        		
        	}
        	else {
        		selected.setTranslateX(STARTX);
        		selected.setTranslateY(STARTY);
        	}
        	((ImageView) evt.getTarget()).setFitHeight(30);
            ((ImageView) evt.getTarget()).setFitWidth(30);
            evt.consume();
            
        }	
        
    });

}


  public static void main(String[] args) { launch(args); }
}
