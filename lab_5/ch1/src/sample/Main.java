package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        new Window().setVisible(true);
    }
}



//TODO: new edit text and button; read from file to edit text

class Window extends JFrame {
    private Vector<String> stock = new Vector<>();
    private Vector<String> customer = new Vector<>();

    private JLabel onStockLb = new JLabel("Salon");
    private JLabel customerLb = new JLabel("Customers");
    private JList<String> stockJList = new JList<>(stock);
    private JList<String> customerJList = new JList<>(customer);
    private JButton addBtn = new JButton("+");
    private JButton removeBtn = new JButton("-");
    private JButton saveBtn = new JButton("Save");
    private JCheckBox updateJCheckBox = new JCheckBox("Update");
    private JTextField customerTF = new JTextField("Customer");
    private JTextField timeTF;
    private JTextArea clientAddressTA = new JTextArea("City Street House");

    private JTextArea toReadFromFileTA = new JTextArea();
    private JButton readFromFileBtn = new JButton("Read");


    /*public static void main(String[] args) {
        new Main().setVisible(true);
    }*/

    public Window() {

        super("Some kind of Salon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        timeTF = new JTextField(formatter.format(date));

        initWindow();

        readFromFileBtn.addActionListener(e -> {
            //TODO
            getFromFile().forEach(
                    s -> {
                        toReadFromFileTA.append(s + "\n");
                    });
        });

        removeBtn.addActionListener(e -> {
            customer.remove(customerJList.getSelectedIndex());
            customerJList.setListData(customer);
        });

        addBtn.addActionListener(e -> {
            customer.add(stockJList.getSelectedValue());
            customerJList.setListData(customer);
        });

        updateJCheckBox.addActionListener(e -> {
            if (updateJCheckBox.isSelected()) {
                clientAddressTA.setEnabled(true);
                customerTF.setEnabled(true);
                timeTF.setEnabled(true);
            } else {
                clientAddressTA.setEnabled(false);
                customerTF.setEnabled(false);
                timeTF.setEnabled(false);
            }
        });

        saveBtn.addActionListener(e -> {
            saveOrderToFile();
        });

        getItemsFromStockFile();

    }

    @SuppressWarnings("Duplicates")
    private void initWindow() {
        SpringLayout springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout);

        getContentPane().add(onStockLb);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, onStockLb, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, onStockLb, 10, SpringLayout.NORTH, getContentPane());
        //------------------

        toReadFromFileTA.setPreferredSize(new Dimension(300, 300));
        toReadFromFileTA.setLineWrap(true);
        getContentPane().add(toReadFromFileTA);

       /* springLayout.putConstraint(SpringLayout.WEST, toReadFromFileTA , 50, SpringLayout.EAST, customerTF);
        springLayout.putConstraint(SpringLayout.NORTH, toReadFromFileTA, 20, SpringLayout.SOUTH, updateJCheckBox);*/

        readFromFileBtn.setPreferredSize(new Dimension(50, 20));
        getContentPane().add(readFromFileBtn);
        springLayout.putConstraint(SpringLayout.WEST, readFromFileBtn, 30, SpringLayout.SOUTH, toReadFromFileTA);


        //----------------------

