package net.JPA;

public interface AbstractDao <T> {
   void insert(T t);
   void delete(T t);
}
