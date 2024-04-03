package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookGUI extends JFrame {
    private JPanel addBookPanel;
    private JLabel title;
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JTextField bookPublishingField;
    private JTextField bookISBNField;
    private JTextField bookQuantityField;
    private JButton btnAddBookToBD;
    private JLabel bookTitle;
    private JLabel bookAuthor;
    private JLabel bookPublishing;
    private JLabel bookISBN;
    private JLabel bookQuantity;
    private LibraryGUI libraryGUI;

    public AddBookGUI(LibraryGUI libraryGUI) {

        btnAddBookToBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libraryGUI.addBookToDB(AddBookGUI.this);
                bookTitleField.setText("");
                bookAuthorField.setText("");
                bookPublishingField.setText("");
                bookISBNField.setText("");
                bookQuantityField.setText("");
                bookTitleField.requestFocus();
                libraryGUI.table_load();
            }
        });
    }

    public JPanel getPanelAddBook() {
        return addBookPanel;
    }

    public JTextField getBookTitleField() {
        return bookTitleField;
    }

    public JTextField getBookAuthorField() {
        return bookAuthorField;
    }

    public JTextField getBookPublishingField() {
        return bookPublishingField;
    }

    public JTextField getBookISBNField() {
        return bookISBNField;
    }

    public JTextField getBookQuantityField() {
        return bookQuantityField;
    }

    public void setBookTitleField(JTextField bookTitleField) {
        this.bookTitleField = bookTitleField;
    }

    public void setBookAuthorField(JTextField bookAuthorField) {
        this.bookAuthorField = bookAuthorField;
    }

    public void setBookPublishingField(JTextField bookPublishingField) {
        this.bookPublishingField = bookPublishingField;
    }

    public void setBookISBNField(JTextField bookISBNField) {
        this.bookISBNField = bookISBNField;
    }

    public void setBookQuantityField(JTextField bookQuantityField) {
        this.bookQuantityField = bookQuantityField;
    }
}
