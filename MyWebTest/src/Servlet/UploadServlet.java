package Servlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
 
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Map<String,String> map=new HashMap<String,String>();
    private String username;
    private String password;
	
    public UploadServlet() {
        super();
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("require .getContenType"+req.getContentType());
    	resp.setContentType("text/html,charset=utf-8");
    	Writer o=resp.getWriter();
    	
    	if(ServletFileUpload.isMultipartContent(req)){
    		req.setCharacterEncoding("utf-8");
    		//缓存
    		DiskFileItemFactory factory=new DiskFileItemFactory();
    		factory.setSizeThreshold(1024000);
    		
    		ServletFileUpload sfu=new ServletFileUpload(factory);
    		sfu.setHeaderEncoding("utf-8");
    		sfu.setFileSizeMax(1024000000);
    		sfu.setSizeMax(2048000000);
    		
    		List<FileItem> list=null;
    		try {
    			list=sfu.parseRequest(req);
    			System.out.println("list size:"+list.size());
    		}catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    		Iterator<FileItem> iter=list==null?null:list.iterator();
    		while(iter!=null&&iter.hasNext()) {
    			FileItem item=(FileItem) iter.next();
    			if(item.isFormField()) {
    				System.out.println("表单");
    				//item.getFieldName() 获得Map的键  item.getString()获得Map值
    				System.out.println("FileName:"+item.getFieldName());
    				System.out.println(new String(item.getString("utf-8")));
    				
    				if(item.getFieldName().equalsIgnoreCase("password")) {
    					password=new String(item.getString("utf-8"));
    				}
    				if(item.getFieldName().equalsIgnoreCase("username")) {
    					username=new String(item.getString("utf-8"));
    				}
    				
    				
    			}else if (!item.isFormField()){
    				//item.getName(); 获得文件名
    				System.out.println("源文件:"+item.getName());
    	
    				String filename=item.getName();
    				if(filename.indexOf("\\")>=0) {
    					filename=item.getName().substring(item.getName().lastIndexOf("\\"));
    				}
    				BufferedInputStream in = new BufferedInputStream(item.getInputStream());
    				
    				
//    				String path=req.getSession().getServletContext().getRealPath("/")+"/"+username+"/";
    				String path="F://Picture//Upload"+"//"+username+"//";
    				path+=filename;
    				File file=new File(path);
    				File fileParent=file.getParentFile();
    				//判断是否存在
    				if(!fileParent.exists()) {
    					fileParent.mkdirs();
    				}
    				
    				BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(file));
    				
    				Streams.copy(in, out, true);
                    o.write("文件上传成功");
            		System.out.println("目标文件:" + path);
    			}
    		}
    	}else {
            System.out.println("表单的Content-Type错误");
        } 
    	
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	this.doPost(req, resp);
    }
    
   
}

//Map map = new HashMap(); 
//Iterator entries = map.entrySet().iterator(); 
//while (entries.hasNext()) { 
//  Map.Entry entry = (Map.Entry) entries.next(); 
//  Integer key = (Integer)entry.getKey(); 
//  Integer value = (Integer)entry.getValue(); 
//  System.out.println("Key = " + key + ", Value = " + value); 
//}

//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    DiskFileItemFactory factory=new DiskFileItemFactory();
//    ServletFileUpload upload=new ServletFileUpload(factory);
//
//    request.setCharacterEncoding("utf-8");
//    //文件名中文乱码处理也可以如此写
////    upload.setHeaderEncoding("utf-8");
//
//    //设置缓冲区大小与临时文件目录
//    factory.setSizeThreshold(1024*1024*10);
//    File uploadTemp=new File("e:\\uploadTemp");
//    uploadTemp.mkdirs();
//    factory.setRepository(uploadTemp);
//
//    //设置单个文件大小限制
//    upload.setFileSizeMax(1024*1024*10);
//    //设置所有文件总和大小限制
//    upload.setSizeMax(1024*1024*30);
//
//    try {
//        List<FileItem> list=upload.parseRequest(request);
//        System.out.println(list);
//        for (FileItem fileItem:list){
//            if (!fileItem.isFormField()&&fileItem.getName()!=null&&!"".equals(fileItem.getName())){
//                String filName=fileItem.getName();
//                //利用UUID生成伪随机字符串，作为文件名避免重复
//                String uuid= UUID.randomUUID().toString();
//                //获取文件后缀名
//                String suffix=filName.substring(filName.lastIndexOf("."));
//
//                //获取文件上传目录路径，在项目部署路径下的upload目录里。若想让浏览器不能直接访问到图片，可以放在WEB-INF下
//                String uploadPath=request.getSession().getServletContext().getRealPath("/upload");
//                System.out.println("uploadPath :"+uploadPath);
//                File file=new File(uploadPath);
//                file.mkdirs();
//                //写入文件到磁盘，该行执行完毕后，若有该临时文件，将会自动删除
//                fileItem.write(new File(uploadPath,uuid+suffix));
//                
//            }
//        }
//    }  catch (Exception e) {
//        e.printStackTrace();
//    }
//}
//
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    doPost(request,response);
//}

//文件名中文乱码处理：servletFileUpload.setHeaderEncoding("utf-8") 或 request.setCharacterEncoding("utf-8");
//表单普通字段中文乱码处理：new String(str.getBytes("iso-8859-1","utf-8"));
//设置内存缓冲区的大小，默认为10KB：diskFileItemFactory.setSizeThreshold(1024*1024);
//指定临时文件目录，如果单个文件的大小超过内存缓冲区，该文件将会临时缓存在此目录下：diskFileItemFactory.setRepository(file);
//设置单个文件大小限制，如果有某个文件超过此大小，将抛出FileUploadBase.FileSizeLimitExceededException：servletFileUpload.setFileSizeMax(1024*1024*10);
//设置所有文件，也就是请求大小限制，如果文件总和超过此大小，将抛出FileUploadBase.SizeLimitExceededException：servletFileUpload.setSizeMax(1024*1024*20);
//利用UUID生成伪随机字符串作为文件名避免重复：UUID.randomUUID().toString();
//将文件写到硬盘上。写完之后，系统会自动将放在临时文件目录的该文件删除：fileItem.write(new File(path,fileName));
//--------------------- 
//作者：零怀念 
//来源：CSDN 
//原文：https://blog.csdn.net/linghuainian/article/details/82253247 
//版权声明：本文为博主原创文章，转载请附上博文链接！

//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    DiskFileItemFactory factory=new DiskFileItemFactory();
//    ServletFileUpload upload=new ServletFileUpload(factory);
//    try {
//        List<FileItem> list=upload.parseRequest(request);
//        for (FileItem fileItem:list){
//            System.out.println("fieldName:"+fileItem.getFieldName());//获得表单项的name属性
//            System.out.println("name:"+fileItem.getName());//获得文件字段的文件名
//            System.out.println("string:"+fileItem.getString());//获得字段的内容
//            System.out.println("contentType:"+fileItem.getContentType());//获得上传文件的类型
//            System.out.println("size:"+fileItem.getSize()+"byte");//获取文件内容的大小
//            System.out.println("isFieldForm:"+fileItem.isFormField());//判断是否是普通表单字段
//            System.out.println("inputStream:"+ org.apache.commons.io.IOUtils.toString(fileItem.getInputStream()));//获得文件内容的输入流
//            System.out.println("*************");
//        }
//    } catch (FileUploadException e) {
//        e.printStackTrace();
//    }
//}
//
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    doPost(request,response);
//}
