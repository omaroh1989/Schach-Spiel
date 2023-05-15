
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ouham
 */
public class Brett extends JFrame {

    public static final int SCALE = 75;

    private Rechteck[][] rectangle = new Rechteck[8][8];
    private JPanel brett;
    private JFrame frame;
    private JPanel panelBorderNorth;
    private JPanel panelBorderSouth;
    private JPanel panelBorderWest;
    private JPanel panelBorderEast;
    private Figur ausgewaelterFigur;
    private int xFigur;
    private int yFigur;
    private int click = 1;
    private Color altesBackGround;

    public Brett() throws IOException {

        panelBorderNorth = new JPanel();
        panelBorderSouth = new JPanel();
        panelBorderEast = new JPanel();
        panelBorderWest = new JPanel();
        panelBorderNorth.setBackground(new Color(153, 76, 0));
        panelBorderSouth.setBackground(new Color(153, 76, 0));
        panelBorderEast.setBackground(new Color(153, 76, 0));
        panelBorderWest.setBackground(new Color(153, 76, 0));
        panelBorderNorth.setPreferredSize(new Dimension(600, 25));
        panelBorderSouth.setPreferredSize(new Dimension(600, 25));
        panelBorderEast.setPreferredSize(new Dimension(25, 600));
        panelBorderWest.setPreferredSize(new Dimension(25, 600));

        initBrett();
//        brett = new JPanel() {
//            public void paint(Graphics g) {
//                for (int x = 0; x < 8; x++) {
//                    for (int y = 0; y < 8; y++) {
//                        if ((x + y) % 2 == 0) {
//                            g.setColor(new Color(255, 204, 153));
//                        } else {
//                            g.setColor(new Color(204, 102, 0));
//                        }
//                            g.fillRect(x * 75 , y * 75, 75, 75);
//                    }
//                }
//            }
//        };

        brett = new JPanel();
        brett.setBackground(new Color(153, 0, 0));
        GridLayout grid = new GridLayout(8, 8);
        grid.setHgap(-10);
        grid.setVgap(-10);
        brett.setLayout(grid);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                brett.add(rectangle[i][j]);
            }
        }

        frame = new JFrame();
        frame.setSize(SCALE * 8 + 50, SCALE * 8 + 50);
        frame.setTitle("Schachspiel");
        frame.setLayout(new BorderLayout());
        frame.add(panelBorderNorth, BorderLayout.NORTH);
        frame.add(panelBorderSouth, BorderLayout.SOUTH);
        frame.add(brett, BorderLayout.CENTER);
        frame.add(panelBorderEast, BorderLayout.EAST);
        frame.add(panelBorderWest, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setVisible(true);

        brett.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (click == 1) {
                    if (rectangle[e.getY() / SCALE][e.getX() / SCALE].gibFigur() != null) {
                        xFigur = e.getX() / SCALE;
                        yFigur = e.getY() / SCALE;
                        altesBackGround = rectangle[yFigur][xFigur].gibBackground();
                        rectangle[yFigur][xFigur].setzeBackground(new Color(204, 0, 0));
                        ausgewaelterFigur = rectangle[yFigur][xFigur].gibFigur();
                        brett.repaint();
                        click++;
                    }
                } else if (click == 2) {
                    if ((rectangle[e.getY() / SCALE][e.getX() / SCALE].gibFigur() == null)
                            || (rectangle[e.getY() / SCALE][e.getX() / SCALE].gibFigur().istWeiss()
                            != ausgewaelterFigur.istWeiss())) {
                        rectangle[e.getY() / SCALE][e.getX() / SCALE].setzeFigur(ausgewaelterFigur);
                        rectangle[yFigur][xFigur].setzeFigur(null);
                        rectangle[yFigur][xFigur].setzeBackground(altesBackGround);
                        click = 1;
                    } else {
                        rectangle[yFigur][xFigur].setzeBackground(altesBackGround);
                        altesBackGround = rectangle[e.getY() / SCALE][e.getX() / SCALE].gibBackground();
                        rectangle[e.getY() / SCALE][e.getX() / SCALE].setzeBackground(new Color(204, 0, 0));
                        xFigur = e.getX() / SCALE;
                        yFigur = e.getY() / SCALE;
                        ausgewaelterFigur = rectangle[yFigur][xFigur].gibFigur();
                    }
                    brett.repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void initBrett() throws IOException {

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((x + y) % 2 == 0) {
                    rectangle[y][x] = new Rechteck(x, y, SCALE, SCALE, new Color(255, 204, 153));
                } else {
                    rectangle[y][x] = new Rechteck(x, y, SCALE, SCALE, new Color(204, 102, 0));
                }
            }
        }
    }

    private void setzeBrett() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                brett.add(rectangle[i][j]);
            }
        }
    }
}
