import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Mytransaction transact = new Mytransaction();
        transact.load();
    

    Scanner input = new Scanner(System.in,  "CP866");


    while(true) {
      
        System.out.println("1. Добавить операцию");
        System.out.println("2. Показать историю операций");
        System.out.println("3. Поиск операций по сумме");
        System.out.println("4. Поиск операций по дате");
        System.out.println("5. Показать текущий баланс");
        System.out.println("6. Удаление операции по дате");
        System.out.println("7. Удаление операции по сумме");
        System.out.println("0. Выход");

        String user = input.next();

        if (user.equals("1")) {
                input.nextLine();
                System.out.println("Введите дату 'ДД.ММ.ГГГГ': ");
                String date = input.nextLine().trim().toLowerCase();
                System.out.println("Введите категорию: ");
                String category = input.nextLine().trim().toLowerCase();
                System.out.println("Введите сумму: ");
                int summa = input.nextInt();
                System.out.println("Введите тип пополнение/списание: ");
                input.nextLine();
                String types = input.nextLine().trim().toLowerCase();
                Boolean type;
                if (types.equals("пополнение")) {
                    type = true;
                } else {
                    type = false;
                }
                 transact.add(date, summa, category, type);
              


        } else if (user.equals("2")) {
          transact.print();

        } else if (user.equals("3")){
                input.nextLine();
                System.out.println("Введите сумму: ");
                int summa = input.nextInt();
                try { 
                    transact.findBySumma(summa).show();

                } catch (Exception ex) {
                    System.out.println("Операции не существует ");
                }

        } else if (user.equals("4")){
                input.nextLine();
                System.out.println("Введите дату 'ДД.ММ.ГГГГ': ");
                String date = input.nextLine();
               
                try { 
                       transact.findByData(date).show();
    
                } catch (Exception ex) {
                    System.out.println("Операции не существует");
                }
        } else if (user.equals("6")) {
                 input.nextLine();
                System.out.println("Введите дату: ");
                String date = input.nextLine();
            
                      transact.removeData(date);

        } else if (user.equals("7")) {
                 input.nextLine();
                System.out.println("Введите сумму: ");
                int summa = input.nextInt();
            
                      transact.removeSumma(summa);


        } else if (user.equals("0")) {
                break;
        
        } else if (user.equals("5")) {
            
            System.out.println("Текущий баланс: " + transact.balance() + " рублей");
        }

        
    }

       input.close();
       transact.save();
    }
}
    
