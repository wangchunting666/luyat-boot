package com.ly.tls.image.base;

import com.ly.tls.image.vo.PressImage;
import com.ly.tls.image.vo.PressText;

import java.io.IOException;

/**
 * Created by Herdsric-M-003 on 2018/7/10.
 */
public interface IImage {
    void realize(String orginImg, String img, int width, int height);
    void realize(String orginImg, String img, float realize);
    void rotate(String orginImg, String img, int width, int height, double depree);
    void imagePress(PressImage pressImage);
    void textPress(PressText pressText);
    void makeCircularImg(String srcFilePath, String circularImgSavePath, int targetSize, int cornerRadius) throws IOException;
}
