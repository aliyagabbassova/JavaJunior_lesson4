package ru.geekbrains.lesson4.homework4;
import java.util.Random;
public class SchoolDB {

        private static int id;
        private String title;
        private int duration;

    private static final String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };

    private static final Random random = new Random();

    public static SchoolDB create() {
        return new SchoolDB(id, names[random.nextInt(names.length)], random.nextInt(20, 26));
    };
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void updateDuration(){
        duration = random.nextInt(20, 26);
    }

    public SchoolDB(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        }


    @Override
        public String toString() {
            return "SchoolDb{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", duration=" + duration +
                    '}';
        }

    public void updateID() {
        id = random.nextInt(1, 50);
    }

    public void updateTitle() {
        title = names[random.nextInt(names.length)];
    }

}





