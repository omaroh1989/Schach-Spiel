
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author ouham
 */
public class Figur {
    
    private String figurName;
    private boolean istWeiss;
    private Image bild;

    public Figur(boolean istWeiss, String figurName) throws IOException {

        this.figurName = figurName;
        this.istWeiss = istWeiss;
        this.bild = imageFigur(figurName, istWeiss);
    }

    public Image gibBild() {
        return bild;
    }

    public boolean istWeiss() {
        return istWeiss;
    }

    private final static Image imageFigur(String figurName, boolean istWeiss) throws IOException {

        Image img = null;
        
        BufferedImage bilderFiguren = ImageIO.read(new File("D:\\Studium"
                + "\\EPR\\SchachBrett\\src\\FigurBilder\\chess.png"));
        
        Image bilder[] = new Image[12];
        int index = 0;
        
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                bilder[index] = bilderFiguren.getSubimage(x, y, 200, 200)
                        .getScaledInstance(65, 65, BufferedImage.SCALE_SMOOTH);
                index++;
            }
        }
        
        if (istWeiss) {
            switch (figurName) {
                case "bauer":
                    img = bilder[5];
                    break;
                case "turm":
                    img = bilder[4];
                    break;
                case "springer":
                    img = bilder[3];
                    break;
                case "laeufer":
                    img = bilder[2];
                    break;
                case "dame":
                    img = bilder[1];
                    break;
                case "koenig":
                    img = bilder[0];
                    break;
            }
        } else {
            switch (figurName) {
                case "bauer":
                    img = bilder[11];
                    break;
                case "turm":
                    img = bilder[10];
                    break;
                case "springer":
                    img = bilder[9];
                    break;
                case "laeufer":
                    img = bilder[8];
                    break;
                case "dame":
                    img = bilder[7];
                    break;
                case "koenig":
                    img = bilder[6];
                    break;
            }
        }
        
        return img;
    }
}
