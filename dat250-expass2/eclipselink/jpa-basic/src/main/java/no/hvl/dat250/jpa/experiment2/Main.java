package no.hvl.dat250.jpa.experiment2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
  private static final String PERSISTENCE_UNIT_NAME = "todos";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      EntityManager em = factory.createEntityManager();
      // read the existing entries and write to console
      Query q = em.createQuery("select p from Person p");
      List<Person> personList = q.getResultList();
      for (Person person : personList) {
          System.out.println(person);
      }

      insertData();
  }

  private static void insertData() {
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();

    Person person = new Person();
    person.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    List<Address> addresses = new ArrayList<Address>();
    addresses.add(address);
    person.setAddress(addresses);

    List<Person> personList = new ArrayList<Person>();
    personList.add(person);
    address.setPersons(personList);

    Pincode pc = new Pincode();
    pc.setPincode("123");
    pc.setCount(1);

    CreditCard card1 = new CreditCard();
    card1.setBalance(-5000);
    card1.setLimit(-10000);
    card1.setNumber(12345);
    card1.setPincode(pc);

    CreditCard card2 = new CreditCard();
    card2.setBalance(-5000);
    card2.setLimit(-10000);
    card2.setNumber(12345);
    card2.setPincode(pc);

    List<CreditCard> creditCards = new ArrayList<CreditCard>();
    creditCards.add(card1);
    creditCards.add(card2);

    person.setCreditCards(creditCards);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    bank.setCreditCards(creditCards);

    card1.setBank(bank);
    card2.setBank(bank);

    em.persist(person); 
    em.persist(address);
    em.persist(pc);
    em.persist(card1);
    em.persist(card2);
    em.persist(bank);

    em.getTransaction().commit();

    em.close();
  }
}
