package org.milaifontanals.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.KeyStroke.getKeyStroke;
import org.milaifontanals.Main;
import org.milaifontanals.persistencia.CalendarOrganizerException;
import org.milaifontanals.gui.utils.OpenBrowser;
import org.milaifontanals.utils.ReadProperties;

/**
 *
 * @author Gerard Casas
 */
public class Menu {
    
    private JMenuBar menu;
    
    public Menu(Dashboard frame) throws CalendarOrganizerException {
        
        setMenuBar(new JMenuBar());
        
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        
        JMenu generic = new JMenu("Generic");
        generic.setMnemonic(KeyEvent.VK_G);

        JMenuItem helpWeb = new JMenuItem("Help Web");
        helpWeb.setAccelerator(getKeyStroke(KeyEvent.VK_F2, KeyEvent.ALT_DOWN_MASK));
        helpWeb.addActionListener(new OpenBrowser(Main.props.get("web_help_url"), frame));

        JMenuItem website = new JMenuItem("Website");
        website.setAccelerator(getKeyStroke(KeyEvent.VK_F1, KeyEvent.ALT_DOWN_MASK));
        website.addActionListener(new OpenBrowser(Main.props.get("web_url"), frame));
        
        JMenuItem about = new JMenuItem("About", 'A');
        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(frame, 
                    "Name: Gerard Casas Serarols\n"
                    + "Tel: 611451460\n"
                    + "Email: gcasas@milaifontanals.org",
                    "About me", JOptionPane.PLAIN_MESSAGE);
        });
        
        JMenuItem logout = new JMenuItem("Log Out", 'L');
        logout.setAccelerator(getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(GUI.dashboardFrame, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    GUI.dashboardFrame.close();
                    GUI.userLoginFrame.run();
                    return;
                }
            }
        });
        
        generic.add(website);
        generic.add(logout);
        help.add(helpWeb);
        help.add(about);

        menu.add(generic);
        menu.add(help);
    }

    public JMenuBar getMenuBar() {
        return menu;
    }

    public void setMenuBar(JMenuBar menu) {
        this.menu = menu;
    }
}
