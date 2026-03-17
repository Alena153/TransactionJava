import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Mytransaction {
    List<Transaction> trans;

    public Mytransaction() {
        trans = new ArrayList<>();
    }

    public void print() {
        //вывести все операции
        for (Transaction c: trans) {
            c.show();
        
        }
    }
    public void add(Transaction op) {
        // ДОБАВЛЕНИЕ операции
        trans.add(op);
    }
    public void add(String data, int summa, String category, Boolean type) {
           //добавление операции
          trans.add(new Transaction(data, summa, category, type));
    }

    public void save() {
        //сохранение в файл
        try (FileWriter wr = new FileWriter("transact.csv")) {
            for (Transaction c : trans) {

            
            wr.write(c.data + " " + c.summa + " " + c.category + " " + c.type + "\n");
            }
        } catch (Exception ex) {
            System.out.println("error save");
           }

    }
    
    public void load() {
          // загрузка из файла
        try (BufferedReader br = new BufferedReader(new FileReader("transact.csv"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] input = line.split(" ", 4);
                if (input.length <= 4) {
                    String data = input [0];
                    int summa = Integer.parseInt(input[1]);
                    String category = input [2];
                    boolean type = Boolean.parseBoolean(input[3]);
                    trans.add(new Transaction(data, summa, category, type));

                } 
            }
        }
        
            catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
            }
    }

       public Transaction findByData(String data) {
          //поиск по дате
          for (Transaction c : trans) {
            if (c.data.equals(data)) {
                return c;
            }
          }
          return null;
       }
       public Transaction findBySumma(int summa) {
        //поиск по сумме
        for (Transaction c : trans) {
            if (c.summa == summa) {
                return c;
            }
          }
          return null;
       }

       public void removeData(String date) {
        // удаление по  дате
        for (int i = 0; i < trans.size(); i++) {
            if (trans.get(i).data.equals(date)) {
                trans.remove(i);
                break;
            }
        }
      }
      public void removeSumma(int summa) {
        // удаление по  сумме
        for (int i = 0; i < trans.size(); i++) {
            if (trans.get(i).summa == summa) {
                trans.remove(i);
                break;
            }
        }
      }
         
     public int balance() {
       int  bal = 0;
        for (Transaction c : trans) {
            if (c.type == true ) {
                bal = bal + c.summa;
          } else {
            bal = bal - c.summa;
          }
          
       }
        return bal;
    }

    
}