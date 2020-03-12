import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class phoneap {
    public static void main(String[] args) throws ServiceException, MalformedURLException {

        String endpoint = "http://localhost:8080/axis/Phone.jws";

        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));

        System.out.println("1 - enter the performance");
        System.out.println("2 - enter the date");
        System.out.println("3 - exit");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            line = in.readLine();
            while (!line.equals("3")) {
                if (line.equals("3")) break;
                if (line.equals("1")) {
                    System.out.println("Input the name of the performance");
                    String nm = in.readLine();

                    Object[] param1 = new Object[]{nm};

                    String response = (String) call.invoke("prod_name", param1);

                    System.out.println("Performance is " + nm + "\n" + "Date is " + response+ "\n"+ "\n");

                    System.out.println("1 - Enter the performance");
                    System.out.println("2 - enter the date");
                    System.out.println("3 - exit");
                    line = in.readLine();
                }
                if (line.equals("2")) {
                    System.out.println("Input the date of the performance");
                    String pr = in.readLine();
                    Object[] param2 = new Object[]{pr};
                    String response = (String) call.invoke("price_num", param2);
                    System.out.println("Performance is " + pr +"\n" + "Date is " + response);

                    System.out.println("1 - enter the performance");
                    System.out.println("2 - enter the date");
                    System.out.println("3 - exit");
                    line = in.readLine();
                }
                ;
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

