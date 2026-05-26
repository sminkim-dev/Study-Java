package Univ.chap_6;

class Book{
    private String byName;
    private String bookName;
    private String buyName;
    public Book(String byName, String bookName, String buyName){
        this.byName = byName;
        this.bookName = bookName;
        this.buyName = buyName;
    }
    @Override
    public String toString(){
        return buyName + "이 구입한 도서 " + byName + "의 " + bookName;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Book){
            Book b = (Book) obj;
            if(b.bookName.equals(this.bookName)){
                return true;
            }
        }
        return false;
    }
}

public class ex_6_2 {
    public static void main(String[] args){
        Book a =new Book("황기태", "명품자바", "김하진");
        Book b = new Book("황기태", "명품자바", "하여린");
        System.out.println(a);
        System.out.println(b);
        if(a.equals(b)){
            System.out.println("같은 책");
        }
        else{
            System.out.println("다른 책");
        }
    }
}
