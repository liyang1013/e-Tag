package com.keboda.eomsback.utils;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDFUtils {



    /**
     * 获取电子发票pdf文件中的发票信息
     *
     * @param filePath 电子发票路径
     * @return 发票信息
     */
    public String getInvoiceInfo(String filePath) {
        try {
            List<BufferedImage> imageList = extractImage(new File(filePath));
            if (imageList.isEmpty()) {
                return null;
            }

            MultiFormatReader formatReader = new MultiFormatReader();
            //正常解析出来有3张图片，第一张是二维码，其他两张图片是发票上盖的章
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(imageList.get(0))));
            Map hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            Result result = formatReader.decode(binaryBitmap);
            if (result == null) {

                return null;
            }


            return result.getText();

        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 提取电子发票里面的图片
     *
     * @param pdfFile 电子发票文件对象
     * @return pdf中解析出的图片列表
     * @throws Exception
     */
    private List<BufferedImage> extractImage(File pdfFile) throws Exception {
        List<BufferedImage> imageList = new ArrayList<BufferedImage>();

        PDDocument document =  Loader.loadPDF(pdfFile);
        PDPage page = document.getPage(0); //电子发票只有一页
        PDResources resources = page.getResources();

        for (COSName name : resources.getXObjectNames()) {
            if (resources.isImageXObject(name)) {
                PDImageXObject obj = (PDImageXObject) resources.getXObject(name);
                imageList.add(obj.getImage());
            }
        }
        document.close();
        return imageList;
    }
}
