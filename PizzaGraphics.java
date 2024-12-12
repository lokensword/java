import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGraphics extends JFrame {
    private PizzaRepository repository;
    private JTextArea textArea;
    private JTextField nameField, priceField, weightField, diameterField;
    private JButton addButton, removeButton, updateButton;

    public PizzaGraphics() {
        repository = new PizzaRepository();
        
        createUI();
    }

    private void createUI() {
        setTitle("Лабораторная работа 6");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Название:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Цена:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Вес:"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Диаметр:"));
        diameterField = new JTextField();
        inputPanel.add(diameterField);

        add(inputPanel, BorderLayout.NORTH);

        addButton = new JButton("Добавить");
        removeButton = new JButton("Удалить");
        updateButton = new JButton("Обновить");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new AddPizzaAction());
        removeButton.addActionListener(new RemovePizzaAction());
        updateButton.addActionListener(new UpdatePizzaAction());

        setVisible(true);
    }

    private void updateTextArea() {
        textArea.setText("");
        for (Pizza pizza : repository.getAllPizzas()) {
            textArea.append(pizza.toString() + "\n");
        }
    }

    private class AddPizzaAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double diameter = Double.parseDouble(diameterField.getText());
            repository.addPizza(new Pepperoni(name, price, weight, diameter));
            updateTextArea();
        }
    }

    private class RemovePizzaAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            for (Pizza pizza : repository.getAllPizzas()) {
                if (pizza.toString().contains(name)) {
                    repository.removePizza(pizza);
                    break;
                }
            }
            updateTextArea();
        }
    }

    private class UpdatePizzaAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            for (int i = 0; i < repository.getAllPizzas().size(); i++) {
                Pizza pizza = repository.getAllPizzas().get(i);
                if (pizza.toString().contains(name)) {
                    double price = Double.parseDouble(priceField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    double diameter = Double.parseDouble(diameterField.getText());
                    repository.updatePizza(i, new Pepperoni(name, price, weight, diameter));
                    break;
                }
            }
            updateTextArea();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new PizzaGraphics());
    }
}