package xin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : 小新青年
 * @date : 2019-11-26  16:06
 * 描述 : 文件上传控制器
 **/
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        // 规划上传代码的保存路径为项目运行目录下的 uploadFile ,并根据日期划分文件夹保存
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
        String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            boolean mkdirs = folder.mkdirs();
        }

        String newName = System.currentTimeMillis() + uploadFile.getOriginalFilename();
        try {
            // 保存文件
            uploadFile.transferTo(new File(folder, newName));
            return "文件上传成功,路径是 --> " + request.getScheme() + "://" + request.getServerName() + ":"
                    + request.getServerPort() + "/uploadFile/" + format + newName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
