import java.io.File;

import javafx.scene.image.ImageView;

public class creationImage {
	String image;
	String id;
	ImageView imageView;
	
	public creationImage(String nomImage, String lid) {
		this.image=nomImage;
		this.id=lid;
		this.imageView = new ImageView(new File(nomImage).toURI().toString());
		this.imageView.setId(String.valueOf(lid));
	}
}