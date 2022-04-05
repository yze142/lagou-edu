package controller;

import entity.FileSystem;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: xiaoyu-FastDFS
 * @description: 处理文件上传的文件控制类
 * @author: hello.xaioyu
 * @create: 2022-03-28 17:55
 **/

@RestController
public class FileAction {

    @Autowired
private     Redisson redisson;




    //MultipartHttpServletRequest：是httpservletRequest的强化版本，不仅可以装文本信 息，还可以装图片文件信息
    @RequestMapping("/upld")
    public String upld(MultipartHttpServletRequest request) throws IOException, MyException {
        //把文件保存到web服务器
        FileSystem fileSystem = new FileSystem();

        //1.从页面里获取文件
        MultipartFile fname = request.getFile("fname");
        //2.获取文件的原始名字
        String oldfname = fname.getOriginalFilename();
        //3.截取文件的后缀名
        String substring = oldfname.substring(oldfname.lastIndexOf(".") + 1);




        //4.生成新的文件名
        String newFilename = UUID.randomUUID().toString() + "." + substring;
        //5.把文件放到服务器的哪一个文件夹里捏
        File file = new File("G:/upload/" + newFilename);
        //6.文件进行上传
        fname.transferTo(file);
        //7.获取服务器的绝对路劲
        String absolutePath = file.getAbsolutePath();

        //把服务器中的文件上传到FastDfS
        // 加载配置文件
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
// 创建tracker客户端
        TrackerClient trackerClient = new TrackerClient();
// 通过tracker客户端获取tracker的连接服务并返回
        TrackerServer trackerServer = trackerClient.getConnection();
// 声明storage服务
        StorageServer storageServer = null;
        // 定义storage客户端
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);


        NameValuePair[] list=new NameValuePair[1];

        //文件原始名字
        list[0] =new NameValuePair("fileName",oldfname);

                //参数一文件路径，第二个是文件后缀名,第三个是文件源信息
        String fileID = client.upload_file1(absolutePath, substring, list);

        trackerServer.close();
        //封装文件实体类
        fileSystem.setFileId(fileID);
        fileSystem.setFileName(oldfname);
        fileSystem.setFilePath(fileID);





        return  "redirect:https://192.168.58.133/" +fileSystem.getFilePath();



    }

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        // 使用单个redis服务器
        config.useSingleServer().setAddress("redis://192.168.58.133:6379").setDatabase(0);
        // 使用集群redis
        // config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://192.168.204.141:6379","redis://192.168.204.142:6379","redis://192.168.204.143:6379");
        return (Redisson)Redisson.create(config);
    }




}
