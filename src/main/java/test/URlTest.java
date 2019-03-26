package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URlTest {
    public static void main(String[] args) throws IOException, InterruptedException {
            	
        try {
            URL url=new URL("https://blog.csdn.net/yuqnfendetiankong/article/details/76163888");
            //通过url的openstream方法来获取url对象所表示资源的字节输入流
            InputStream is=url.openStream();
            //之后把它转化成字符输入流
            InputStreamReader isr=new InputStreamReader(is);
            //为字符输入流添加缓冲
            BufferedReader br=new BufferedReader(isr);
            String data=br.readLine();
            String htmlCode = data;
            while(data!=null){
                data=br.readLine();
                htmlCode=htmlCode+data;
            }
            List<String> imgsrc=getImageSrc(htmlCode);
            for (String string : imgsrc) {
				System.out.println(string);
			}
            br.close();
            isr.close();
            is.close();
 
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getImageSrc(String htmlCode) {
        List<String> imageSrcList = new ArrayList<String>();
        Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(htmlCode);
        String quote = null;
        String src = null;
        while (m.find()) {
            quote = m.group(1);
            src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);
            imageSrcList.add(src);
        }
        return imageSrcList;
    }
    public static void fileCopy(String oldFilePath,String newFilePath) throws IOException, InterruptedException {
    	URL oldFilePath1= new URL(oldFilePath);
    	File newFilePath1= new File(newFilePath);
    	
    	InputStream fileInputStream=oldFilePath1.openStream();
    	OutputStream oStream= new FileOutputStream(newFilePath1);
    	BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
    	while((bufferedInputStream.read())!=-1) {
    		 System.out.println(bufferedInputStream.read());
    		 oStream.wait();
    	}
    }
   
}

