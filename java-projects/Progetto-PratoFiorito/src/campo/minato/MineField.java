
package campo.minato;

import java.awt.*;
import javax.swing.*;

public class MineField extends JFrame{
    public int MINE=10;
    public int X_MAX=8;
    public int Y_MAX=8;
    JFrame frame;
    JPanel p1,p2;
    JLabel[][] caselle;
    JButton start;
    
    public MineField(){
        frame=new JFrame("Campo Minato");
        
        p1=new JPanel();
        start=new JButton("Start");
        p1.setLayout(new FlowLayout());
        p1.add(start);
        frame.add(p1, BorderLayout.NORTH);
        
        p2=new JPanel();
        caselle=new JLabel[Y_MAX][X_MAX];
        p2.setLayout(new GridLayout(Y_MAX,X_MAX));
        int count=1;
        for(int i=0;i<Y_MAX;i++){
            for (int j=0;j<X_MAX;j++){
                caselle[i][j]=new JLabel();
                caselle[i][j].setText(Integer.toString(count));
                count++;
                p2.add(caselle[i][j]);
            }
        }
        frame.add(p2);
        
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
