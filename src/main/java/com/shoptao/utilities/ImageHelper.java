/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoptao.utilities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author haih7
 */
public class ImageHelper {
    public static Image resize(Image originalImage, int targetWith, int targetHeight){
      Image resultingImage = originalImage.getScaledInstance(targetWith, targetHeight, Image.SCALE_SMOOTH);
    return resultingImage;
    }
    
    public static byte[] toByteArray(Image img, String tybe) throws IOException{
        BufferedImage  bimage = new BufferedImage(img.getWidth(null),img.getHeight(null) , BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0,null);
        g.dispose();
          
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
         baos.flush();
        ImageIO.write(bimage, tybe, baos);
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }
    
    public static Image createImageFromByteArray(byte [] data ,String type) throws IOException{
        InputStream bis = new ByteArrayInputStream(data);
        BufferedImage bIamge2 = ImageIO.read(bis);
        Image img = bIamge2.getScaledInstance(bIamge2.getWidth(), bIamge2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
