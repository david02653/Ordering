package ordering;

import springfox.documentation.service.ObjectVendorExtension;
import springfox.documentation.service.VendorExtension;

import java.io.*;
import java.net.URL;
import java.util.*;

import java.util.List;


public class ContractAnalyzer {


    public ContractAnalyzer() {
    }



    public List<VendorExtension> swaggerExtension(String basePackage) throws IOException {
        ObjectVendorExtension extension = new ObjectVendorExtension("x-serviceDependency");


        return Collections.singletonList(extension);
    }

    public void testt() throws IOException {

        readfile("/ordering/contracts/" + "ordering" + ".groovy");
    }

    public void readfile(String filepath) throws FileNotFoundException, IOException {

        URL base = this.getClass().getResource("");
        System.out.println(base);


        InputStream is = this.getClass().getResourceAsStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s = "";
        StringBuilder sb = new StringBuilder("");
        while( (s=br.readLine()) != null)
            sb.append(s).append("\n");
        System.out.println(sb.toString());
    }
}
