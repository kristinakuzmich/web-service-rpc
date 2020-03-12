import java.io.*;
import java.util.*;

public class Phone{

    public String prod_name(String price){

        String prod= new String();;
        String line;
        try{
            FileReader fr = new FileReader("D:\\products.txt");
            BufferedReader in = new BufferedReader(fr);
            while ((line=in.readLine())!=null){
                String[] str = line.split(" ");
                if (str[0].equals(price)){
                    prod=str[1]; break;
                }
                else
                    prod="NO SUCH PRODUCT";
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return prod;
    }


    public String price_num (String prod){

        String price= new String();;
        String line;
        try{
            FileReader fr = new FileReader("D:\\products.txt");
            BufferedReader in = new BufferedReader(fr);

            while ((line=in.readLine())!=null){
                String[] str = line.split(" ");
                if (str[1].equals(prod)){
                    price=str[0];
                break;
                }
                else
                    price="NO SUCH PRICE";
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return price;
    }
}
