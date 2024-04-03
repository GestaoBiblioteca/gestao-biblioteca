package view;

import javax.swing.*;
import java.awt.*;

public class BookInfoFrame extends JFrame {
    private JLabel titleLabel = new JLabel();
    private JLabel authorLabel = new JLabel();
    private JLabel publisherLabel = new JLabel();
    private JLabel isbnLabel = new JLabel();
    private JLabel quantityLabel = new JLabel();

    public BookInfoFrame() {
        setLayout(new GridLayout(5, 2));
        setSize(400, 300);

        add(new JLabel("Título:"));
        add(titleLabel);
        add(new JLabel("Autor:"));
        add(authorLabel);
        add(new JLabel("Editora:"));
        add(publisherLabel);
        add(new JLabel("ISBN:"));
        add(isbnLabel);
        add(new JLabel("Quantidade:"));
        add(quantityLabel);

        for (Component c : getContentPane().getComponents()) {
            if (c instanceof JLabel) {
                ((JLabel) c).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        }

        pack();
    }

    public void setBookInfo(String title, String author, String publisher, String isbn, int quantity) {
        titleLabel.setText(title);
        authorLabel.setText(author);
        publisherLabel.setText(publisher);
        isbnLabel.setText(isbn);
        quantityLabel.setText(String.valueOf(quantity));
    }
}
