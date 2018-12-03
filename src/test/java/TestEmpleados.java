import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.GregorianCalendar;
import java.util.List;
import hibernate.modelos.Empleado;



public class TestEmpleados {

    private static EntityManagerFactory ent =  Persistence.createEntityManagerFactory("MiPersistencia");;

    public static void main(String[] args){
        /* Creamos el gestor de persistencia EM */

        EntityManager man = ent.createEntityManager();
        Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(2017, 11, 23).getTime());
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();
        imprimirTodo();

        EntityManager manager = ent.createEntityManager();
        manager.getTransaction().begin();
       // Empleado e = manager.find(Empleado.class, 10L);
        e.setNombre("David");
        manager.merge(e);
        manager.getTransaction().commit();

        manager.close();
        imprimirTodo();
    }

    private static void InsertInicial() {
        EntityManager man = ent.createEntityManager();
        Empleado e = new Empleado(10L, "Perez", "Pepito", new GregorianCalendar(2017, 11, 23).getTime());
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();
    }

    @SuppressWarnings("unchecked")
    public static void imprimirTodo(){
        EntityManager manager = ent.createEntityManager();
        List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("Hay " + empleados.size() + " empleados en el sistema");
        for (Empleado emp : empleados){
            System.out.println(emp.toString());
        }

    }
}
