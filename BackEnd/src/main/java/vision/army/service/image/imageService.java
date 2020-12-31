package vision.army.service.image;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;
import vision.army.entity.*;

import org.apache.commons.io.*;

public class imageService {

    private String basePath ="images/";


    private Path providePath(Object o , MultipartFile file) {

          Path  path = null;
        if (o instanceof brand){
          brand brand = (brand) o;
//            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
          path= Paths.get(basePath+"brand/"+brand.getBrandID());
        }
        else
        if (o instanceof user){
            user user = (user) o;
            path= Paths.get(basePath+"brand/"+user.getUserID()+file.getOriginalFilename());

        }
        else
        if (o instanceof client){
            client client = (client) o;

        }
        else
        if (o instanceof productImage){
            productImage productImage = (productImage) o;
            path= Paths.get(basePath+"product/"+productImage.getPrdImID());
        }

            return path;
    }





    public void writeToFile(MultipartFile file , Object o) throws Exception {
        try {
            if (file ==null  ){
                System.out.println("no file");
            }else{
            Files.write(providePath(o,file),file.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
