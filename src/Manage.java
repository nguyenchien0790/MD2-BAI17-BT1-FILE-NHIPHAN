import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manage extends Product{
    public void addProductByList(String path, List<Product> product) throws IOException {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
    }

    public List<Product> showProduct(String path) throws IOException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        products = (List<Product>) ois.readObject();
        ois.close();
        fis.close();
       return products;
    }
    public void findInformation(List<Product> products,int id) throws IOException, ClassNotFoundException {
        for (int i = 0; i < products.size(); i++) {
            if (id==products.get(i).getId()){
                System.out.println(products.get(i));
            }
        }
    }

}
