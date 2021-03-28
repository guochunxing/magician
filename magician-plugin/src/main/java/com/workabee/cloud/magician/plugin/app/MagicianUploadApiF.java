package com.workabee.cloud.magician.plugin.app;

import com.workabee.cloud.magician.plugin.model.SelectItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * author: chunxing
 * date: 2021/3/15 15:14
 * description:
 */
public class MagicianUploadApiF extends JDialog {


    private JButton buttonOK;
    private JButton buttonCancel;


    public MagicianUploadApiF(List<SelectItem> items) {
        super();
        JPanel jPanel = new JPanel();
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        jPanel.setLayout(gridBag);


        JLabel jLabel = new JLabel("请选择注册到 Magician 的 API 接口:");
        jLabel.setFont(new Font("楷体", Font.BOLD, 16));
        gridBag.setConstraints(jLabel, constraints);
        jPanel.add(jLabel);

        JComboBox comboBox = new JComboBox();    //创建JComboBox
        for (SelectItem item : items) {
            comboBox.addItem(item.getName());
        }
        Dimension dimension = new Dimension(50, 5);
        comboBox.setSize(dimension);
        gridBag.setConstraints(comboBox, constraints);
        jPanel.add(comboBox);
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        setContentPane(jPanel);
        centerDialog();
        setModal(true);
        this.pack();
        this.setVisible(true);
        listener();
    }


    private void listener() {
        buttonOK.addActionListener(e -> {

        });
        buttonCancel.addActionListener(e -> {
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void centerDialog() {
        this.setPreferredSize(new Dimension(600, 300));
        //获取屏幕的尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //获取屏幕的宽
        int screenWidth = screenSize.width;
        //获取屏幕的高
        int screenHeight = screenSize.height;
        //设置窗口居中显示
        this.setLocation(screenWidth / 2 - 800 / 2, screenHeight / 2 - 600 / 2);
    }
}
