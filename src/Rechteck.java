
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JPanel;


/**
 *
 * @author ouham
 */
public class Rechteck extends JPanel {

    private int x;
    private int y;
    private int breite;
    private int hoehe;
    private Color background;
    private Figur figur = null;

    public Rechteck(int x, int y, int breite, int hoehe, Color background) throws IOException {

        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;
        this.figur = figur;
        this.background = background;
        fuegeFigurHinzu(x, y);
    }

    public void paint(Graphics g) {

        g.setColor(background);
        g.fillRect(gibX(), gibY(), gibBreite(), gibHoehe());
        if (this.figur != null) {
            g.drawImage(this.figur.gibBild(), gibX(), gibY(), this);
        }
    }

    public int gibX() {
        return this.x;
    }

    public int gibY() {
        return this.y;
    }

    public int gibBreite() {
        return this.breite;
    }

    public int gibHoehe() {
        return this.hoehe;
    }

    public Color gibBackground() {
        return this.background;
    }

    public void setzeX(int x) {
        this.x = x;
    }

    public void setzeY(int y) {
        this.y = y;
    }

    public void setzeBreite(int breite) {
        this.breite = breite;
    }

    public void setzeHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setzeBackground(Color color) {
        this.background = color;
    }

    public Figur gibFigur() {
        return this.figur;
    }

    public void setzeFigur(Figur figur) {
        this.figur = figur;
    }

    private final void fuegeFigurHinzu(int x, int y) throws IOException {

        if (y == 0) {
            switch (x) {
                case 0:
                    this.figur = new Figur(false, "turm");
                    break;
                case 1:
                    this.figur = new Figur(false, "springer");
                    break;
                case 2:
                    this.figur = new Figur(false, "laeufer");
                    break;
                case 3:
                    this.figur = new Figur(false, "dame");
                    break;
                case 4:
                    this.figur = new Figur(false, "koenig");
                    break;
                case 5:
                    this.figur = new Figur(false, "laeufer");
                    break;
                case 6:
                    this.figur = new Figur(false, "springer");
                    break;
                case 7:
                    this.figur = new Figur(false, "turm");
                    break;
            }
        } else if (y == 1) {
            switch (x) {
                case 0:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 1:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 2:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 3:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 4:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 5:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 6:
                    this.figur = new Figur(false, "bauer");
                    break;
                case 7:
                    this.figur = new Figur(false, "bauer");
                    break;
            }
        } else if (y == 6) {
            switch (x) {
                case 0:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 1:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 2:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 3:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 4:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 5:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 6:
                    this.figur = new Figur(true, "bauer");
                    break;
                case 7:
                    this.figur = new Figur(true, "bauer");
                    break;
            }
        } else if (y == 7) {
            switch (x) {
                case 0:
                    this.figur = new Figur(true, "turm");
                    break;
                case 1:
                    this.figur = new Figur(true, "springer");
                    break;
                case 2:
                    this.figur = new Figur(true, "laeufer");
                    break;
                case 3:
                    this.figur = new Figur(true, "dame");
                    break;
                case 4:
                    this.figur = new Figur(true, "koenig");
                    break;
                case 5:
                    this.figur = new Figur(true, "laeufer");
                    break;
                case 6:
                    this.figur = new Figur(true, "springer");
                    break;
                case 7:
                    this.figur = new Figur(true, "turm");
                    break;
            }
        }
    }
}
