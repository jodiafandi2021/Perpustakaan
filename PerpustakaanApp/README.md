### Class Diagram

```mermaid
classDiagram
    Perpustakaan <|-- Member
    Perpustakaan <|-- VipMember
    Perpustakaan "1"--o"*" Book : has
    
    class Perpustakaan{
      <<abstract>>
      #int ID
      #String name
      #String address
      +int nextID()
    }
    
    class Member{
      -String gender
      -String birthdate
    }
    class VipMember{
      -String contact
    }
    class Book{
      -StringbookName
      -double bookNumber
      +deposite(double amt)
      +withdraw(double amt)
      +double getBalance()
    }
            
```

### ER Diagram

```mermaid
erDiagram
          PERPUSTAKAAN ||..|| MEMBER-PERPUS : is
          PERPUSTAKAAN ||--|| VIPMEMBER-PERPUS : is
          PERPUSTAKAAN ||--|{ BOOK: "has"
          PERPUSTAKAAN {
            int id
            string name
            string adress
          }
          MEMBER-PERPUS{
            string gender
            string birthdate
          }
          VIPMEMBER-PERPUS{
            string contact
          }
          BOOK{
            String bookName
            double bookNumber
          }
```
### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Perpustakaan <|-- Member
    Perpustakaan <|-- VipMember
    Perpustakaan "1"--o"*" Book : has
    Perpustakaan o-- PerpustakaanDataModel : Data Modeling
    PerpustakaanDataModel <-- PerpustakaanDataController : Data Control
    PerpustakaanDataModel --> DBConect : DB Connection
    PerpustakaanDataModel <.. PerpustakaanForm : Form Control      

    class Perpustakaan{
      <<abstract>>
      #IntegerProperty ID
      #StringProperty name
      #StringProperty address
   
      
      +IntegerProperty nextID()
    }
    
    class Member{
      -StringProperty gender
      -StringProperty birthdate
    }
    class VipMember{
      -StringProperty contact
    }
    class Book{
      -StringProperty bookName
      -DoubleProperty bookNumber
      +deposite(double amt)
      +withdraw(double amt)
      +double getBalance()
    }

    class PerpustakaanDataModel{
        Connection conn
        addPerpustakaan()
        addBook()
        getMember()
        getVipMember()
        nextMemberID()
        nextVipMember()
    }

    class PerpustakaanController{
        initialize()
        handleButtonAddMember()
        handleButtonAddVipMember()
        loadDataMember()
        loadDataVipMember()
        loadDataBook()
        handleClearForm()
    }
    class DBConect{
        - String USERNAME
        - String PASSWORD
        - String DB
        getConnection()
        getConnection(String driver)
        createTable();
    }
            
```
