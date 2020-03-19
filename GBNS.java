import java.io.*;
import java.net.*;

class GBNS
{
        public static void main(String args[]) throws Exception
        {       
                ServerSocket ser=new ServerSocket(4 000);
                Socket s= ser.accept();
                
                BufferedInputStream in=new BufferedInputStream(s.getInputStream());
                DataOutputStream out=new DataOutputStream(s.getOutputStream());
                
                int p=in.read();
                int err=in.read();
                
                if(err==0)
                {
                    for(int j=0;j<p;j++)
                    {
                        System.out.println("Sending frame"+j);
                        out.write(j);
                        System.out.println("Waiting for ack of"+j);
                        
                        Thread.sleep(2000);
                        
                        int i=in.read();
                        System.out.println("Received ack for frame"+i);
                    }
                }
                else
                {
                      boolean arr[]=new boolean[p];
                      for(int j=0;j<p;j++)
                      {
                            if(j==2)
                                System.out.println("Sending frame "+j);
                            else
                            {
                                System.out.println("Sending frame "+j);
                                out.write(j);
                                System.out.println("Waiting for ack "+j);
                                Thread.sleep(2000);
                                int a=in.read();
                                System.out.println("Received ack "+a+" for frame "+j);
                                if(a!=255)
                                    arr[a]=true;
                                    
                            }                    
                      }
                      for(int i=0;i<p;i++)
                      {
                        if(!arr[i])
                        {
                            System.out.println("Retransmitting frame "+i);
                            out.write(i);
                            System.out.println("Waiting for ack "+i);
                                Thread.sleep(2000);
                                int a=in.read();
                            System.out.println("Received ack "+a+" for frame "+i);
                             arr[a]=true;        
                        }
                      }
                }
                
        }
}
