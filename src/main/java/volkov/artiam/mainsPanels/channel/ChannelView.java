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

    JButton btnSetAtt = new JButton("����������");
    JCheckBox chTmAuto = new JCheckBox("�� ����");
    JLabel channelName = new JLabel("����� ����������");

     public ChannelView( ) {
     // ��������� ���������� ������
         setLayout(null);
         setSize(900, 245);
         setBackground(UIManager.getColor("Button.background"));
         setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

     // ����� ������ ����������
         channelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
         channelName.setHorizontalAlignment(SwingConstants.LEFT);
         channelName.setBounds(363, 6, 237, 14);
         add(channelName);

     // ��� ����������
         JLabel lblAttSelect = new JLabel("����������");
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


     // ���������� ����������
         JLabel lblTmAmps = new JLabel("���������� ����������");
         lblTmAmps.setFont(new Font("Tahoma", Font.PLAIN, 12));
         lblTmAmps.setHorizontalAlignment(SwingConstants.CENTER);
         lblTmAmps.setBounds(339, 110, 190, 14);
         add(lblTmAmps);

     // ���������� ����� ������� � �����������
         JLabel lblTmSupply = new JLabel("���������� ������� � �����������");
         lblTmSupply.setFont(new Font("Tahoma", Font.PLAIN, 12));
         lblTmSupply.setHorizontalAlignment(SwingConstants.CENTER);
         lblTmSupply.setBounds(166, 181, 308, 14);
         add(lblTmSupply);

     // ���-���� ��� ��������������� ��������� ����������
         chTmAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
         //chTmAuto.setBounds(680, 181, 70, 25);
         chTmAuto.setBounds(680, 181, 85, 25);
         add(chTmAuto);
     }

}
