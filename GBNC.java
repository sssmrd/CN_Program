//-----------------Client of Go-Back-N ARQ---------------------------------
import java.io.*;
import java.net.*;
import java.util.*;
class GBNC
{
    public static void main(String args[]) throws Exception
    {
        Socket s=new Socket("localhost",4000);
        
        DataOutputStream out =new DataOutputStream(s.getOutputStream());
        BufferedInputStream in= new BufferedInputStream(s.getInputStream());
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\n Enter no of frames to receive=");
        int c=sc.nextInt();
        out.write(c);
        System.out.println("\n Enter mode error=0 or error=1");
        int err=sc.nextInt();
        
        out.write(err);
        if(err==0)
        {
            for(int j=0;j<c;j++)
            {
                int i=in.read();
                System.out.println("Received frame"+i);
                System.out.println("Sending ack for "+i);
                out.write(i);
            }
        }
        else
        {
            int check=0;
            for(int j=0;j<c;j++)
            {
                int i=in.read();
                
                if(i==check)
                {
                    System.out.println("Received frame "+i);
                    System.out.println("Sending ack for frame "+i);
                    out.write(i);
                    check++;
                }
                else
                {
                    j--;
                    System.out.println("Discarding frame "+i);
                    System.out.println("Sending nack");
                    out.write(-1);
                    
                }
            }
        }
        
    
    }
}
