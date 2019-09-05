package cn.cumt.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 32;

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);

        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width - 1,height - 1);

        Random random = new Random();
        String str = "abcdefghijklmnopqrstuvwxyzABDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for (int i = 1; i <= 4; i++) {

            int index = random.nextInt(str.length());
            char ch = str.charAt(index);

            graphics.drawString(ch + "",width / 5 * i,height / 2);
        }

        graphics.setColor(Color.GREEN);

        for (int i = 0; i < 10; i++) {

            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);
        }


        ImageIO.write(image,"jpg",response.getOutputStream());



    }
}
