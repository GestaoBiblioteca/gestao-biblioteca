package src.view;

import net.proteanit.sql.DbUtils;
import src.controller.LibraryDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LibraryGUI extends JFrame {
    private JPanel panelMain;
    private JLabel greetingMessage;
    private JTable bookList;
    private JButton btnSearchBook;
    private JButton btnAddBook;
    private JButton btnBorrowBook;
    private JButton btnReturnBook;
    private JScrollPane bookListScrollPane;
    private JTextField searchBookField;
    private JTextField deleteBookField;
    private JButton btnDeleteBook;
    private JTextField returnBookField;
    private JTextField borrowBookField;
    private DefaultTableModel model;
    Connection con;
    PreparedStatement pst;


    public JPanel getPanelMain() {
        return panelMain;
    }

    public JTable getTable() {
        return bookList;
    }

    LibraryDatabase libraryDB = new LibraryDatabase();


    public LibraryGUI() {
        connect();
        table_load();

        btnAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookGUI AddBookFrame = new AddBookGUI(LibraryGUI.this);
                AddBookFrame.setContentPane(AddBookFrame.getPanelAddBook());
                AddBookFrame.setTitle("Adicionar Livro");
                AddBookFrame.setVisible(true);
                AddBookFrame.setSize(800, 600);
                AddBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        btnSearchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String searchBookId = searchBookField.getText();

                    pst = con.prepareStatement("SELECT title,author,publisher,isbn,quantity FROM book WHERE id = ? OR title = ? OR author = ?");
                    pst.setString(1, searchBookId);
                    pst.setString(2, searchBookId);
                    pst.setString(3, searchBookId);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {
                        String title = rs.getString(1);
                        String author = rs.getString(2);
                        String publisher = rs.getString(3);
                        String isbn = rs.getString(4);
                        int quantity = rs.getInt(5);

                        BookInfoFrame bookInfoFrame = new BookInfoFrame();
                        bookInfoFrame.setBookInfo(title, author, publisher, isbn, quantity);
                        bookInfoFrame.setVisible(true);
                        searchBookField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "O livro não existe");
                        searchBookField.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnDeleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleteBookValue = deleteBookField.getText();

                try {
                    if (deleteBookValue.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!");
                        return;
                    }

                    pst = con.prepareStatement("DELETE FROM book WHERE id = ? OR title = ? OR author = ?");

                    pst.setString(1, deleteBookValue);
                    pst.setString(2, deleteBookValue);
                    pst.setString(3, deleteBookValue);

                    int affectedRows = pst.executeUpdate();
                    if (affectedRows == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro corresponde ao valor fornecido!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Livro deletado!");
                    }

                    table_load();
                    deleteBookField.setText("");
                    deleteBookField.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnBorrowBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String borrowBookValue = borrowBookField.getText();

                try {
                    if (borrowBookValue.matches("\\d+")) {
                        pst = con.prepareStatement("UPDATE book SET quantity = quantity - 1 WHERE id = ? AND quantity > 0");
                        pst.setString(1, borrowBookValue);
                    } else {
                        pst = con.prepareStatement("UPDATE book SET quantity = quantity - 1 WHERE (title = ? OR author = ?) AND quantity > 0");
                        pst.setString(1, borrowBookValue);
                        pst.setString(2, borrowBookValue);
                    }

                    int affectedRows = pst.executeUpdate();

                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(null, "Livro emprestado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "O livro não está disponível para empréstimo");
                    }

                    table_load();
                    borrowBookField.setText("");
                    borrowBookField.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        btnReturnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String returnBookValue = returnBookField.getText();

                try {
                    if (returnBookValue.matches("\\d+")) {
                        pst = con.prepareStatement("UPDATE book SET quantity = quantity + 1 WHERE id = ?");
                        pst.setString(1, returnBookValue);
                    } else {
                        pst = con.prepareStatement("UPDATE book SET quantity = quantity + 1 WHERE title = ? OR author = ?");
                        pst.setString(1, returnBookValue);
                        pst.setString(2, returnBookValue);
                    }

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Livro devolvido!");
                    table_load();
                    returnBookField.setText("");
                    returnBookField.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb", "root", "");
            System.out.println("Success");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void table_load() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    pst = con.prepareStatement("select * from book");
                    ResultSet rs = pst.executeQuery();
                    bookList.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done() {
                DefaultTableModel tableModel = (DefaultTableModel) bookList.getModel();
                tableModel.fireTableDataChanged();
            }
        };
        worker.execute();
    }


    public void addBookToDB(AddBookGUI AddBookFrame) {
        String title = AddBookFrame.getBookTitleField().getText();
        String author = AddBookFrame.getBookAuthorField().getText();
        String publisher = AddBookFrame.getBookPublishingField().getText();
        String isbn = AddBookFrame.getBookISBNField().getText();
        String qttStockStr = AddBookFrame.getBookQuantityField().getText();
        int qttStock = 0;
        if (!qttStockStr.isEmpty()) {
            qttStock = Integer.parseInt(qttStockStr);
        }

        try {
            pst = con.prepareStatement("insert into book(title,author,publisher,isbn,quantity)values(?,?,?,?,?)");
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, publisher);
            pst.setString(4, isbn);
            pst.setInt(5, qttStock);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro adicionado!");
            table_load();
        } catch (SQLException e1) {

            e1.printStackTrace();
        }
    }
}