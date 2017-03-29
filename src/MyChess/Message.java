package MyChess;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Message {
	public static void showInfo(String str, TypeKonOuk typeK,LanguageType lType) {
		Color color = new Color(0, 225, 0);
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel konInfo =new JLabel(str);
		konInfo.setFont(getFont(32, lType));
		userPanel.add(konInfo);
		ImageIcon icon = getMyIcon(typeK);
		UIManager.put("OptionPane.background", color);
		UIManager.put("Panel.background", color);
		UIManager.put("OptionPane.messageFont",getFont(32, lType));		
		userPanel.setBackground(color);
		if(lType==LanguageType.KHMER){
			 
			UIManager.put("OptionPane.okButtonText", "យល់ព្រម");
		}else{
			UIManager.put("OptionPane.okButtonText", "Ok");
		}
		
		JOptionPane.showConfirmDialog(null, userPanel, str,
				JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
		//UIManager.put("OptionPane.noButtonText", "Non");
	    //UIManager.put("OptionPane.okButtonText", "D'accord");
	    //UIManager.put("OptionPane.yesButtonText", "Oui");
	}
	public static int showInfoYesNo(String str, TypeKonOuk typeK,LanguageType lType) {
		Color color = new Color(0, 225, 0);
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel konInfo =new JLabel(str);
		konInfo.setFont(getFont(32, lType));
		userPanel.add(konInfo);
		UIManager.put("OptionPane.background", color);
		UIManager.put("Panel.background", color);
		UIManager.put("OptionPane.messageFont",getFont(32, lType));		
		userPanel.setBackground(color);
		if(lType==LanguageType.KHMER){
			 
			UIManager.put("OptionPane.yesButtonText", "ថ្មី");
			UIManager.put("OptionPane.noButtonText", "ចាកចេញ");
		}else{
			UIManager.put("OptionPane.yesButtonText", "New");
			UIManager.put("OptionPane.noButtonText", "Quit");
		}
		
		return JOptionPane.showConfirmDialog(null, userPanel, str,
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	private static ImageIcon getMyIcon(TypeKonOuk type) {
		return new ImageIcon(type.location);
	}
	private static Font getFont(float size,LanguageType lType){
		Font font;
		try {
			 if(lType==LanguageType.KHMER)font = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/KHMEROSSYS.TTF"));
			 else font = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/ARIAL.TTF"));			
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(lType==LanguageType.KHMER)font=new Font("Khmer OS System", Font.BOLD, (int)size);
			else font=new Font("Arial", Font.BOLD, (int)size);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(lType==LanguageType.KHMER)font=new Font("Khmer OS System", Font.BOLD, (int)size);
			else font=new Font("Arial", Font.BOLD, (int)size);
		}		
		if(lType==LanguageType.KHMER)return font.deriveFont(Font.BOLD,size);
		else return font.deriveFont(Font.BOLD,size);
	}
}
