import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame{
    private JTable tabulka;

    private JPanel panel;
    private List<Zak> listZaku = new ArrayList<>();
    public Gui(){

        setContentPane(panel);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Projekt");
        listZaku.add(new Zak("Karel", 0, 1));
        listZaku.add(new Zak("Viktor", 1, 5));
        tabulka.setModel(new Tabulka());
        System.out.println(prumer());

    }

   public int scitani(){
        int soucet =0;
        for (Zak zak : listZaku){
            soucet = zak.getVek() + soucet;
        }
        return soucet;
   }
   public int prumer(){
        int prumer = 0;
       for (Zak zak : listZaku){
           prumer = scitani() / listZaku.size();
       }
       return prumer;
   }




   public class Tabulka extends AbstractTableModel{

       @Override
       public int getRowCount() {
           return listZaku.size();
       }

       @Override
       public int getColumnCount() {
           return 3;
       }

       @Override
       public Object getValueAt(int rowIndex, int columnIndex) {
           Zak currentZak = listZaku.get(rowIndex);
           return switch(columnIndex){
               case 0 -> currentZak.getName();
               case 1 -> currentZak.getId();
               case 2 -> currentZak.getVek();
               default -> null;
           };
       }
   }

    public static void main(String[] args) {
        Gui g = new Gui();
        g.setVisible(true);

    }
}
