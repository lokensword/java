import org.example.Binary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrayManager extends JFrame {
    private JTextArea textArea;
    private JTextField sizeField, elementField, searchField;
    private JButton btnSort, btnSearch;
    private int[] array;

    public ArrayManager() {
        createUI();
    }

    private void createUI() {
        setTitle("Array Manager");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Размер массива:"));
        sizeField = new JTextField();
        inputPanel.add(sizeField);

        inputPanel.add(new JLabel("Элементы массива (через запятую):"));
        elementField = new JTextField();
        inputPanel.add(elementField);

        inputPanel.add(new JLabel("Искомый элемент:"));
        searchField = new JTextField();
        inputPanel.add(searchField);

        add(inputPanel, BorderLayout.NORTH);

        btnSort = new JButton("Сортировать");
        btnSearch = new JButton("Поиск");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSort);
        buttonPanel.add(btnSearch);
        add(buttonPanel, BorderLayout.SOUTH);

        btnSort.addActionListener(new SortArrayAction());
        btnSearch.addActionListener(new SearchArrayAction());

        setVisible(true);
    }

    private class SortArrayAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int size = Integer.parseInt(sizeField.getText());
            String[] elements = elementField.getText().split(",");
            array = new int[size];

            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(elements[i].trim());
            }

            Binary.bubbleSort(array, size);
            updateTextArea();
        }
    }

    private void updateTextArea() {
        textArea.setText("Отсортированный массив:\n");
        for (int i = 0; i < array.length; i++) {
            textArea.append("Элемент array[" + i + "]:" + array[i] + "\n");
        }
    }

    private class SearchArrayAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int valueToFind = Integer.parseInt(searchField.getText());
            int resultIndex = Binary.binarySearch(array, valueToFind, 0, array.length - 1);

            if (resultIndex == -1) {
                textArea.append("Элемент не найден\n");
            } else {
                textArea.append("Искомый элемент имеет индекс " + resultIndex + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArrayManager());
    }
}