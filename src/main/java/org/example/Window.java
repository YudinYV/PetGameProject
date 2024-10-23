package org.example;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    private String petName;
    private int hpCount = 100;
    private int happinessCount = 100;


    public static void setWindowInCenter(Frame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocationRelativeTo(null);
    }

    public Window() {
        super("Ваш питомец");
        setSize(600, 600);
        setWindowInCenter(Window.this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel Button = new JPanel();
        Button.setLayout(new BoxLayout(Button, BoxLayout.Y_AXIS));
        JPanel petInfo = new JPanel();
        petInfo.setLayout(new BoxLayout(petInfo, BoxLayout.Y_AXIS));
        JLabel yourPet = new JLabel("Ваши питомцы: ");
        petInfo.add(yourPet);
        petInfo.add(Box.createRigidArea(new Dimension(0, 10)));
        JButton addNewPet = new JButton("Добавить питомца");
        Button.add(addNewPet);
        container.add(Button);
        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(petInfo);

        addNewPet.addActionListener(e -> {
            JFrame newPet = new JFrame("Создание нового питомца");
            newPet.setSize(400, 200);
            newPet.setLayout(new FlowLayout());

            JLabel petChoice = new JLabel("Выберите какого питомца вы хотите добавить: ");
            JPanel petView = new JPanel();
            JRadioButton dog = new JRadioButton("Собака");
            JRadioButton cat = new JRadioButton("Кошка");
            ButtonGroup petViewButtonGroup = new ButtonGroup();
            petViewButtonGroup.add(dog);
            petViewButtonGroup.add(cat);
            petView.add(dog);
            petView.add(cat);

            JPanel petNameText = new JPanel();
            JLabel petNameTextText = new JLabel("Введите имя питомца");
            JTextField name = new JTextField(15);
            petNameText.add(petNameTextText);
            petNameText.add(name);

            JPanel okButtonLabel = new JPanel();
            JButton okButton = new JButton("OK");
            okButton.addActionListener(e1 -> {
                petName = name.getText();
                newPet.dispose();

                JPanel petInteraction = new JPanel();
                petInteraction.setLayout(new BoxLayout(petInteraction, BoxLayout.Y_AXIS));
                JLabel petNameLabel = new JLabel(petName);
                JButton feed = new JButton("Покормить");
                JButton drink = new JButton("Напоить");
                JButton stroke = new JButton("Погладить");
                petInteraction.add(petNameLabel);
                petInteraction.add(feed);
                petInteraction.add(drink);
                petInteraction.add(stroke);
                petInteraction.add(Box.createRigidArea(new Dimension(0, 10)));

                JPanel petInfoBar = new JPanel();
                petInfoBar.setLayout(new BoxLayout(petInfoBar, BoxLayout.Y_AXIS));
                if (petViewButtonGroup.getSelection() == dog.getModel()) {
                    JLabel petInfoText = new JLabel("Статус вашей собаки: ");
                    petInfoBar.add(petInfoText);
                } else if (petViewButtonGroup.getSelection() == cat.getModel()) {
                    JLabel petInfoText = new JLabel("Статус вашей кошки: ");
                    petInfoBar.add(petInfoText);
                }
                petInfoBar.add(Box.createRigidArea(new Dimension(0, 10)));

                JPanel hpBar = new JPanel();
                hpBar.setLayout(new BoxLayout(hpBar, BoxLayout.Y_AXIS));
                JLabel hp = new JLabel("Уровень здоровья: " + hpCount);
                hpBar.add(hp);
                hpBar.add(Box.createRigidArea(new Dimension(0, 10)));

                JPanel happinessBar = new JPanel();
                happinessBar.setLayout(new BoxLayout(happinessBar, BoxLayout.Y_AXIS));
                JLabel happiness = new JLabel("Уровень счастья: " + happinessCount);
                happinessBar.add(happiness);
                happinessBar.add(Box.createRigidArea(new Dimension(0, 10)));

                container.add(petInfoBar);
                container.add(petInteraction);
                container.add(hpBar);
                container.add(happinessBar);
                container.revalidate();
                container.repaint();
            });
            okButtonLabel.add(okButton);
            newPet.add(petChoice);
            newPet.add(petView);
            newPet.add(petNameText);
            newPet.add(okButtonLabel);
            newPet.setVisible(true);
            setWindowInCenter(newPet);
        });

    }
}
