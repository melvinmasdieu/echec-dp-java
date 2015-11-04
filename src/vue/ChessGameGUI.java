package vue;

import controler.controlerLocal.ChessGameControler;
import model.ChessGame;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import tools.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {

    private JLayeredPane layeredPane;
    private JPanel chessBoard;
    private JLabel chessPiece;
    private int indexStartMove;
    private int xAdjustment;
    private int yAdjustment;
    private ChessGameControler chessGameControler;

    public ChessGameGUI(ChessGameControler chessGameControler) {
        this.chessGameControler = chessGameControler;
        Dimension boardSize = new Dimension(600, 600);

        // Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        // Add a chess board to the Layered Pane

        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? Color.black : Color.white);
            else
                square.setBackground(i % 2 == 0 ? Color.white : Color.black);
        }

    }

    @Override
    public void update(Observable arg0, Object arg1) {
        ChessGame chessGame = (ChessGame) arg0;
        for (int i = 0; i < 64; i++) {
            JPanel panel = (JPanel) chessBoard.getComponent(i);
            //panel.removeAll();
        }
        List<PieceIHM> list = chessGame.getPiecesIHM();
        for (PieceIHM pieceIHM : list) {
            String type = pieceIHM.getTypePiece();
            Couleur couleur = pieceIHM.getCouleur();
            for (Coord coord : pieceIHM.getList()) {
                JLabel piece = new JLabel(new ImageIcon(ChessImageProvider.getImageFile(type, couleur)));
                JPanel panel = (JPanel) chessBoard.getComponent((8 * coord.y) + coord.x);
                panel.removeAll();
                panel.add(piece);
            }
        }
        chessBoard.revalidate();
        chessBoard.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null)
            return;
        chessPiece
                .setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Component c = chessBoard.findComponentAt(e.getX(), e.getY());
        indexStartMove = getComponentId(c);

        if (c instanceof JPanel)
            return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel) c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (chessPiece == null)
            return;

        Component c = chessBoard.findComponentAt(e.getX(), e.getY());
        int id = getComponentId(c);

        int xInit = indexStartMove % 8;
        int yInit = (indexStartMove - xInit) / 8;

        int xFinal = id % 8;
        int yFinal = (id - xFinal)/8;

        this.chessGameControler.move(new Coord(xInit, yInit), new Coord(xFinal, yFinal));

        chessPiece.setVisible(false);
    }

    public int getComponentId(Component c) {

        for (int i = 0; i < chessBoard.getComponentCount(); i++) {

            if (chessBoard.getComponent(i) == c.getParent() || chessBoard.getComponent(i) == c)
                return i;
        }

        return -1;
    }


}
