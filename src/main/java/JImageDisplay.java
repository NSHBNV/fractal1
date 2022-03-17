import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class JImageDisplay extends JComponent
{
    /**
     * Экземпляр изображения
     */
    private BufferedImage image;

    /**
     * Метод получения отображаемого изображения из другого класса.
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Конструктор принимает целые значения ширины и высоты и инициализирует
     * объект image класса Buffered image с шириной width и высотой height
     * типа изображения TYPE_INT_RGB.
     */
    public JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);

    }
    /**
     * Отрисовка в компоненте
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(),
                image.getHeight(), null);
    }

    //Делает картинку черной
    public void clearImage()
    {
        int[] blankArray = new int[getWidth() * getHeight()];
        image.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }

    // Заливает пиксель определенным цветом
    public void drawPixel(int x, int y, int rgbColor)
    {
        image.setRGB(x, y, rgbColor);
    }
}