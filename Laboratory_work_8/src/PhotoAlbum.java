import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class PhotoAlbum {
    static private JFrame frame = new JFrame();
    static private JPanel panelImage = new JPanel();
    static private JPanel panelButton = new JPanel();
    static private ImagePanel imagePanel = new ImagePanel();
    static String path="images";

    public static ImageIcon ImageIconResize(BufferedImage image, int width, int height) {
        try{
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = resizedImage.createGraphics();
            graphics.drawImage(image, 0, 0, width, height, null);
            graphics.dispose();
            return new ImageIcon(resizedImage);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ImageIcon();
        }
    }
    public static void viewButton(){
        File file = new File(path);
        path+="\\";
        String[] names = file.list();
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.Y_AXIS));
        for (int i=0;i<names.length;i++){
            JButton button = new JButton(names[i]);
            button.setPreferredSize(new Dimension(140,30));
            ActionListener listener=new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    panelImage.removeAll();
                    JButton button = (JButton) e.getSource();
                    String nameImage=button.getText();
                    imagePanel.setLayout(new BorderLayout());
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File(path+nameImage));
                        ImageIconResize(image,80,60);
                        imagePanel.setImage((Image) image);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    panelImage.add(imagePanel);
                    frame.validate();
                    frame.repaint();
                }
            };
            button.addActionListener(listener);
            panelButton.add(button);
        }
    }
    public static void main(String[] args) {
        frame.setTitle("Photo album");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelImage.setPreferredSize(new Dimension(580, 600));
        imagePanel.setPreferredSize(new Dimension(600, 600));
        panelButton.setPreferredSize(new Dimension(200, 600));
        viewButton();
        panelImage.add(new JScrollPane(imagePanel));
        frame.add(panelImage,BorderLayout.WEST);
        frame.add(panelButton,BorderLayout.EAST);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
