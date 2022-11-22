import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class computer extends JFrame implements ActionListener {

    // 创建5个控件对象
    JLabel lab1, lab2; // 2个文本控件
    JTextField tf1, tf2; // 1个文本框控件
    JButton btn; // 1个按钮控件

    String sfz, tz;
    String jg;

    // 构造方法，进行初始化，为界面添加控件、设置布局、按钮的监听
    computer() {
        this.setTitle("判断身份证号是否有效");
        Container cp = this.getContentPane();// 初始化一个容器
        cp.setLayout(new FlowLayout(FlowLayout.CENTER));// 控件位于界面的中间靠上位置

        lab1 = new JLabel("身份证号：  "); // 设置第1个文本控件的内容为"身份证号：  "
        lab2 = new JLabel("结          果： "); // 设置第2个文本控件的内容为"结          果： "
        tf1 = new JTextField(12); // 设置文本框的宽度，数字越大则越宽
        tf2 = new JTextField(12);
        btn = new JButton("查询"); // 设置按钮控件的内容为"查询"

        // 将5个控件分别加入到容器（界面）
        cp.add(lab1);
        cp.add(tf1);
        cp.add(lab2);
        cp.add(tf2);
        cp.add(btn);

        this.setSize(260, 150);// 设置窗体的大小，宽度260像素、高度150像素
        this.setLocation(300, 300);// 设置窗体在屏幕的位置（原点在屏幕左上角）
        this.setVisible(true);// 设置窗体可见
        btn.addActionListener(this);// 点击按钮btn，触发actionPerformed()
        tf2.setEditable(false); // 设置第2个文本框只读
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sfz = tf1.getText();
        //补充代码
        try {
            if (sfz.length() != 18) {
                tf2.setText("身份证号码位数不正确!请检查是否有误");
            } else {
                for (int i = 0; i < 17; i++) {
                    String s = sfz.charAt(i) + "";
                    int j = Integer.parseInt(s);
                }
                if (sfz.charAt(17) == 'X' || sfz.charAt(17) == 'x') {
                    tf2.setText("身份证号码正确,谢谢配合");
                } else {
                    String s1 = sfz.charAt(17) + "";
                    int k = Integer.parseInt(s1);
                    tf2.setText("身份证号码正确,谢谢配合");
                }
            }
        } catch (NumberFormatException e1) {
            tf2.setText("身份证号码不全为数字");
        }
    }

    public static void main(String[] args) {
        computer rmb=new computer();
    }
}