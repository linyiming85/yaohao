package server;
	import java.io.BufferedReader;  
	import java.io.IOException;  
	import java.io.InputStreamReader;  
	import java.io.OutputStreamWriter;  
	import java.net.MalformedURLException;  	  
	import javax.
	import javax.servlet.http.HttpServletResponse;  
	  

	public class weicharServer {
	    public static void post(HttpServletRequest request,HttpServletResponse response){  
	        String result = "";  
	        try {  
	            request.setCharacterEncoding("UTF-8");  
	            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));  
	            String line = "";  
	            StringBuffer buf = new StringBuffer();  
	            while ( (line = br.readLine()) != null ) {  
	                buf.append(line);  
	            }  
	            result = buf.toString();  
	             
	              
	            response.setHeader("cache-control", "no-cache");  
	            response.setCharacterEncoding("UTF-8");  
	            response.setContentType("text/html");  
	            OutputStreamWriter out = new OutputStreamWriter(response.getOutputStream());      
	            String xmlInfo = "mobile:用户号码|type:运营商标志|content:你好";  
	            out.write(DESHelper.doWork(xmlInfo, "01010101", 0));  
	            out.flush();  
	            out.close();  
	            //System.out.println("返回："+xmlInfo);   
	        } catch (MalformedURLException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        //return "toff :  "+result;   
	    }  
	}  

