import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class Test1 {
    public static void main(String[] args) {
        myFrame exp1 = new myFrame();
    }
}

class myFrame extends JFrame {
    JPanel p1, p2; //两个面板
    JButton btn1; // 一个按钮
    JButton btn2; // 一个按钮

    JLabel label; // 一个文字
    JTextField text1, text2, text3;// 三个文本框

    //构造方法，进行初始化
    myFrame() {
        super("数据求和运算");// 窗口标题
        btn1 = new JButton("求和");
        btn2 = new JButton("清空");
        label = new JLabel("请输入两个数字:");
        text1 = new JTextField(8);
        text2 = new JTextField(8);
        text3 = new JTextField(12);
        text3.setEditable(false);
        p1 = new JPanel();
        p2 = new JPanel();
        //面板1含一个文字、两个文本框
        p1.add(label);
        p1.add(text1);
        p1.add(text2);
        //面板2含一个文本框、1个按钮
        p2.add(text3);
        p2.add(btn1);
        p2.add(btn2);
        // 设置面板1、面板2的背景色为蓝色、黄色
        p1.setBackground(Color.cyan);
        p2.setBackground(Color.red);
        //把面板1、面板2加入容器
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        btn1.addActionListener(new Ls1());// 添加监听1
        btn2.addActionListener(new Ls2());// 添加监听2
        setBounds(100, 100, 400, 200);
        setVisible(true);

    }

    class Ls1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try { // 异常处理
                double a, b;
                a = Double.parseDouble(text1.getText());
                b = Double.parseDouble(text2.getText());
                text3.setText("相加结果=" + (a + b));
            } catch (Exception e1) {
                text3.setText("请输入有效性数字!!");
                text1.setText("");
                text2.setText("");

            }
        }

    }

    class Ls2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            text3.setText("");
            text1.setText("");
            text2.setText("");
        }

    }

    /*public void actionPerformed(Acti onEvent e)// 事件处理
    {
        try { // 异常处理
            double a, b;
            a = Double.parseDouble(text1.getText());
            b = Double.parseDouble(text2.getText());
            text3.setText("相加结果=" + (a + b));
        } catch (Exception e1) {
            text3.setText("请输入有效性数字!!");
            text1.setText("");
            text2.setText("");
        }
    }*/

}

