package models;

import javax.swing.*;
import java.awt.*;

public class XOButton extends JButton {
    public XOButton() {
        setFont(new Font("Arial", Font.BOLD, 60));
        setFocusPainted(false);
        setBackground(Color.WHITE);
        setOpaque(true);
    }
}