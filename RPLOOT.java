
package RPLOOT;




import org.jhotdraw.draw.tool.SelectionTool;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.tool.DnDTracker;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.jhotdraw.draw.io.ImageOutputFormat;
import java.awt.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.util.*;
import java.util.Collections;
import java.util.LinkedList;
import org.jhotdraw.draw.tool.DelegationSelectionTool;


public class RPLOOT {
    
     public final static java.util.List<ColorIcon> DEFAULT_COLORS;
     //List warna yang akan ditampilkan dalam iconcolor
    static {
        LinkedList<ColorIcon> m = new LinkedList<ColorIcon>();
        m.add(new ColorIcon(0x800000, "Cayenne"));
        m.add(new ColorIcon(0x808000, "Asparagus"));
        m.add(new ColorIcon(0x008000, "Clover"));
        m.add(new ColorIcon(0x008080, "Teal"));
        m.add(new ColorIcon(0x000080, "Midnight"));
        m.add(new ColorIcon(0x800080, "Plum"));
        m.add(new ColorIcon(0x7f7f7f, "Tin"));
        m.add(new ColorIcon(0x808080, "Nickel"));
        m.add(new ColorIcon(0xff0000, "Maraschino"));
        m.add(new ColorIcon(0xffff00, "Lemon"));
        m.add(new ColorIcon(0x00ff00, "Spring"));
        m.add(new ColorIcon(0x00ffff, "Turquoise"));
        m.add(new ColorIcon(0x0000ff, "Blueberry"));
        m.add(new ColorIcon(0xff00ff, "Magenta"));
        m.add(new ColorIcon(0x666666, "Steel"));
        m.add(new ColorIcon(0x999999, "Aluminium"));
        m.add(new ColorIcon(0xff6666, "Salmon"));
        m.add(new ColorIcon(0xffff66, "Banana"));
        m.add(new ColorIcon(0x66ff66, "Flora"));
        m.add(new ColorIcon(0x66ffff, "Ice"));
        m.add(new ColorIcon(0x6666ff, "Orchid"));
        m.add(new ColorIcon(0xff66ff, "Bubblegum"));
        m.add(new ColorIcon(0x4c4c4c, "Iron"));
        m.add(new ColorIcon(0xb3b3b3, "Magnesium"));
        m.add(new ColorIcon(0x804000, "Mocha"));
        m.add(new ColorIcon(0x408000, "Fern"));
        m.add(new ColorIcon(0x008040, "Moss"));
        m.add(new ColorIcon(0x004080, "Ocean"));
        m.add(new ColorIcon(0x400080, "Eggplant"));
        m.add(new ColorIcon(0x800040, "Maroon"));
        m.add(new ColorIcon(0x333333, "Tungsten"));
        m.add(new ColorIcon(0xcccccc, "Silver"));
        m.add(new ColorIcon(0xff8000, "Tangerine"));
        m.add(new ColorIcon(0x80ff00, "Lime"));
        m.add(new ColorIcon(0x00ff80, "Sea Foam"));
        m.add(new ColorIcon(0x0080ff, "Aqua"));
        m.add(new ColorIcon(0x8000ff, "Grape"));
        m.add(new ColorIcon(0xff0080, "Strawberry"));
        m.add(new ColorIcon(0x191919, "Lead"));
        m.add(new ColorIcon(0xe6e6e6, "Mercury"));
        m.add(new ColorIcon(0xffcc66, "Cantaloupe"));
        m.add(new ColorIcon(0xccff66, "Honeydew"));
        m.add(new ColorIcon(0x66ffcc, "Spindrift"));
        m.add(new ColorIcon(0x66ccff, "Sky"));
        m.add(new ColorIcon(0xcc66ff, "Lavender"));
        m.add(new ColorIcon(0xff6fcf, "Carnation"));
        m.add(new ColorIcon(0x000000, "Licorice"));
        m.add(new ColorIcon(0xffffff, "Snow"));
        DEFAULT_COLORS = Collections.unmodifiableList(m);
    }
         
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                DrawingView view1 = new DefaultDrawingView();//membuat drawing view
                TextAreaFigure ta = new TextAreaFigure();
                
                DrawingEditor editor = new DefaultDrawingEditor();//membuat editor dasar
                editor.add(view1);
                editor.setTool(new DelegationSelectionTool());
                
                view1.setDrawing(createDrawing());
                
                JToolBar tb = new JToolBar();//membuat toolbar
                
                SelectionTool selectionTool1 = new SelectionTool();
                
                selectionTool1.setDragTracker(new DnDTracker());

                ButtonFactory.addSelectionToolTo(tb, editor, selectionTool1);
                
                // membuat selectiontool dan menambahkan ke toolbar        
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure()),
                        "edit.createRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);
                
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new EllipseFigure()),
                        "edit.createEllipse",
                        labels);
                
                 ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TextAreaFigure()),
                        "edit.createTextArea",
                        labels);
                 
                  ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new DiamondFigure()),
                        "edit.createDiamond",
                        labels);
                
                  ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new TriangleFigure()),
                        "edit.createTriangle",
                        labels);
                  
                  ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new LineConnectionFigure()),
                        "edit.createLineConnection",
                        labels);
                  
                  ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(ta),
                        "edit.createTextArea",
                        labels);
                  
                  ButtonFactory.addColorButtonsTo(tb, editor, DEFAULT_COLORS, 12);

                // Masukan semua ke dalam 1 frame
                JFrame f = new JFrame("Main - Main Program");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(700, 700);
                JPanel innerPane = new JPanel();
                innerPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));//set content
                JScrollPane sp;
                innerPane.add(sp = new JScrollPane(view1.getComponent()));
                sp.setPreferredSize(new Dimension(600, 600));//set size dari main window
                f.getContentPane().add(new JScrollPane(innerPane));
                f.getContentPane().add(tb, BorderLayout.WEST);//set toolbar di sebelah kiri layar
                f.setVisible(true);
            }
        });
    }


    private static Drawing createDrawing() {
        // membuat default drawing
        // dengan input/outputdasar
         
        DefaultDrawing drawing = new DefaultDrawing();
        drawing.addInputFormat(new SerializationInputOutputFormat());//add input
        drawing.addOutputFormat(new SerializationInputOutputFormat());//add output
        drawing.addOutputFormat(new ImageOutputFormat());
        return drawing;
    }
}