        stockJList.setFixedCellWidth(250);
        getContentPane().add(stockJList);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, stockJList, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, stockJList, 10, SpringLayout.SOUTH, onStockLb);

        getContentPane().add(customerLb);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, customerLb, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, customerLb, 50, SpringLayout.SOUTH, stockJList);

        customerJList.setFixedCellWidth(250);
        getContentPane().add(customerJList);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, customerJList, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, customerJList, 10, SpringLayout.SOUTH, customerLb);

        addBtn.setPreferredSize(new Dimension(50, 20));
        getContentPane().add(addBtn);
        springLayout.putConstraint(SpringLayout.WEST, addBtn, 0, SpringLayout.WEST, customerJList);
        springLayout.putConstraint(SpringLayout.NORTH, addBtn, 0, SpringLayout.SOUTH, customerJList);

        removeBtn.setPreferredSize(new Dimension(50, 20));
        getContentPane().add(removeBtn);
        springLayout.putConstraint(SpringLayout.WEST, removeBtn, 0, SpringLayout.EAST, addBtn);
        springLayout.putConstraint(SpringLayout.NORTH, removeBtn, 0, SpringLayout.SOUTH, customerJList);

        getContentPane().add(updateJCheckBox);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, updateJCheckBox, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, updateJCheckBox, 50, SpringLayout.SOUTH, removeBtn);

        customerTF.setPreferredSize(new Dimension(200, 20));
        customerTF.setEnabled(false);
        getContentPane().add(customerTF);
        springLayout.putConstraint(SpringLayout.WEST, customerTF, 50, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, customerTF, 20, SpringLayout.SOUTH, updateJCheckBox);

        timeTF.setPreferredSize(new Dimension(200,20));
        timeTF.setEnabled(false);
        getContentPane().add(timeTF);
        springLayout.putConstraint(SpringLayout.WEST, timeTF, 50, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, timeTF, 20, SpringLayout.SOUTH, customerTF);

        clientAddressTA.setPreferredSize(new Dimension(200, 100));
        clientAddressTA.setEnabled(false);
        getContentPane().add(clientAddressTA);
        springLayout.putConstraint(SpringLayout.WEST, clientAddressTA, 50, SpringLayout.EAST, customerTF);
        springLayout.putConstraint(SpringLayout.NORTH, clientAddressTA, 20, SpringLayout.SOUTH, updateJCheckBox);

        getContentPane().add(saveBtn);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, saveBtn, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, saveBtn, 20, SpringLayout.SOUTH, clientAddressTA);


        setSize(900, 900);



    }

    private void getItemsFromStockFile() {
        try {
            File file = new File("customers.txt");
            if(!file.exists()) file.createNewFile();
            else {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    stock.add(data);
                }
                scanner.close();
                stockJList.setListData(stock);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> getFromFile()
    {
        ArrayList<String> strings = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("customers.txt"));
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return strings;
    }

    private void saveOrderToFile() {
        try {

            FileWriter writer = new FileWriter("customers.txt",true);
            writer.write("Customer name: " + customerTF.getText() + "\n");
            writer.write("Address: " + clientAddressTA.getText() + "\n");
            writer.write("Time: " + timeTF.getText() + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/*
class Window extends JFrame {
    private Vector<String> stock = new Vector<>();
    private Vector<String> cart = new Vector<>();

    private String[] timeArr = {"9:00", "12:00", "15:00"};

    private JLabel onStockLb = new JLabel("On Stock");
    private JLabel cartLb = new JLabel("Cart");
    private JList<String> stockJList = new JList<>(stock);
    private JList<String> cartJList = new JList<>(cart);
    private JButton addBtn = new JButton("+");
    private JButton removeBtn = new JButton("-");
    private JButton saveBtn = new JButton("Save");
    private JCheckBox deliveryJCheckBox = new JCheckBox("Delivery");
    private JTextField nameTF = new JTextField("Sergei Mikhailovskii");
    private JTextArea addressTA = new JTextArea("City1\nHouse1");
    private JComboBox<String> preferableTimeJCB = new JComboBox<>(timeArr);

   // public static void main(String[] args) {
    //     new Window().setVisible(true);
    // }

    public Window() {
        super("Internet Shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initWindow();

        removeBtn.addActionListener(e -> {
            cart.remove(cartJList.getSelectedIndex());
            cartJList.setListData(cart);
        });

        addBtn.addActionListener(e -> {
            cart.add(stockJList.getSelectedValue());
            cartJList.setListData(cart);
        });

        deliveryJCheckBox.addActionListener(e -> {
            if (deliveryJCheckBox.isSelected()) {
                addressTA.setEnabled(true);
                preferableTimeJCB.setEnabled(true);
                nameTF.setEnabled(true);
            } else {
                addressTA.setEnabled(false);
                preferableTimeJCB.setEnabled(false);
                nameTF.setEnabled(false);
            }
        });

        saveBtn.addActionListener(e -> {
            saveOrderToFile();
        });

        getItemsFromStockFile();

    }

    @SuppressWarnings("Duplicates")
    private void initWindow() {
        SpringLayout springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout);

        getContentPane().add(onStockLb);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, onStockLb, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, onStockLb, 10, SpringLayout.NORTH, getContentPane());

        stockJList.setFixedCellWidth(250);
        getContentPane().add(stockJList);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, stockJList, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, stockJList, 10, SpringLayout.SOUTH, onStockLb);

        getContentPane().add(cartLb);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, cartLb, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, cartLb, 50, SpringLayout.SOUTH, stockJList);

        cartJList.setFixedCellWidth(250);
        getContentPane().add(cartJList);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, cartJList, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, cartJList, 10, SpringLayout.SOUTH, cartLb);

        addBtn.setPreferredSize(new Dimension(50, 20));
        getContentPane().add(addBtn);
        springLayout.putConstraint(SpringLayout.WEST, addBtn, 0, SpringLayout.WEST, cartJList);
        springLayout.putConstraint(SpringLayout.NORTH, addBtn, 0, SpringLayout.SOUTH, cartJList);

        removeBtn.setPreferredSize(new Dimension(50, 20));
        getContentPane().add(removeBtn);
        springLayout.putConstraint(SpringLayout.WEST, removeBtn, 0, SpringLayout.EAST, addBtn);
        springLayout.putConstraint(SpringLayout.NORTH, removeBtn, 0, SpringLayout.SOUTH, cartJList);

        getContentPane().add(deliveryJCheckBox);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, deliveryJCheckBox, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, deliveryJCheckBox, 50, SpringLayout.SOUTH, removeBtn);

        nameTF.setPreferredSize(new Dimension(200, 20));
        nameTF.setEnabled(false);
        getContentPane().add(nameTF);
        springLayout.putConstraint(SpringLayout.WEST, nameTF, 50, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, nameTF, 20, SpringLayout.SOUTH, deliveryJCheckBox);

        addressTA.setPreferredSize(new Dimension(200, 100));
        addressTA.setEnabled(false);
        getContentPane().add(addressTA);
        springLayout.putConstraint(SpringLayout.WEST, addressTA, 50, SpringLayout.EAST, nameTF);
        springLayout.putConstraint(SpringLayout.NORTH, addressTA, 20, SpringLayout.SOUTH, deliveryJCheckBox);

        getContentPane().add(preferableTimeJCB);
        preferableTimeJCB.setEnabled(false);
        springLayout.putConstraint(SpringLayout.WEST, preferableTimeJCB, 50, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, preferableTimeJCB, 20, SpringLayout.SOUTH, nameTF);

        getContentPane().add(saveBtn);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, saveBtn, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, saveBtn, 20, SpringLayout.SOUTH, addressTA);


        setSize(600, 600);
    }

    private void getItemsFromStockFile() {
        try {
            File file = new File("stock.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                stock.add(data);
            }
            scanner.close();
            stockJList.setListData(stock);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveOrderToFile() {
        try {
            FileWriter writer = new FileWriter(nameTF.getText() + ".txt");
            writer.write("Address: " + addressTA.getText() + "\n");
            writer.write("Time: " + Objects.requireNonNull(preferableTimeJCB.getSelectedItem()).toString() + "\n");

            for (String s : cart) {
                writer.write(s + " ");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}*/
