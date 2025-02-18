package volkov.artiam.mainsPanels.channel;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.mainsPanels.att.Att;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

@Setter @Getter
public class ChannelView extends JPanel {


    Att att = new Att();
    JPanel pnlAtt = att.getPnl();

    JButton btnSetAtt = new JButton("Установить");
    JCheckBox chTmAuto = new JCheckBox("ТМ авто");
    JLabel channelName = new JLabel("Канал управления");

     public ChannelView( ) {
     // Установка параметров панели
         setLayout(null);
         setSize(900, 245);
         setBackground(UIManager.getColor("Button.background"));
         setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

     // Метка канала управления
         channelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
         channelName.setHorizontalAlignment(SwingConstants.LEFT);
         channelName.setBounds(363, 6, 237, 14);
         add(channelName);

     // Для аттенюации
         JLabel lblAttSelect = new JLabel("Аттенюация");
         lblAttSelect.setFont(new Font("Tahoma", Font.PLAIN, 12));
         lblAttSelect.setHorizontalAlignment(SwingConstants.LEFT);
         lblAttSelect.setBounds(685, 66, 97, 14);
         add(lblAttSelect);

         btnSetAtt.setFont(new Font("Tahoma", Font.PLAIN, 12));
         btnSetAtt.setBounds(730, 36, 140, 23);
         add(btnSetAtt);

         pnlAtt.setBounds(750, 65, 100, 170);
         pnlAtt.setBorder(null);
         add(pnlAtt);


     // Телеметрия усилителей
         JLabel lblTmAmps = new JLabel("Телеметрия усилителей");
         lblTmAmps.setFont(new Font("Tahoma", Font.PLAIN, 12));
         lblTmAmps.setHorizontalAlignment(SwingConstants.CENTER);
         lblTmAmps.setBounds(339, 110, 190, 14);
         add(lblTmAmps);

     // Телеметрии цепей питания и температуры
         JLabel lblTmSupply = new JLabel("Телеметрия питания и температуры");
         lblTmSupply.setFont(new Font("Tahoma", Font.PLAIN, 12));
         lblTmSupply.setHorizontalAlignment(SwingConstants.CENTER);
         lblTmSupply.setBounds(166, 181, 308, 14);
         add(lblTmSupply);

     // Чек-бокс для автоматического получения телеметрии
         chTmAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
         //chTmAuto.setBounds(680, 181, 70, 25);
         chTmAuto.setBounds(680, 181, 85, 25);
         add(chTmAuto);
     }

}
