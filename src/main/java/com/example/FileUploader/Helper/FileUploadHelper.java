package com.example.FileUploader.Helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR="E:\\uploaded_files";

    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean f = false;
        try{
//            Other Way
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f = true;

            //            One Way

//            InputStream is = multipartFile.getInputStream();
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
//            fos.write(data);
//            fos.flush();
//            is.close();
//            f=true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
}
