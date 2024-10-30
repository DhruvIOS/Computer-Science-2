public class LibaryClient {
    public static void main(String[] args) {

        Book book = new Book("123456", "To Kill a Mockingbird", 5, "Harper Lee");
        System.out.println("Display info about a book");
        System.out.println(book);
        

        book.checkOut();
        System.out.println("After the book was checked out, the number of copies changed. The new info is:");
        System.out.println(book);
        

        book.addItem(1);
        System.out.println("After a new copy of this book was added, the number of copies changed. The new info is:");
        System.out.println(book);
        

        JournalPaper journal = new JournalPaper("789012", "Research on AI", 3, "John Doe", 2022);
        System.out.println("\nDisplay info about a journal paper");
        System.out.println(journal);
        

        journal.checkOut();
        System.out.println("After the journal paper was checked out, the number of copies changed. The new info is:");
        System.out.println(journal);
        

        Video video = new Video("1111", "The Godfather", 3, 215, "Francis Ford Coppola", "Drama", 1981);
        System.out.println("\nDisplay info about a video");
        System.out.println(video);
        

        video.checkOut();
        System.out.println("After the video was checked out, the number of copies changed. The new info is:");
        System.out.println(video);
        

        video.checkIn();
        System.out.println("After the video was checked in, the number of copies changed. The new info is:");
        System.out.println(video);
        

        CD cd = new CD("2222", "Thriller", 4, 42, "Michael Jackson", "Pop");
        System.out.println("\nDisplay info about a CD");
        System.out.println(cd);
        

        cd.checkOut();
        System.out.println("After the CD was checked out, the number of copies changed. The new info is:");
        System.out.println(cd);
        

        cd.checkIn();
        System.out.println("After the CD was checked in, the number of copies changed. The new info is:");
        System.out.println(cd);
    }
}