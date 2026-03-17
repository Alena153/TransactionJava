public class Transaction {
    public String data;
    public int summa;
    public String category;
    public boolean type;

    public Transaction() {
        data = "";
        summa = 0;
        category = "";
        type = true;
    }

    public Transaction(String data, int summa, String category, Boolean type) {
        this.data = data;
        this.summa = summa;
        this.category = category;
        this.type = type;
    }

        public void show(){
            String typeText = type ? " | Пополнение" : " | Списание";
             System.out.println("Дата: " + data + " | Cумма: " + summa + " | Категория: " + category + typeText);
             /*if (type) {
             System.out.println("Тип: Пополнение");
             } else {
                System.out.println("Тип: Списание");
             }*/
        } 

    }


    

